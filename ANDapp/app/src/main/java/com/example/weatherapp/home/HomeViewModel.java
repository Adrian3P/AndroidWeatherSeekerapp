package com.example.weatherapp.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.connection.Repository;
import com.example.weatherapp.data.CityResponse.CityResponse;

import java.util.List;

public class HomeViewModel extends ViewModel
{
    private Repository repository;

    public HomeViewModel()
    {
        repository = Repository.getInstance();
    }

    public MutableLiveData<List<CityResponse>> getCitiesInfo()
    {
        return repository.getCitiesInfo();
    }
    public void getCityInfo(String city) {
        repository.requestCityInfo(city);
    }
}