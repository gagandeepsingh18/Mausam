package com.example.mausam;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class CityDetailsFragment extends Fragment {
    ImageView ImageView;
    TextView CityName, CurrentTemp, MaxTemp, MinTemp, Weather, WindSpeed, Visibility;
    Weather WeatherObject;
    String City = "";
    Button FutureBtn;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences ("Preferences", Context.MODE_PRIVATE);
        City = sharedPreferences.getString("City", "Montréal");
        View view = inflater.inflate(R.layout.fragment_city_details, container, false);
        CityName = view.findViewById(R.id.CityNameField);
        CurrentTemp = view.findViewById(R.id.CurTempField);
        MaxTemp = view.findViewById(R.id.MaxTempField);
        MinTemp = view.findViewById(R.id.MinTempField);
        Weather = view.findViewById(R.id.Weather);
        WindSpeed= view.findViewById(R.id.WindSpeedField);
        Visibility= view.findViewById(R.id.VisibilityField);
        FutureBtn= view.findViewById(R.id.FutureForecastButton);
        showWeather();
        FutureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FutureForecastFragment fragment = new FutureForecastFragment();
                fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle b = new Bundle();
                b.putString("Weather", City);
                Log.d("abc", City);
                fragment.setArguments(b);
                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                fragmentTransaction.commit();
            }
        });
        return  view;

    }



    public void showWeather(){
        GetCityDetails getCityDetails = RetroFitClass.getRetroFitInstance().create(GetCityDetails.class);
        Call<Weather> weatherCall;

        if(City.equals("Montréal")){
             weatherCall = getCityDetails.getMontrealWeather();
        }
        else if (City.equals("Toronto")){
            weatherCall = getCityDetails.getTorontoWeather();
        }
        else if (City.equals("Vancouver")){
            weatherCall = getCityDetails.getVancouverWeather();
        }
        else if (City.equals("New York")){
            weatherCall = getCityDetails.getNewYorKWeather();
        }
        else if (City.equals("Los Angeles")){
            weatherCall = getCityDetails.getLosAngelesWeather();
        }
        else {
            weatherCall = getCityDetails.getMontrealWeather();
        }

        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                WeatherObject = response.body();
                CityName.setText(WeatherObject.getTitle());
                CurrentTemp.setText(WeatherObject.getWeatherList().get(0).getTheTemp().toString().substring(0,2)+" °C");
                MaxTemp.setText(WeatherObject.getWeatherList().get(0).getMaxTemp().toString().substring(0,2)+" °C");
                MinTemp.setText(WeatherObject.getWeatherList().get(0).getMinTemp().toString().substring(0,2)+" °C");
                Weather.setText(WeatherObject.getWeatherList().get(0).getWeatherStateName());
                WindSpeed.setText(WeatherObject.getWeatherList().get(0).getWindSpeed().toString().substring(0,1)+" KPH");
                Visibility.setText(WeatherObject.getWeatherList().get(0).getVisibility().toString().substring(0,2)+" KPH");
              setImage(ImageView, R.id.ImageWeatherField, WeatherObject.getWeatherList().get(0).getWeatherStateAbbr());
            }

            @Override
            public void onFailure(Call<com.example.mausam.Weather> call, Throwable t) {
                Log.d("abc", t.getMessage());

                Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setImage(ImageView imageView, int id, String weatherState) {
        imageView = getView().findViewById(id);
        Log.d("TAG", String.valueOf(id));
        Picasso.get().load("https://www.metaweather.com/static/img/weather/ico/" + weatherState + ".ico").into(imageView);

    }


}