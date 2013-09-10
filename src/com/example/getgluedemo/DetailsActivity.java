package com.example.getgluedemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pojo.Summary;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DetailsActivity extends Activity {
	public ProgressBar pb;
	public TextView likes;
	public TextView dislikes;
	public ImageView banner;
	public TextView summary;
	public TextView reviews;
	public Summary summaryData;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		banner = (ImageView) findViewById(R.id.imageView1);
		likes = (TextView) findViewById(R.id.textView3);
		dislikes = (TextView) findViewById(R.id.textView4);
		summary = (TextView) findViewById(R.id.summary);
		reviews = (TextView) findViewById(R.id.textView6); 
		Bundle b = getIntent().getExtras();
		String id = b.getString("id");

		new DownloadDataTask()
				.execute(new String[] { "https://api.getglue.com/v3/" + id
						+ "?access_token=62604FEF59CD744CBE17B7D79ED58E" });
		
	}

	public void renderScreen(Summary data) {
		banner.setImageBitmap(data.getBanner());
		likes.setText(String.valueOf(data.getObject().getStats().getLikes())); 
		dislikes.setText(String.valueOf(data.getObject().getStats().getDislikes())); 
		summary.setText(String.valueOf(data.getObject().getSummary())); 
		reviews.setText(String.valueOf(data.getObject().getStats().getReviews())); 
	}

	private class DownloadDataTask extends AsyncTask<String, Void, String> {
		@Override
		protected void onPreExecute() {
			pb.setVisibility(View.VISIBLE);
		}

	
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

			Type listType = new TypeToken<Summary>() {
			}.getType();

			summaryData = (Summary) new Gson().fromJson(response, listType);
			summaryData.setBanner(loadBitmap(summaryData.getObject().getImages()
					.getHeader_small()));

			return response;
		}

		@Override
		protected void onPostExecute(String result) {
			pb.setVisibility(View.INVISIBLE);
			renderScreen(summaryData);
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
