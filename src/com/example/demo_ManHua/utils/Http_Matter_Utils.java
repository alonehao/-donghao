package com.example.demo_ManHua.utils;

import java.util.List;

import com.example.demo_ManHua.adapter.MatterAdapter;
import com.example.demo_ManHua.bean.MatterBean;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

public class Http_Matter_Utils {
	public static void getmatter(String url, ListView list, Context context) {
		MyMatterTask mmt=new MyMatterTask(list, context);
		mmt.execute(url);
	}

	static class MyMatterTask extends AsyncTask<String, Void, List<MatterBean>> {
		private ListView mListView;
		private Context mContext;

		public MyMatterTask(ListView mListView, Context mContext) {
			super();
			this.mListView = mListView;
			this.mContext = mContext;
		}

		@Override
		protected List<MatterBean> doInBackground(String... params) {
			String url = params[0];
			List<MatterBean> list = Http_Matter_Json_Utils
					.getmatterlist(Http_Utils.getstr(url));
			return list;
		}
		@Override
		protected void onPostExecute(List<MatterBean> result) {
			mListView.setAdapter(new MatterAdapter(result, mContext));
		}
	}
}
