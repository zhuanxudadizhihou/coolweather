package com.example.a61685.coolweather.util;

import android.text.TextUtils;

import com.example.a61685.coolweather.db.City;
import com.example.a61685.coolweather.db.Count;
import com.example.a61685.coolweather.db.Province;
import com.example.a61685.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 61685 on 2018/2/21.
 */

/**
 * 解析JSON数据
 */
public class Utilty {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static Boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounts = new JSONArray(response);
                for (int i = 0; i < allCounts.length(); i++) {
                    JSONObject countObject = allCounts.getJSONObject(i);
                    Count count = new Count();
                    count.setCountName(countObject.getString("name"));
                    count.setWeatherId(countObject.getString("weather_id"));
                    count.setCityId(cityId);
                    count.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
