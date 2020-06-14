package com.example.weatherapp.connection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator
{
    private static Retrofit.Builder retrofitBuilder= new Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = retrofitBuilder.build();
    private static WeatherAPI api = retrofit.create(WeatherAPI.class);
    public static WeatherAPI getApi()
    {
        return api;
    }
}
