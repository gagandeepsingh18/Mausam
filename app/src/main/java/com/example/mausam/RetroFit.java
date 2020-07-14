package com.example.mausam;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFit {
    private static Retrofit retroFit;
    private static final String base = "https://www.metaweather.com/api/location/";


    public  static Retrofit getRetrofitInstance()
    {
        if (retroFit == null)
        {
            retroFit = new Retrofit.Builder()
                    .baseUrl(base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retroFit;
    }
}