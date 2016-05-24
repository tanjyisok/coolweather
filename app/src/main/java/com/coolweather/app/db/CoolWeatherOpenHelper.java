package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nvshen on 2016/5/21.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

    /**
     * Province表建表语句
     */
    public static final String CREATE_PROVINCE = "create table Province(" +
            "id integer primary key autoincrement," +
            "province_name text," +
            "province_code text)";

    /**
     * City表建表语句
     */
    public static final String CREATE_CITY = "create table City(" +
            "id integer primary key autoincrement," +
            "city_name text," +
            "city_code text," +
            "province_id integer)";

    /**
     *Counrtry表建表语句
     */
    public static final String CREATE_COUNTY = "create table County(" +
            "id integer primary key autoincrement," +
            "county_name text," +
            "county_code text," +
            "city_id integer)";

    public static final String CREATE_WEATHERCODE = "create table WeatherCode("+
            "id integer primary key autoincrement,"+
            "weather_code text,"+
            "weather_code_city text)";

    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建Province表
        db.execSQL(CREATE_CITY);//创建City表
        db.execSQL(CREATE_COUNTY);//创建Country表
        db.execSQL(CREATE_WEATHERCODE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Province");
        db.execSQL("drop table if exists City");
        db.execSQL("drop table if exists County");
        db.execSQL("drop table if exists WeatherCode");
        onCreate(db);
    }
}
