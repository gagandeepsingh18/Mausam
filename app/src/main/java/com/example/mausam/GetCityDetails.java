package com.example.mausam;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCityDetails {

    @GET("3534")
    Call<Weather> getMontrealWeather();

    @GET("4118")
    Call<Weather> getTorontoWeather();

    @GET("9807")
    Call<Weather> getVancouverWeather();

    @GET("2459115")
    Call<Weather> getNewYorKWeather();

    @GET("2442047")
    Call<Weather> getLosAngelesWeather();


}
