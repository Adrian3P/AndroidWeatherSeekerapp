package com.example.weatherapp.cityInfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapp.MainActivity;
import com.example.weatherapp.R;
import com.example.weatherapp.data.CityResponse.CityResponse;
import com.example.weatherapp.login.AuthentificationActivity;
import com.example.weatherapp.settings.SettingsActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.sql.Time;

public class CityDetailsActivity extends AppCompatActivity {
    CityViewModel model;
    TextView cityName;
    TextView description;
    TextView grades;
    TextView sunrise;
    TextView sunset;
    TextView pressure;
    TextView humidity;
    TextView wind;
    TextView feelsLike;
    TextView minTemp;
    TextView maxTemp;
    Button addFav;
    Button removeFav;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_city_details);
        mAuth = FirebaseAuth.getInstance();
        model = new ViewModelProvider(this).get(CityViewModel.class);
        cityName=findViewById(R.id.cityB);
        description=findViewById(R.id.weatherP);
        grades=findViewById(R.id.degrees20);
        sunrise=findViewById(R.id.sunrise_hour);
        sunset=findViewById(R.id.sunset_hour);
        pressure=findViewById(R.id.hPa);
        humidity=findViewById(R.id.humidity_nr);
        wind=findViewById(R.id.wind_speed);
        feelsLike=findViewById(R.id.degrees20_);
        minTemp=findViewById(R.id.min_temp_grades);
        maxTemp=findViewById(R.id.max_temp_grades);
        addFav=findViewById(R.id.addButton);
        removeFav=findViewById(R.id.removeButton);

        Toolbar toolbar = findViewById(R.id.cityInfo_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CityResponse city = model.getCityInfo().getValue();

        cityName.setText(city.getName());
        description.setText(city.getWeather().get(0).getDescription());
        grades.setText(Math.round(city.getMain().getTemp() - 273.15)+"");
        Time sunriseTime = new Time((long)city.getSys().getSunrise());
        sunrise.setText(sunriseTime.getHours() + ":"+ sunriseTime.getMinutes());
        Time sunsetTime = new Time((long)city.getSys().getSunset());
        sunset.setText(sunsetTime.getHours()+":"+sunsetTime.getMinutes());
        pressure.setText(city.getMain().getPressure() + " hPa");
        humidity.setText(city.getMain().getHumidity() + "%");
        wind.setText(city.getWind().getSpeed() + " km/hr");
        feelsLike.setText(city.getMain().getFeels_like() + "");
        minTemp.setText(city.getMain().getTemp_min() + " C");
        maxTemp.setText(city.getMain().getTemp_max() + " C");
        if(model.checkCity(cityName.getText().toString())) {
            addFav.setVisibility(View.INVISIBLE);
            removeFav.setVisibility(View.VISIBLE);
        }
        addFav.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                model.addCityToFav(city.getName());
                Log.d("Button","Added city to favourites. Hiding button...");
                addFav.setVisibility(View.INVISIBLE);
                removeFav.setVisibility(View.VISIBLE);
                Toast.makeText(CityDetailsActivity.this, "City added to favourites.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        removeFav.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                model.removeCity(city.getName());
                Log.d("Button","Removed city from favourites. Hiding button...");
                addFav.setVisibility(View.VISIBLE);
                removeFav.setVisibility(View.INVISIBLE);
                Toast.makeText(CityDetailsActivity.this, "City removed from favourites.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(CityDetailsActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_logout:
                mAuth.signOut();
                Intent intentOut = new Intent(CityDetailsActivity.this, AuthentificationActivity.class);
                startActivity(intentOut);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}