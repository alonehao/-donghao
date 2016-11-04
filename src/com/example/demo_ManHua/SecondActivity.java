package com.example.demo_ManHua;

import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.demo_ManHua.utils.Http_Chapter_Utils;

/**
 * 显示漫画章节
 * 
 * @author X-man
 * @date 2016-11-3
 */
public class SecondActivity extends Activity {
	private String mName;
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		// 获得上个界面传来的书名
		Intent intent = getIntent();
		mName = intent.getStringExtra("name");
		String http_name = URLEncoder.encode(mName);
		// 初始化框件
		mListView = (ListView) findViewById(R.id.second_list);
		// 获得网络的地址
		String url = "http://japi.juhe.cn/comic/chapter?comicName=" + http_name
				+ "&skip=&key=5b16e687e500f7f4c97596a7d6add257";
		//调用章节的工具类
		Http_Chapter_Utils.getchapterlist(url, mListView, this,mName);
	}
}
