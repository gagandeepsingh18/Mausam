package com.example.mausam.dummy;

import com.example.mausam.RetroWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/3534")
    Call<List<RetroWeather>> getAllPhotos();
}
