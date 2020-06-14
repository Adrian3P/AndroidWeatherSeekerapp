package com.example.weatherapp.data.CityResponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CityResponse {
    @SerializedName("coord")
    Coord CoordObject;
    @SerializedName("weather")
    ArrayList<Weather> weather = new ArrayList<Weather>();
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    Main MainObject;
    @SerializedName("wind")
    Wind WindObject;
    @SerializedName("clouds")
    Clouds CloudsObject;
    @SerializedName("dt")
    private float dt;
    @SerializedName("sys")
    Sys SysObject;
    @SerializedName("timezone")
    private float timezone;
    @SerializedName("id")
    private float id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private float cod;



    public Coord getCoord() {
        return CoordObject;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return MainObject;
    }

    public Wind getWind() {
        return WindObject;
    }

    public Clouds getClouds() {
        return CloudsObject;
    }

    public float getDt() {
        return dt;
    }

    public Sys getSys() {
        return SysObject;
    }

    public float getTimezone() {
        return timezone;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getCod() {
        return cod;
    }



    public void setCoord(Coord coordObject) {
        this.CoordObject = coordObject;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(Main mainObject) {
        this.MainObject = mainObject;
    }

    public void setWind(Wind windObject) {
        this.WindObject = windObject;
    }

    public void setClouds(Clouds cloudsObject) {
        this.CloudsObject = cloudsObject;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setSys(Sys sysObject) {
        this.SysObject = sysObject;
    }

    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }
}
