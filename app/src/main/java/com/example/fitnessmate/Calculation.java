package com.example.fitnessmate;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;

import javax.xml.transform.Result;

public class Calculation extends AppCompatActivity {

    double bmi = 0;
    double valueheight = 0;
    double valueweight = 0;
    double valueheightmeters;
    private static String bmiString;
    private static String bmiResult;

    public void onClick(View view, TextView weightText, TextView heightText) {

        /**
         *Converting Height and Weight values to double from TextViewstrings
         */
        valueheight = Double.parseDouble(heightText.getText().toString());
        valueweight = Double.parseDouble(weightText.getText().toString());

        /**
         * Calculating user bmi from given height and weight
         */
        valueheightmeters = valueheight / 100; // Converting to meters.

        bmi = (valueweight / (valueheightmeters * valueheightmeters));
        bmiString = String.format("%.1f", bmi);


        /**
         * Checks what is user Bmi value result and sets result String to bmiResult variable
         */
        if (bmi >= 30) {
            bmiResult = "Lihavuus (normaali painoindeksi: 18.5 - 25)! Paras tapa pudottaa painoa on syömällä terveellisesta ja urheilulla. Vinkkejä saat painamalla alla olevasta napista.";
        } else if (bmi >= 25) {
            bmiResult = "Lievä lihavuus (normaali painoindeksi: 18.5 - 25)! Vinkkejä laihduttamiseen saat alla olevasta napista.";
        } else if (bmi >= 18.5) {
            bmiResult = "Painoindeksisi on normaali! Lisää vinkkejä terveellisiin elämäntapoihin saat painamalla alla olevasta napista.";
        } else {
            bmiResult = "Olet alipainonen (normaali painoindeksi: 18.5 - 25)! Muista syödä enemmän. Hyviä vinkkejä saat alla olevesta napista";
        }

    }

    /**
     * Get calculated BMI result as a string
     *
     * @return Calculated BMI result as a string
     */
    public String getBmi() {
        return this.bmiString;
    }

    /**
     * Get BMI Classification as a string
     *
     * @return BMI Classification as a string
     */
    public String getClassification() {
        return this.bmiResult;
    }
}
