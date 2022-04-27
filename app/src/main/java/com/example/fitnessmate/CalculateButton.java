package com.example.fitnessmate;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CalculateButton{

    public void onClick(View view, TextView weightText, TextView heightText){

        double bmi = 0;
        double valueheight = 0;
        double valueweight = 0;
        double valueheightmeters;

        valueheight = Double.parseDouble(heightText.getText().toString());
        valueweight = Double.parseDouble(weightText.getText().toString());

        valueheightmeters = valueheight / 100; // Converting to meters.

        bmi = (valueweight / (valueheightmeters * valueheightmeters));

        Log.d("Tag", String.valueOf(valueheightmeters));

        if (bmi >= 30) {
            Log.d("Lihavuus", String.valueOf(bmi));
        } else if (bmi >= 25) {
            Log.d("Lievä lihavuus", String.valueOf(bmi));
        } else if (bmi >= 18.5) {
            Log.d("Normaali paino", String.valueOf(bmi));
        } else {
            Log.d("Alipaino", String.valueOf(bmi));
        }


    }

}
