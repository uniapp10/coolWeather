package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.Country;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhudong on 2017/8/25.
 */

public class Utility {

    public static boolean handleProvinceResponse(String response) {

        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public  static  boolean handleCityResponse(String response, int provinceId){
        if (!TextUtils.isEmpty(response)){
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
            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        return false;
    }

    public static boolean handleCountryResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject countryObj = jsonArray.getJSONObject(i);
                    Country country = new Country();
                    country.setCountryName(countryObj.getString("name"));
                    country.setWeatherId(countryObj.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        return false;
    }


    public static Weather handelWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");

            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
