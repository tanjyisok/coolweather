package com.coolweather.app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;
import com.coolweather.app.model.WeatherCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nvshen on 2016/5/21.
 */
public class CoolweatherDB {
    public static final String DB_NAME = "cool_weather";

    public static final int VERSION = 4;

    private static CoolweatherDB coolweatherDB;

    private SQLiteDatabase db;

    private CoolweatherDB(Context context){
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public synchronized static CoolweatherDB getInstance(Context context){
        if(coolweatherDB == null){
            coolweatherDB = new CoolweatherDB(context);
        }
        return coolweatherDB;
    }

    public void saveProvince(Province province){
        if(province != null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }

    public List<Province> loadProvinces(){
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void saveCities(City city){
        if(city != null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            values.put("province_id",city.getProvinceID());
            db.insert("City",null,values);
        }
    }

    public List<City> loadCities(int provinceID){
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City",null,"province_id=?",new String[]{String.valueOf(provinceID)},null,null,null);
        if(cursor.moveToFirst()){
            do{
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(provinceID);
                list.add(city);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void saveCounties(County county){
        if(county != null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            values.put("city_id",county.getCityID());
            db.insert("County",null,values);
        }
    }

    public List<County> loadCounties(int cityID){
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County",null,"city_id=?",new String[]{String.valueOf(cityID)},null,null,null);
        if(cursor.moveToFirst()){
            do{
                County County = new County();
                County.setId(cursor.getInt(cursor.getColumnIndex("id")));
                County.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                County.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                County.setCityId(cityID);;
                list.add(County);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void saveWeatherCode(WeatherCode weatherCode){
        if (weatherCode != null){
            ContentValues values = new ContentValues();
            values.put("weather_code",weatherCode.getWeatherCode());
            values.put("weather_code_city",weatherCode.getWeatherCodeCity());
            db.insert("WeatherCode",null,values);
        }
    }

    public String loadWeatherCode(String weatherCodeCity){
        List<WeatherCode> list = new ArrayList<WeatherCode>();
        String a;
        Cursor cursor = db.query("WeatherCode",null,"weather_code_city=?",new String[]{weatherCodeCity},null,null,null);
        if (cursor.moveToFirst()){
            do {
                WeatherCode weatherCode = new WeatherCode();
                weatherCode.setWeatherCode(cursor.getString(cursor.getColumnIndex("weather_code")));
                weatherCode.setWeatherCodeCity(weatherCodeCity);
                list.add(weatherCode);
            }while (cursor.moveToNext());
        }
        a = list.get(0).getWeatherCode();
        return a;
    }
}
