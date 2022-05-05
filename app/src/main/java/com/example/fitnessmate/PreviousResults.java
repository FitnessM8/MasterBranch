package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


import java.lang.reflect.Type;
import java.util.ArrayList;

/** This activity shows the previous results users has counted. It's done by using SharedPreferences.
 * It also has a different activty, so the user can go back to the main page.
 * @author Arbër Zeqiri
 * */

public class PreviousResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_previous_results);

        TextView oldResults;
        oldResults = findViewById(R.id.oldResults);

        SharedPreferences results = getApplicationContext().getSharedPreferences("PreviousResults", Context.MODE_PRIVATE);
        String preResults = results.getString("button", "");

        oldResults.setText(preResults);

    }



    public void backToStart(View view) {
        Intent backIntent = new Intent(PreviousResults.this, MainActivity.class);
        startActivity(backIntent);
    }
}
