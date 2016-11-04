package com.example.demo_ManHua.adapter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.example.demo_ManHua.R;
import com.example.demo_ManHua.bean.BookBean;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.core.BitmapCache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

public class BookGridAdapter extends BaseAdapter {
	private List<BookBean> mList;
	private Context mContext;

	public BookGridAdapter(List<BookBean> mList, Context mContext) {
		super();
		this.mList = mList;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.book_item_layout,
					null);
			holder = new ViewHolder();
			holder.mNameTV = (TextView) convertView
					.findViewById(R.id.item_name);
			holder.mPiciv = (ImageView) convertView
					.findViewById(R.id.item_piciv);
			holder.mTypeTV = (TextView) convertView
					.findViewById(R.id.item_type);
			holder.mAreaTV = (TextView) convertView
					.findViewById(R.id.item_area);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.mNameTV.setText(mList.get(position).name);
		holder.mAreaTV.setText(mList.get(position).area);
		holder.mTypeTV.setText(mList.get(position).type);
		BitmapUtils bit = new BitmapUtils(mContext);
		bit.display(holder.mPiciv, mList.get(position).coverImg);
		
		return convertView;
	}

	class ViewHolder {
		ImageView mPiciv;
		TextView mNameTV, mTypeTV, mAreaTV;
	}
}
