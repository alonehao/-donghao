package com.example.demo_ManHua.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.demo_ManHua.R;
import com.example.demo_ManHua.bean.MatterBean;
import com.lidroid.xutils.BitmapUtils;

public class MatterAdapter extends BaseAdapter{
	private List<MatterBean> mList;
	private Context mContext;
	public MatterAdapter(List<MatterBean> mList, Context mContext) {
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
		MatterViewHolder holder;
		if(convertView==null){
			convertView=View.inflate(mContext, R.layout.activity_thrid, null);
			holder=new MatterViewHolder();
			holder.piciv=(ImageView) convertView.findViewById(R.id.thrid_pic);
			convertView.setTag(holder);
		}else{
			holder=(MatterViewHolder) convertView.getTag();
		}
		BitmapUtils bitmap=new BitmapUtils(mContext);
		bitmap.display(holder.piciv, mList.get(position).getImageUrl());
		return convertView;
	}
	class MatterViewHolder{
		ImageView piciv;
	}
	
}
