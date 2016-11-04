package com.example.demo_ManHua.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.demo_ManHua.bean.BookBean;
import com.example.demo_ManHua.bean.ChapterBean;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Http_Book_Json_Utils {
	//解析漫画书的json串
	public static List<BookBean> getlist(String json){
		try {
			// 解析Json串
			JSONObject jsonObject = new JSONObject(json);
			JSONObject jsonObject2 = jsonObject.optJSONObject("result");
			JSONArray ja = jsonObject2.optJSONArray("bookList");
			List<BookBean> list = new Gson().fromJson(ja.toString(),
					new TypeToken<List<BookBean>>() {
					}.getType());
			return list;
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
