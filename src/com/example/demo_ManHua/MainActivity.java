package com.example.demo_ManHua;

import com.example.demo_ManHua.utils.Http_Book_Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends Activity implements OnClickListener{
	private Button mBtn_younth_girl,mBtn_younth,mBtn_younth_boy,mBtn_danmei;
	private GridView mGV_book;
	private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initview();
    }
    //初始化视图的方法
	private void initview() {
		mBtn_danmei=(Button) findViewById(R.id.button_danmei);
		mBtn_younth=(Button) findViewById(R.id.button_youth);
		mBtn_younth_boy=(Button) findViewById(R.id.button_young_boy);
		mBtn_younth_girl=(Button) findViewById(R.id.button_young_girl);
		mGV_book=(GridView) findViewById(R.id.gr_book);
		mContext=this;
		mBtn_danmei.setOnClickListener(this);
		mBtn_younth.setOnClickListener(this);
		mBtn_younth_boy.setOnClickListener(this);
		mBtn_younth_girl.setOnClickListener(this);
	}
	//各个按钮的监听事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_danmei:
			Http_Book_Utils.getbookjson("耽美漫画", mGV_book, mContext);
			break;

		case R.id.button_young_boy:
			Http_Book_Utils.getbookjson("少年漫画", mGV_book, mContext);
			break;
		case R.id.button_young_girl:
			Http_Book_Utils.getbookjson("少女漫画", mGV_book, mContext);
			break;
		case R.id.button_youth:
			Http_Book_Utils.getbookjson("青年漫画", mGV_book, mContext);
			break;
		}
	}
}
