package com.example.demo_ManHua.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo_ManHua.R;
import com.example.demo_ManHua.bean.ChapterBean;

public class ChapterAdapter extends BaseAdapter{
	private List<ChapterBean> mList;
	private Context mContext;
	public ChapterAdapter(List<ChapterBean> mList, Context mContext) {
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
		ChapterViewHolder holder;
		if(convertView==null){
			convertView=View.inflate(mContext,R.layout.chapter_item_layout ,null);
			holder=new ChapterViewHolder();
			holder.nameTV=(TextView) convertView.findViewById(R.id.chapter_item_nametv);
			convertView.setTag(holder);
		}
		else{
			holder=(ChapterViewHolder) convertView.getTag();
		}
		holder.nameTV.setText(mList.get(position).getName());
		return convertView;
	}
	class ChapterViewHolder{
		TextView nameTV;
	}
}
