package com.example.a61685.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 61685 on 2018/2/21.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
