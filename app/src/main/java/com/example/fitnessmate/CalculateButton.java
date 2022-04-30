package com.example.fitnessmate;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import javax.xml.transform.Result;

public class CalculateButton extends AppCompatActivity {

    double bmi = 0;
    double valueheight = 0;
    double valueweight = 0;
    double valueheightmeters;
    private static String bmiString;
    private static String bmiResult;


    public void onClick(View view, TextView weightText, TextView heightText) {

        valueheight = Double.parseDouble(heightText.getText().toString());
        valueweight = Double.parseDouble(weightText.getText().toString());

        valueheightmeters = valueheight / 100; // Converting to meters.

        bmi = (valueweight / (valueheightmeters * valueheightmeters));
        bmiString = Double.toString(bmi);

        Log.d("Tag", String.valueOf(valueheightmeters));

        if (bmi >= 30) {
            Log.d("Lihavuus", String.valueOf(bmi));
            bmiResult = "Lihavuus";
        } else if (bmi >= 25) {
            Log.d("Lievä lihavuus", String.valueOf(bmi));
            bmiResult = "Lievä lihavuus";
        } else if (bmi >= 18.5) {
            Log.d("Normaali paino", String.valueOf(bmi));
            bmiResult = "Normaali";
        } else {
            Log.d("Alipaino", String.valueOf(bmi));
            bmiResult = "Alipaino";
        }

    }
    public String haeBmi() {
        return this.bmiString;
    }

    public String haeLuokitus() {
        return this.bmiResult;
    }
}
