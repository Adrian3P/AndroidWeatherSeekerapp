package com.example.weatherapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.weatherapp.R;
import com.example.weatherapp.cityInfo.CityDetailsActivity;

public class SearchFragment extends Fragment
{
    private EditText text;
    private Button search;
    private SearchViewModel model;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View routeView = inflater.inflate(R.layout.search_fragment, container, false);
        text=routeView.findViewById(R.id.search_text);
        search=routeView.findViewById(R.id.buttonsearch);
        model=new SearchViewModel();
        search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!(text.getText() == null )) {
                    model.getCityInfo(text.getText().toString());
                    try {
                        Thread.sleep(1500);
                        Intent intent = new Intent(getContext(), CityDetailsActivity.class);
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d("Button: ","No city introduced in search field");
            }
        });
        return routeView;
    }
}
