package com.coolweather.app.model;

/**
 * Created by nvshen on 2016/5/22.
 */
public class County {
    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName){
        this.countyName = countyName;
    }

    public String getCountyCode(){
        return countyCode;
    }

    public void setCountyCode(String countyCode){
        this.countyCode = countyCode;
    }

    public int getCityID(){
        return cityId;
    }

    public void setCityId(int cityId){
        this.cityId = cityId;
    }
}