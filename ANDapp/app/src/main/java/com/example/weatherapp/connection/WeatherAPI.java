package com.example.weatherapp.connection;

import com.example.weatherapp.data.CityResponse.CityResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WeatherAPI
{
    @GET("weather")
    Call<CityResponse> getCityInfo(@QueryMap Map<String, String> options);
}