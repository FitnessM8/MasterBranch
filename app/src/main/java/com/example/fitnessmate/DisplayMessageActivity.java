package com.example.fitnessmate;


import static com.example.fitnessmate.MainActivity.BMI_RESULT_Number;

import static com.example.fitnessmate.MainActivity.BMI_RESULT_STRING;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessmate.R;

public class DisplayMessageActivity extends AppCompatActivity {

    TextView resultNumber;
    Button historyButton;
    Button resultButton;
    String result;
    SharedPreferences bmiHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_message);

        resultNumber = findViewById(R.id.bmi_result);
        historyButton = findViewById(R.id.historyButton);

        bmiHistory = getSharedPreferences("ResultHistory", Context.MODE_PRIVATE);

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = resultNumber.getText().toString();

                SharedPreferences.Editor editor = bmiHistory.edit();
                editor.putString("result", result);
                editor.commit();

            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preResults = new Intent(DisplayMessageActivity.this, PreviousResults.class);
                startActivity(preResults);
            }
        });

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
        Intent previousResults = new Intent(DisplayMessageActivity.this, PreviousResults.class);
        startActivity(previousResults);
    };
}