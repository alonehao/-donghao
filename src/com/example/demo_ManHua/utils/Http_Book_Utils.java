package com.example.demo_ManHua.utils;

import java.net.URLEncoder;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.demo_ManHua.MainActivity;
import com.example.demo_ManHua.SecondActivity;
import com.example.demo_ManHua.adapter.BookGridAdapter;
import com.example.demo_ManHua.bean.BookBean;

/**
 * 根据漫画类型查找漫画书的工具类
 * 
 * @author X-man
 * @date 2016-11-2
 */
public class Http_Book_Utils {
	
	//得到漫画书列表的方法
	public static void getbookjson(String type, GridView gv_book,
			Context context) {
		String url = URLEncoder.encode(type);
		String url1 = "http://japi.juhe.cn/comic/book?name=&type=" + url
				+ "&skip=&finish=&key=5b16e687e500f7f4c97596a7d6add257";
		MyBookTask mybooktask = new MyBookTask(gv_book, context);
		mybooktask.execute(url1);
	}
	//漫画书相关的AsyncTask类
	static class MyBookTask extends AsyncTask<String, Void, List<BookBean>> {
		private GridView gv_book;
		private Context mContext;

		public MyBookTask(GridView gv_book, Context mContext) {
			super();
			this.gv_book = gv_book;
			this.mContext = mContext;
		}

		@Override
		protected List<BookBean> doInBackground(String... params) {
			String url = params[0];
			List<BookBean> list = Http_Book_Json_Utils.getlist(Http_Utils
					.getstr(url));
			return list;

		}

		@Override
		protected void onPostExecute(final List<BookBean> result) {
			//给gridview绑定适配器
			gv_book.setAdapter(new BookGridAdapter(result, mContext));
			//gridview的条目点击事件
			gv_book.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Intent intent=new Intent(mContext,SecondActivity.class);
					intent.putExtra("name", result.get(position).name);
					mContext.startActivity(intent);
				}
			});
		}

	}
}
