package com.example.weatherapp.connection;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.data.City;

import java.util.ArrayList;
import java.util.List;

public class Dao
{
    private static Dao instance;
    private MutableLiveData<String> unit;
    private MutableLiveData<List<String>> favCities;
    private List<String> cities;
    private boolean update;
    private Dao()
    {
        unit=new MutableLiveData<>();
        unit.setValue("C");
        favCities = new MutableLiveData<>();
        cities= new ArrayList<>();
        cities.add("Horsens");
        favCities.setValue(cities);
        update = true;
    }
    public static Dao getInstance()
    {
        if(instance==null)
            instance = new Dao();
        return instance;
    }

    public MutableLiveData<String> getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit.setValue(unit);
    }

    public MutableLiveData<List<String>> getFavCities()
    {
        return favCities;
    }

    public boolean checkCity(String city){
        boolean check = false;
        for (int i = 0;i < cities.size(); i++){
            if (cities.get(i).equals(city))
                check = true;
        }
        return check;
    }

    public void addFavCity(String city)
    {
        cities.add(city);
        favCities.setValue(cities);
        update = true;
        Log.d("Dao: add", "Update set to true.");
    }
    public void deleteFavCity(String city)
    {
        cities.remove(city);
        update = true;
        Log.d("Dao: remove", "Update set to true.");
    }
    public int getSize(){
        return cities.size();
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }
}