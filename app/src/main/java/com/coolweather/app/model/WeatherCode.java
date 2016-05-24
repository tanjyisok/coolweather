package com.coolweather.app.model;

/**
 * Created by nvshen on 2016/5/23.
 */
public class WeatherCode {
    private int id;
    private String weatherCode;
    private String weatherCodeCity;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getWeatherCode(){
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode){
        this.weatherCode = weatherCode;
    }

    public String getWeatherCodeCity(){
        return weatherCodeCity;
    }

    public void setWeatherCodeCity(String weatherCodeCity){
        this.weatherCodeCity = weatherCodeCity;
    }
}
