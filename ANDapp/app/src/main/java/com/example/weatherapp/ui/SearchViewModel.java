package com.example.weatherapp.ui;

import androidx.lifecycle.ViewModel;

import com.example.weatherapp.connection.Repository;

public class SearchViewModel extends ViewModel {
    private Repository repository;

    public SearchViewModel() {
        repository = Repository.getInstance();
    }

    public void getCityInfo(String city) {
        repository.requestCityInfo(city);
    }
}