package com.example.getgluedemo;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pojo.Show;

public class InteractiveArrayAdapter extends ArrayAdapter<Show> {

	private final List<Show> list;
	private final Activity context;

	public InteractiveArrayAdapter(Activity context, List<Show> list) {
		super(context, R.layout.rowlayout, list);
		this.context = context;
		this.list = list;
	}

	static class ViewHolder {
		protected TextView text;
		protected ImageView thumbnail;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {
			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(R.layout.rowlayout, null);
			final ViewHolder viewHolder = new ViewHolder();
			viewHolder.text = (TextView) view.findViewById(R.id.label);
			viewHolder.thumbnail = (ImageView) view
					.findViewById(R.id.imageView1);

			view.setTag(viewHolder);
		} else {
			view = convertView;
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.text.setText(list.get(position).getTitle());
		holder.thumbnail.setImageBitmap(list.get(position).getThumb()); 
		return view;
	}

}
