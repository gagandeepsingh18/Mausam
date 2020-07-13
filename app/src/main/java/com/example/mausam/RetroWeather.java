package com.example.mausam;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class RetroWeather {
    @SerializedName("id")
    private Integer id;
    @SerializedName("weather_state_name")
    private String weather_state_name;
    @SerializedName("weather_state_abbr")
    private String weather_state_abbr;
    @SerializedName("wind_direction_compass")
    private String wind_direction_compass;
    @SerializedName("created")
    private String created;
    @SerializedName("applicable_date")
    private String applicable_date;
    @SerializedName("min_temp")
    private Double min_temp;
    @SerializedName("max_temp")
    private Double max_temp;
    @SerializedName("the_temp")
    private Double the_temp;
    @SerializedName("wind_speed")
    private Double wind_speed;
    @SerializedName("wind_direction")
    private Double wind_direction;
    @SerializedName("air_pressure")
    private Double air_pressure;
    @SerializedName("  humidity")
    private Integer   humidity;
    @SerializedName("visibility")
    private Double visibility;
    @SerializedName("predictability")
    private Integer predictability;


   public RetroWeather(Integer id,String weather_state_name,String weather_state_abbr
           ,String wind_direction_compass,String created,String applicable_date,Double min_temp,Double max_temp,Double the_temp,Double wind_speed
                       ,Double wind_direction,Double air_pressure,Integer humidity,Double visibility,Integer predictability
                       )
   {
       this.id=id;
       this.weather_state_name=weather_state_name;
       this.weather_state_abbr=weather_state_abbr;
       this.wind_direction_compass=wind_direction_compass;
       this.created=created;
       this.applicable_date=applicable_date;
       this.min_temp=min_temp;
       this.max_temp=max_temp;
       this.the_temp=the_temp;
       this.wind_speed=wind_speed;
       this.wind_direction=wind_direction;
       this.air_pressure=air_pressure;
       this.humidity=humidity;
       this.visibility=visibility;
       this.predictability=predictability;
   }
public Integer getId()
{
    return id;
}
    public void setId(Integer id)
    {
       this.id=id;
    }

    public String getWeather_state_name()
    {
        return weather_state_name;
    }
    public void setWeather_state_name(String weather_state_name)
    {
        this.weather_state_name=weather_state_name;
    }

    public String getWeather_state_abbr()
    {
        return weather_state_abbr;
    }
    public void setWeather_state_abbr(String weather_state_abbr)
    {
        this.weather_state_abbr=weather_state_abbr;
    }

    public String getWind_direction_compass(String wind_direction_compass)
    {
        return wind_direction_compass;
    }
    public void setWind_direction_compass(String wind_direction_compass)
    {
        this.wind_direction_compass=wind_direction_compass;
    }

    public String getCreated()
    {
        return created;
    }
    public void setCreated(String created)
    {
        this.created=created;
    }

    public String getApplicable_date()
    {
        return applicable_date;
    }
    public void setApplicable_date(String applicable_date)
    {
        this.applicable_date=applicable_date;
    }

    public Double getMin_temp()
    {
       return min_temp;
    }
    public void setMin_temp(Double min_temp)
    {
        this.min_temp=min_temp;
    }

    public Double getMax_temp()
    {
        return max_temp;
    }
    public void setId(Double max_temp)
    {
        this.max_temp=max_temp;
    }

    public Double getThe_temp()
    {
        return the_temp;
    }
    public void setThe_temp(Double the_temp)
    {
        this.the_temp=the_temp;
    }


    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_direction(Double wind_direction) {
        this.wind_direction = wind_direction;
    }

    public Double getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(Double air_pressure) {
        this.air_pressure = air_pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Integer getPredictability() {
        return predictability;
    }

    public void setPredictability(Integer predictability) {
        this.predictability = predictability;
    }
}
