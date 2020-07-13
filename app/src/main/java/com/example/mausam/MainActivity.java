package com.example.mausam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;

import com.example.mausam.adaptor.RecyclerViewAdaptor;
import com.example.mausam.dummy.GetDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {




    private RecyclerView recyclerView;
    private MyItemRecyclerViewAdapter recyclerViewAdaptor;
     ArrayList<String>   cityList;

    ArrayList<Integer> pics;
    ArrayList<String> tempratures;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroWeather>> call=service.getWeather();
        call.enqueue(new Callback<List<RetroWeather>>() {
            @Override
            public void onResponse(Call<List<RetroWeather>> call, Response<List<RetroWeather>> response) {

            }

            @Override
            public void onFailure(Call<List<RetroWeather>> call, Throwable t) {

            }
        });



       recyclerView=findViewById(R.id.recy);
       cityList=new ArrayList<>();
       pics=new ArrayList<>();
       tempratures=new ArrayList<>();

        cityList.add(" ");
        cityList.add("ottawa");
        cityList.add("toronto");
        cityList.add("vancouver");
        cityList.add("gatineau");


        tempratures.add("32c");
        tempratures.add("32c");
        tempratures.add("32c");
        tempratures.add("32c");



        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdaptor=new MyItemRecyclerViewAdapter(getApplicationContext(),cityList,pics,tempratures);
        recyclerView.setAdapter(recyclerViewAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}