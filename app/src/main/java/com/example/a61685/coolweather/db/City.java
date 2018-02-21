package com.example.a61685.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 61685 on 2018/2/20.
 */

public class City extends DataSupport {
    private int id;
    private int provinceId;
    private int cityCode;
    private String cityName;

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
