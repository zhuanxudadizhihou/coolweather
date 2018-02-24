package com.example.a61685.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 61685 on 2018/2/21.
 */

/**
 * 发送请求
 */
public class HttpUtil {
    public static void sentOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
