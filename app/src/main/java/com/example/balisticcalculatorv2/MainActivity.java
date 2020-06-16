package com.example.balisticcalculatorv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_acitivity_main);
       // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //navController.navigate(R.id.main_layout);
    }



}