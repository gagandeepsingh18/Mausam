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

import com.squareup.picasso.Picasso;


public class FutureDetailsFragment extends Fragment {

    ImageView ImageView;
    TextView CurrentTemp, MaxTemp, MinTemp, Weather, WindSpeed, Visibility, day;
    ConsolidatedWeather WeatherObject;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        WeatherObject =bundle.getParcelable("Forecast");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_future_details, container, false);

        CurrentTemp = view.findViewById(R.id.CurTempFutureDetailsField);
        MaxTemp = view.findViewById(R.id.MaxTempFutureDetailsField);
        MinTemp = view.findViewById(R.id.MinTempFutureDetailsField);
        Weather = view.findViewById(R.id.WeatherFutureDetails);
        WindSpeed= view.findViewById(R.id.WindSpeedFutureDetailsField);
        Visibility= view.findViewById(R.id.VisibilityFutureDetailsField);
        day= view.findViewById(R.id.DayFutureDetailsField);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateDetailsView();



    }

    public void generateDetailsView() {
        day.setText(WeatherObject.getApplicableDate());
        CurrentTemp.setText(WeatherObject.getTheTemp().toString().toString().substring(0,2)+" °C");
        MaxTemp.setText(WeatherObject.getMaxTemp().toString().toString().substring(0,2)+" °C");
        MinTemp.setText(WeatherObject.getMinTemp().toString().toString().substring(0,2)+" °C");
        Weather.setText(WeatherObject.getWeatherStateName());
        WindSpeed.setText(WeatherObject.getWindSpeed().toString().toString().substring(0,1)+" KPH");
       Visibility.setText(WeatherObject.getVisibility().toString().toString().substring(0,1)+" KPH");
       setDetailsImage(ImageView, R.id.ImageWeatherFutureDetailsField, WeatherObject.getWeatherStateAbbr());
    }
    private void setDetailsImage(ImageView imageView, int id, String weatherState) {

        imageView = getView().findViewById(id);
        Picasso.get().load("https://www.metaweather.com/static/img/weather/ico/" + weatherState + ".ico").into(imageView);

    }
}