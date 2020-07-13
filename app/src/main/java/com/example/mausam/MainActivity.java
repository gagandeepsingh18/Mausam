package com.example.mausam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    static final String BASE_URL = "https://www.metaweather.com/api/location/";

    public void connectingURL() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();



    }


    private RecyclerView recyclerView;
    private MyItemRecyclerViewAdapter recyclerViewAdaptor;
     ArrayList<String>   cityList;
    private ArrayAdapter arrayAdapter;
    ArrayList<Integer> pics;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






       recyclerView=findViewById(R.id.recy);
       cityList=new ArrayList<>();
       pics=new ArrayList<>();

        cityList.add(" ");
        cityList.add("ottawa");
        cityList.add("toronto");
        cityList.add("vancouver");
        cityList.add("gatineau");

        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);
        pics.add(R.drawable.rooom);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdaptor=new MyItemRecyclerViewAdapter(getApplicationContext(),cityList,pics);
        recyclerView.setAdapter(recyclerViewAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}