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
import android.widget.TextView;

/**
This class call for the activity when the user want to see the BMI result.
It gets the information from the MainActivity.java and Calculation.java and displays them here.
It also has a couple of intents to move from activity to another.

@author Arbër Zeqiri
 */

public class DisplayResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The next 3 lines hides the top bar in the app.
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
    // This opens a tips from WHO when the user presses a "Vihjeitä!" button.
    public void tipsURL(View view) {
        Intent openTips = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/philippines/news/feature-stories/detail/20-health-tips-for-2020"));
        startActivity(openTips);
    }
    // This button goes back to the starting page after pressed.
    public void onClick(View view) {
        Intent backIntent = new Intent(DisplayResultActivity.this, MainActivity.class);
        startActivity(backIntent);
    };
    // When user presses this button, they can see all the results.
    public void previousResults(View view) {
        Intent previousresults = new Intent(DisplayResultActivity.this, PreviousResults.class);
        startActivity(previousresults);
    };
}