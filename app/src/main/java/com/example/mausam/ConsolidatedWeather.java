
package com.example.mausam;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConsolidatedWeather implements Parcelable {

   /* @SerializedName("id")
    @Expose
    private Integer id; */
    @SerializedName("weather_state_name")
    @Expose
    private String weatherStateName;
    @SerializedName("weather_state_abbr")
    @Expose
    private String weatherStateAbbr;
    @SerializedName("wind_direction_compass")
    @Expose
    private String windDirectionCompass;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("applicable_date")
    @Expose
    private String applicableDate;
    @SerializedName("min_temp")
    @Expose
    private Double minTemp;
    @SerializedName("max_temp")
    @Expose
    private Double maxTemp;
    @SerializedName("the_temp")
    @Expose
    private Double theTemp;
    @SerializedName("wind_speed")
    @Expose
    private Double windSpeed;
    @SerializedName("wind_direction")
    @Expose
    private Double windDirection;
    @SerializedName("air_pressure")
    @Expose
    private Double airPressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("visibility")
    @Expose
    private Double visibility;
    @SerializedName("predictability")
    @Expose
    private Integer predictability;
    protected ConsolidatedWeather (Parcel in) {
       // id = in.readInt();
        weatherStateName=in.readString();
        weatherStateAbbr=in.readString();
        windDirectionCompass=in.readString();
        created=in.readString();
        applicableDate=in.readString();
        minTemp= in.readDouble();
        maxTemp= in.readDouble();
        theTemp= in.readDouble();
        windSpeed= in.readDouble();
        windDirection= in.readDouble();
        airPressure= in.readDouble();
        humidity= in.readInt();
        visibility= in.readDouble();
        predictability=in.readInt();


    }
    public static final Creator<ConsolidatedWeather> CREATOR = new Creator<ConsolidatedWeather>() {
        @Override
        public ConsolidatedWeather createFromParcel(Parcel in) {
            return new ConsolidatedWeather(in);
        }

        @Override
        public ConsolidatedWeather[] newArray(int size) {
            return new ConsolidatedWeather[size];
        }
    };

  /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }

    public String getWeatherStateAbbr() {
        return weatherStateAbbr;
    }

    public void setWeatherStateAbbr(String weatherStateAbbr) {
        this.weatherStateAbbr = weatherStateAbbr;
    }

    public String getWindDirectionCompass() {
        return windDirectionCompass;
    }

    public void setWindDirectionCompass(String windDirectionCompass) {
        this.windDirectionCompass = windDirectionCompass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicableDate() {
        return applicableDate;
    }

    public void setApplicableDate(String applicableDate) {
        this.applicableDate = applicableDate;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getTheTemp() {
        return theTemp;
    }

    public void setTheTemp(Double theTemp) {
        this.theTemp = theTemp;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(Double airPressure) {
        this.airPressure = airPressure;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {

        //destination.writeInt(id);
        destination.writeString(weatherStateName);
        destination.writeString(weatherStateAbbr);
        destination.writeString(windDirectionCompass);
        destination.writeString(created);
        destination.writeString(applicableDate);
        destination.writeDouble(minTemp);
        destination.writeDouble(maxTemp);
        destination.writeDouble(theTemp);
        destination.writeDouble(windSpeed);
        destination.writeDouble(windDirection);
        destination.writeDouble(airPressure);
        destination.writeInt(humidity);
        destination.writeDouble(visibility);
        destination.writeInt(predictability);
    }
}
