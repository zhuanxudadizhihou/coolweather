package com.example.a61685.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 61685 on 2018/2/21.
 */

public class Forecast {
    public String data;
    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("cond")
    public More more;
    public class Temperature{
        public String max;
        public String min;
    }
    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
