package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhudong on 2017/8/29.
 */

public class Weather {
    public String status;

    public  AQI aqi;

    public  Basic basic;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;

    public Now now;

    public Suggestion suggestion;

}
