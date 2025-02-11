package com.example.sample_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {

    Button openApp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        openApp = findViewById(R.id.OpenApp);
        openApp.setOnClickListener(v -> navigateCalculatorActivity());
    }
    public void navigateCalculatorActivity(){
        Intent intent =  new Intent(this,CalculatorActivity.class);
        startActivity(intent);
    }
}
