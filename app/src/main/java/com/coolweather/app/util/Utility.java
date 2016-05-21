package com.coolweather.app.util;

import android.text.TextUtils;

import com.coolweather.app.db.CoolweatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

/**
 * Created by nvshen on 2016/5/21.
 */
public class Utility {

    public synchronized static boolean handleProvinceResponse(CoolweatherDB coolweatherDB,String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0){
                for (String p : allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    coolweatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(CoolweatherDB coolweatherDB,String response,int provinceID){
        if (!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0){
               for (String c : allCities){
                   String[] array = c.split("\\|");
                   City city = new City();
                   city.setCityCode(array[0]);
                   city.setCityName(array[1]);
                   city.setProvinceId(provinceID);
                   coolweatherDB.saveCities(city);
               }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCountiesResponse(CoolweatherDB coolweatherDB,String response,int cityID){
        if (!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0){
                for (String c : allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityID);
                    coolweatherDB.saveCounties(county);
                }
                return true;
            }
        }
        return false;
    }

}
