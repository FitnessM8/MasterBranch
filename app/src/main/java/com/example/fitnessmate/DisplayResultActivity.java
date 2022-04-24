package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        Intent intent = getIntent();
        Bundle bmiAndPre = intent.getExtras();
        String bmiMessage = bmiAndPre.getString("BMI_MESSAGE");
        String preBMIMessage = bmiAndPre.getString("PRE_BMI_MESSAGE");

        TextView textViewBMI = findViewById(R.id.textViewBMI);
        textViewBMI.setText("Your BMI is: " + bmiMessage);

    }
}