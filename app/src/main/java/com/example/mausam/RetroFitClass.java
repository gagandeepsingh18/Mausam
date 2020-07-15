package com.example.mausam;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClass {
    private static Retrofit retroFit;
    static final String base = "https://www.metaweather.com/api/location/";


    public  static Retrofit getRetroFitInstance(){
        if (retroFit == null) {
            retroFit = new Retrofit.Builder()
                    .baseUrl(base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retroFit;
    }
}
