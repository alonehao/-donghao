package com.example.demo_ManHua.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.demo_ManHua.bean.ChapterBean;
import com.example.demo_ManHua.bean.MatterBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 解析具体内容的json串
 * 
 * @author X-man
 * @date 2016-11-3
 */
public class Http_Matter_Json_Utils {
	public static List<MatterBean> getmatterlist(String json) {
		try {
			JSONObject ja = new JSONObject(json);
			JSONArray js1 = ja.optJSONObject("result")
					.optJSONArray("imageList");
			List<MatterBean> list = new Gson().fromJson(js1.toString(),
					new TypeToken<List<MatterBean>>() {
					}.getType());
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
