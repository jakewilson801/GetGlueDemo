package com.example.getgluedemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.pojo.Show;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends ListActivity {

	public ProgressBar pb;
	public String json;
	public List<Show> items;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		
		new DownloadDataTask()
				.execute(new String[] { "https://api.getglue.com/v3/guide/trending/tv_shows?access_token=62604FEF59CD744CBE17B7D79ED58E" });
	}

	public void renderList(List<Show> items) {
		ArrayAdapter<Show> adapter = new InteractiveArrayAdapter(this, items);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick (ListView l, View v, int position, long id){
		Intent i = new Intent(MainActivity.this, DetailsActivity.class);
		i.putExtra("id", items.get(position).getId()); 
		startActivity(i); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class DownloadDataTask extends AsyncTask<String, Void, String> {
		@Override
		protected void onPreExecute() {
			pb.setVisibility(View.VISIBLE);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected String doInBackground(String... urls) {
			String response = "";
			for (String url : urls) {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(url);
				try {
					HttpResponse execute = client.execute(httpGet);
					InputStream content = execute.getEntity().getContent();

					BufferedReader buffer = new BufferedReader(
							new InputStreamReader(content));
					String s = "";
					while ((s = buffer.readLine()) != null) {
						response += s;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			Type listType = new TypeToken<List<Show>>() {
			}.getType();

			items = (List<Show>) new Gson().fromJson(response, listType);

			for(Show s : items){
				s.setThumb(loadBitmap(s.getImages().getThumbnail())); 
			}
			
			return response;
		}

		@Override
		protected void onPostExecute(String result) {
			pb.setVisibility(View.INVISIBLE);
			renderList(items);
		}
	}

	public Bitmap loadBitmap(String url) {
		Bitmap bitmap = null;
		try {
			bitmap = BitmapFactory.decodeStream((InputStream) new URL(url)
					.getContent());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bitmap;
	}

}
