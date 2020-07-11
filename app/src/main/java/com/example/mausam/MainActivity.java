package com.example.mausam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.mausam.adaptor.RecyclerViewAdaptor;

import java.lang.reflect.Array;
import java.util.*;

public class MainActivity extends AppCompatActivity {

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

       cityList.add("montreal");
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
}