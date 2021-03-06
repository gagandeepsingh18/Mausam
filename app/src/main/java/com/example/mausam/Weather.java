package com.example.mausam;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Weather{
    @SerializedName("consolidated_weather")
    @Expose
    private ArrayList<ConsolidatedWeather> weatherList;
    private String title;

    public Weather(ArrayList<ConsolidatedWeather> weatherList, String title) {
        this.weatherList = weatherList;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }



    public ArrayList<ConsolidatedWeather> getWeatherList() {
        return weatherList;
    }



}