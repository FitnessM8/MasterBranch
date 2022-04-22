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
        Bundle nameAndAge = intent.getExtras();
        String nameMessage = nameAndAge.getString("NAME_MESSAGE");
        String ageMessage = nameAndAge.getString("AGE_MESSAGE");

        TextView textView = findViewById(R.id.textViewBMI);
        textView.setText("Hello " + nameMessage + ", you are " + ageMessage + " year old");

    }
}