package com.example.mausam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CityDetailsFragment extends Fragment {
    ImageView ImageView;
    TextView CityName, CurrentTemp, MaxTemp, MinTemp, Weather;
    Weather WeatherObject;

    public CityDetailsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_details, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CityName = view.findViewById(R.id.CityName);
        CurrentTemp = view.findViewById(R.id.CurTemp);
        MaxTemp = view.findViewById(R.id.MaxTempField);
        MinTemp = view.findViewById(R.id.MinTempField);
        Weather = view.findViewById(R.id.Weather);
        showWeather();
    }

    public void showWeather() {
        GetCityDetails getCityDetails = RetroFit.getRetrofitInstance().create(GetCityDetails.class);
        Call<Weather> weatherCall = getCityDetails.getWeather();
        weatherCall.enqueue(new Callback<com.example.mausam.Weather>() {
            @Override
            public void onResponse(Call<com.example.mausam.Weather> call, Response<com.example.mausam.Weather> response) {
            WeatherObject = response.body();
            CityName.setText(WeatherObject.getTitle());
            CurrentTemp.setText(String.valueOf(WeatherObject.getWeatherList().get(0).getTheTemp())+" °C");
            MaxTemp.setText(String.valueOf(WeatherObject.getWeatherList().get(0).getMaxTemp())+" °C");
            MinTemp.setText(String.valueOf(WeatherObject.getWeatherList().get(0).getMinTemp())+" °C");
            Weather.setText(WeatherObject.getWeatherList().get(0).getWeatherStateName());
            setImage(ImageView, R.id.imageWeather, WeatherObject.getWeatherList().get(0).getWeatherStateAbbr());
            }

            @Override
            public void onFailure(Call<com.example.mausam.Weather> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity().getApplicationContext(), "Please try after some time", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setImage(ImageView imageView, int id, String weatherState) {

        imageView = getView().findViewById(id);
        Picasso.get().load("https://www.metaweather.com/static/img/weather/ico/" + weatherState + ".ico").into(imageView);

    }
}