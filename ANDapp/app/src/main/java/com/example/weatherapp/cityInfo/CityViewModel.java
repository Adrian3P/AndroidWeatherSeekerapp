package com.example.weatherapp.cityInfo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.connection.Repository;
import com.example.weatherapp.data.CityResponse.CityResponse;

public class CityViewModel extends ViewModel {
    private Repository repository;

    public CityViewModel()
    {
        repository = Repository.getInstance();
    }

    public void addCityToFav(String city){
        repository.addFavoriteCity(city);
    }

    public MutableLiveData<CityResponse> getCityInfo(){
        return repository.getCityInfo();
    }

    public void removeCity(String city){
        repository.removeFavCity(city);
    }
    public boolean checkCity(String city){
        return repository.checkCity(city);
    }
}