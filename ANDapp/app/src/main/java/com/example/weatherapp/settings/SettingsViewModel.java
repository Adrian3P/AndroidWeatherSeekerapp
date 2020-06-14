package com.example.weatherapp.settings;

import androidx.lifecycle.ViewModel;

import com.example.weatherapp.connection.Repository;

public class SettingsViewModel extends ViewModel {
    private Repository repository;

    public SettingsViewModel()
    {
        repository = Repository.getInstance();
    }

    public String getUnit()
    {
        return repository.getUnit();
    }
    public void setUnit(String unit)
    {
        repository.setUnit(unit);
    }
}
