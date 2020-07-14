package com.example.mausam;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCityDetails {

    @GET("4118")
    Call<Weather> getWeather();

}
