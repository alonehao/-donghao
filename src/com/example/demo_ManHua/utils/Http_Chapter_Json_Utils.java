package com.example.demo_ManHua.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.demo_ManHua.bean.BookBean;
import com.example.demo_ManHua.bean.ChapterBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * 解析章节的json串
 * @author X-man
 * @date 2016-11-3
 */
public class Http_Chapter_Json_Utils {
	public static List<ChapterBean> getlist_second(String json) {
		try {
			JSONArray optJSONArray = new JSONObject(json).optJSONObject(
					"result").optJSONArray("chapterList");
			List<ChapterBean> list = new Gson().fromJson(
					optJSONArray.toString(),
					new TypeToken<List<ChapterBean>>() {
					}.getType());
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
