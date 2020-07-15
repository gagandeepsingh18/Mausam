package com.example.mausam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {

    private ArrayList<ConsolidatedWeather> consolidatedWeathers;
    private Context context;
    private View.OnClickListener clickListener;

    public RecyclerAdaptor(ArrayList<ConsolidatedWeather> consolidatedWeathers, Context context) {
        this.consolidatedWeathers = consolidatedWeathers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ConsolidatedWeather currentWeather = consolidatedWeathers.get(position);
        holder.curTemp.setText(DateManipulation.convertDouble(currentWeather.getTheTemp()));
        holder.maxTemp.setText(DateManipulation.convertDouble(currentWeather.getMaxTemp()));
        holder.minTemp.setText(DateManipulation.convertDouble(currentWeather.getMinTemp()));
        holder.day.setText(DateManipulation.dayOfWeek(currentWeather.getApplicableDate()));
        holder.weather.setText(currentWeather.getWeatherStateName());
        Picasso.get().load("https://www.metaweather.com/static/img/weather/ico/" + currentWeather.getWeatherStateAbbr() + ".ico").into(holder.Image);


    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        clickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return consolidatedWeathers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView Image;
        TextView day, maxTemp, minTemp, curTemp, weather;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Image = itemView.findViewById(R.id.ImageFutureForecastField);
            day = itemView.findViewById(R.id.dayFutureForecast);
            maxTemp = itemView.findViewById(R.id.maxTempFutureForecastField);
            minTemp = itemView.findViewById(R.id.minTempFutureForecastField);
            curTemp= itemView.findViewById(R.id.curTempFutureForecastField);
            weather= itemView.findViewById(R.id.weatherFutureForecast);
            itemView.setTag(this);
            itemView.setOnClickListener(clickListener);
        }
    }
}
