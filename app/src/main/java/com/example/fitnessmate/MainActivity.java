package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.fitnessmate.DisplayMessageActivity;
import com.example.fitnessmate.R;

public class MainActivity extends AppCompatActivity {
    public static final String Name_TEXT = "com.example.myfirstapp.MESSAGE";
    public static final String AGE_TEXT = "com.example.myfirstapp.AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }


    /** Called when the user taps the Send button */



}