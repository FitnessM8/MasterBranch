package com.example.fitnessmate;


import static com.example.fitnessmate.MainActivity.BMI_RESULT_Number;

import static com.example.fitnessmate.MainActivity.BMI_RESULT_STRING;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessmate.R;

public class DisplayMessageActivity extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_message);

        Bundle extras = getIntent().getExtras();
        String bmiNumber = extras.getString(BMI_RESULT_Number);
        String bmiString = extras.getString(BMI_RESULT_STRING);


        ((TextView) findViewById(R.id.bmi_result)).setText(bmiNumber);
        ((TextView) findViewById(R.id.bmi_result_number)).setText(bmiString);
    }

    public void tipsURL(View view) {
        Intent openTips = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/philippines/news/feature-stories/detail/20-health-tips-for-2020"));
        startActivity(openTips);
    }

    public void onClick(View view) {
        Intent backIntent = new Intent(DisplayMessageActivity.this, MainActivity.class);
        startActivity(backIntent);
    };

    public void previousResults(View view) {
        Intent previousresults = new Intent(DisplayMessageActivity.this, PreviousResults.class);
        startActivity(previousresults);
    };
}