package com.example.mausam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FutureForecastFragment extends Fragment {
    Weather WeatherObject;
    String City = "";
    private RecyclerView recyclerView;
    RecyclerAdaptor recyclerAdaptor;
    FragmentTransaction fragmentTransaction;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        City= bundle.getString("Weather");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_future_forecast, container, false);
        showWDetailWeather();
        return view;
    }
    public void showWDetailWeather(){
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
                generateForecastView(WeatherObject.getWeatherList(), getView());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
    });
    }

        public void generateForecastView(ArrayList<ConsolidatedWeather> WeatherArray, View view) {

        recyclerAdaptor = new RecyclerAdaptor(WeatherArray, getActivity().getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView = view.findViewById(R.id.FutureForecastRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdaptor);
        recyclerAdaptor.setOnClickListener(onClickListener);

    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            Bundle b = new Bundle();
            FutureDetailsFragment fragment = new FutureDetailsFragment();
            fragmentTransaction = getFragmentManager().beginTransaction();
            b.putParcelable("Forecast", WeatherObject.getWeatherList().get(position));
            fragment.setArguments(b);
            fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
            fragmentTransaction.commit();
        }
    };
}