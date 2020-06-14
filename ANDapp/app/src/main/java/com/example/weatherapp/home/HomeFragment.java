package com.example.weatherapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.cityInfo.CityDetailsActivity;
import com.example.weatherapp.data.CityResponse.CityResponse;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnListItemClickListener
{
    CityAdapter adapter;
    List<CityResponse> cities = new ArrayList<>();
    HomeViewModel viewModel = new HomeViewModel();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View routeView = inflater.inflate(R.layout.home_fragment, container, false);
        RecyclerView cityList = routeView.findViewById(R.id.recyclerView);

        cityList.hasFixedSize();
        cityList.setLayoutManager(new LinearLayoutManager(getActivity()));
        cities.clear();
        final Observer<List<CityResponse>> observer = new Observer<List<CityResponse>>() {
            @Override
            public void onChanged(List<CityResponse> newData) {
                cities.addAll(newData);
                adapter = new CityAdapter(cities,HomeFragment.this);
                cityList.setAdapter(adapter);
            }
        };
        viewModel.getCitiesInfo().observe(getViewLifecycleOwner(),observer);

        return routeView;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        viewModel.getCityInfo(cities.get(clickedItemIndex).getName());
        try {
            Thread.sleep(1500);
            Intent intent = new Intent(getContext(), CityDetailsActivity.class);
            startActivity(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("RecyclerView","Clicked on item "+ clickedItemIndex);
    }
}