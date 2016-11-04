package com.example.demo_ManHua;

import java.net.URLEncoder;

import com.example.demo_ManHua.utils.Http_Matter_Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

/**
 * 漫画具体内容列表
 * 
 * @author X-man
 * @date 2016-11-3
 */
public class ThridActivity extends Activity {
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		// 初始化框件
		mListView = (ListView) findViewById(R.id.second_list);
		// 接受上一个界面传来的数据
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		int id = intent.getIntExtra("id", 0);
		// 定义网址
		String httpname = URLEncoder.encode(name);
		String url = "http://japi.juhe.cn/comic/chapterContent?comicName="
				+ httpname + "&id=" + id
				+ "&key=5b16e687e500f7f4c97596a7d6add257";
		// 调用工具类
		Http_Matter_Utils.getmatter(url, mListView, this);
	}
}
