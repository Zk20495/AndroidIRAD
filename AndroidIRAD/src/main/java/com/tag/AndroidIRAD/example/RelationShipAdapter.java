package com.tag.AndroidIRAD.example;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tag.AndroidIRAD.R;
import com.tag.AndroidIRAD.lazyload.ImageLoader;

public class RelationShipAdapter extends BaseAdapter {

	private ArrayList<HashMap<String, String>> usersInfo;
	private LayoutInflater inflater;
	private ImageLoader imageLoader;

	public RelationShipAdapter(Context context,
			ArrayList<HashMap<String, String>> usersInfo) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.usersInfo = usersInfo;
		this.imageLoader = new ImageLoader(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = inflater.inflate(R.layout.relationship_inflater, null);
		Holder holder = new Holder();
		holder.ivPhoto = (ImageView) view.findViewById(R.id.ivImage);
		holder.tvFullName = (TextView) view.findViewById(R.id.tvFullName);
		holder.tvFullName.setText(usersInfo.get(position).get(
				Relationship.TAG_USERNAME));
		imageLoader.DisplayImage(
				usersInfo.get(position).get(Relationship.TAG_PROFILE_PICTURE),
				holder.ivPhoto);
		return view;
	}

	private class Holder {
		private ImageView ivPhoto;
		private TextView tvFullName;
	}

	@Override
	public int getCount() {
		return usersInfo.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
