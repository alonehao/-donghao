package com.example.demo_ManHua.utils;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.demo_ManHua.ThridActivity;
import com.example.demo_ManHua.adapter.ChapterAdapter;
import com.example.demo_ManHua.bean.ChapterBean;

/**
 * 请求章节网络的相关操作
 * 
 * @author X-man
 * @date 2016-11-3
 */
public class Http_Chapter_Utils {
	public static void getchapterlist(String url, ListView mListView,
			Context mContex,String mName) {
		MyChapterTask mat=new MyChapterTask(mListView, mContex,mName);
		mat.execute(url);
	}

	static class MyChapterTask extends AsyncTask<String, Void, List<ChapterBean>> {
		private ListView mListview;
		private Context mContext;
		private String mName;

		

		public MyChapterTask(ListView mListview, Context mContext, String mName) {
			super();
			this.mListview = mListview;
			this.mContext = mContext;
			this.mName = mName;
		}
		@Override
		public List<ChapterBean> doInBackground(String... params) {
			String url = params[0];
			List<ChapterBean> list = Http_Chapter_Json_Utils
					.getlist_second(Http_Utils.getstr(url));
			return list;
		}
		@Override
		protected void onPostExecute(final List<ChapterBean> result) {
			mListview.setAdapter(new ChapterAdapter(result, mContext));
			//点击章节的时候跳转到对应的内容
			mListview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Intent intent=new Intent(mContext,ThridActivity.class);
					intent.putExtra("name", mName);
					intent.putExtra("id",result.get(position).getId());
					mContext.startActivity(intent);
				}
			});
		}

	}
}
