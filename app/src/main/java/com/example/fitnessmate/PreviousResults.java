package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.List;

public class PreviousResults extends AppCompatActivity {

    ListView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_previous_results);

        results = findViewById(R.id.resultList);

        SharedPreferences bmiHistory = getApplicationContext().getSharedPreferences("ResultHistory", Context.MODE_PRIVATE);
        String result = bmiHistory.getString("result", "");


    }

    public void backToStart(View view) {
        Intent backIntent = new Intent(PreviousResults.this, MainActivity.class);
        startActivity(backIntent);
    };
}