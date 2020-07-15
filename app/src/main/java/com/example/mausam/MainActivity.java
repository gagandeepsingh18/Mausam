package com.example.mausam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {




    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavController navController;
    public NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences  = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("City", "Montréal");
        myEdit.apply();
        setupNavigation();

    }


    public void setupNavigation()
    {
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();


    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.nav_host_fragment),drawerLayout);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        menuItem.setCheckable(true);
        drawerLayout.closeDrawers();
        navigationView.setNavigationItemSelectedListener(this);

        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences=  getApplicationContext().getSharedPreferences("Preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        switch (id)
        {
            case R.id.m_montreal:
                myEdit.putString("City", "Montréal");
                myEdit.apply();
                navController.navigate(R.id.WeatherFragment);
                break;
            case R.id.m_toronto:
                myEdit.putString("City", "Toronto");
                myEdit.apply();
                navController.navigate(R.id.WeatherFragment);
                break;
            case R.id.m_vancouver:
                myEdit.putString("City", "Vancouver");
                myEdit.apply();
                navController.navigate(R.id.WeatherFragment);
                break;
            case R.id.m_newYork:
                myEdit.putString("City", "New York");
                myEdit.apply();
                navController.navigate(R.id.WeatherFragment);
                break;
            case R.id.m_losAngeles:
                myEdit.putString("City", "Los Angeles");
                myEdit.apply();
                navController.navigate(R.id.WeatherFragment);
                break;
        }

        return true;
    }


}

