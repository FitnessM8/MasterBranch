package com.example.fitnessmate;


import static com.example.fitnessmate.MainActivity.BMI_RESULT_Number;

import static com.example.fitnessmate.MainActivity.BMI_RESULT_STRING;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fitnessmate.R;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        Bundle extras = getIntent().getExtras();
        String bmiNumber = extras.getString(BMI_RESULT_Number);
        String bmiString = extras.getString(BMI_RESULT_STRING);


        ((TextView) findViewById(R.id.bmi_result)).setText(bmiNumber);
        ((TextView) findViewById(R.id.bmi_result_number)).setText(bmiString);
    }
}