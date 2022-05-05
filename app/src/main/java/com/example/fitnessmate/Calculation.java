package com.example.fitnessmate;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Calculation extends AppCompatActivity {

    double bmi = 0;
    double valueheight = 0;
    double valueweight = 0;
    double valueheightmeters;
    private static String bmiString;
    private static String bmiResult;
    List<Double> results = new ArrayList<Double>();


    public void onClick(View view, TextView weightText, TextView heightText) {

        valueheight = Double.parseDouble(heightText.getText().toString());
        valueweight = Double.parseDouble(weightText.getText().toString());

        valueheightmeters = valueheight / 100; // Converting to meters.

        bmi = (valueweight / (valueheightmeters * valueheightmeters));
        bmiString = String.format("%.1f" , bmi);
        results.add(bmi);

        Log.d("Tag", String.valueOf(valueheightmeters));

        if (bmi >= 30) {
            Log.d("Lihavuus", String.valueOf(bmi));

            bmiResult = "Lihavuus (normaali painoindeksi: 18.5 - 25)! Paras tapa pudottaa painoa on syömällä terveellisesta ja urheilulla. Vinkkejä saat painamalla alla olevasta napista.";
        } else if (bmi >= 25) {
            Log.d("Lievä lihavuus", String.valueOf(bmi));
            bmiResult = "Lievä lihavuus (normaali painoindeksi: 18.5 - 25)! Vinkkejä laihduttamiseen saat alla olevasta napista.";
        } else if (bmi >= 18.5) {
            Log.d("Normaali paino", String.valueOf(bmi));
            bmiResult = "Painoindeksisi on normaali! Lisää vinkkejä terveellisiin elämäntapoihin saat painamalla alla olevasta napista.";
        } else {
            Log.d("Alipaino", String.valueOf(bmi));
            bmiResult = "Olet alipainonen (normaali painoindeksi: 18.5 - 25)! Muista syödä enemmän. Hyviä vinkkejä saat alla olevesta napista";
        }

    }

    /**
     * Get calculated BMI result as a string
     * @return Calculated BMI result as a string
     */
    public String getBmi() {
        return this.bmiString;
    }

    public String getClassification() {
        return this.bmiResult;
    }

    public List<Double> getResults () {
        return this.results;
    }
}
