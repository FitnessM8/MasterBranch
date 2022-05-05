package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import java.lang.annotation.Retention;

public class MainActivity extends AppCompatActivity {
    public static final String BMI_RESULT_STRING = "bmiResultString";
    public static final String BMI_RESULT_Number = "bmiResultNumber";

    public SeekBar ageBar;
    public SeekBar weightBar;
    public SeekBar heightBar;
    public  TextView ageText;
    public  TextView weightText;
    public  TextView heightText;
    Button button;
    ImageView male, female;
    String typeofuser = "0";

    /**
     * Setting instance of Calculation class
     */
    Calculation bmiCalculateButton = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Application opens up with hidden title
         */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
//The application will display without Title

        /**
         * Getting Widgets from layout
         */
        ageBar = (SeekBar) findViewById(R.id.Age_SeekBar);
        weightBar = (SeekBar) findViewById(R.id.Weight_SeekBar);
        heightBar = (SeekBar) findViewById(R.id.height_SeekBar);
        ageText = (TextView) findViewById(R.id.Age_Number);
        weightText = (TextView) findViewById(R.id.Weight_Number);
        heightText = (TextView) findViewById(R.id.height_Number2);
        button = (Button) findViewById(R.id.Calculate_Button);

        /**
         * Setting Max values for seekbars
         */
        weightBar.setMax(300);
        heightBar.setMax(300);

        /**
         * Getting female and male imageViews from activity_main.xml
         */
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);


        /**
         * Changing background color if female or male imageView is selected
         * Learned from https://www.youtube.com/watch?v=8VfhyHVFo2M&t=920s
         */
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.notselected));
                typeofuser = "Memale";
            }
        });

        /**
         * Changing background color if female or male imageView is selected
         */
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.notselected));
                typeofuser = "Female";
            }
        });

/**
 * Setting seekbar values to layoutTextViews
 */
        BarListener.barListener(ageBar, ageText);
        BarListener.barListener(weightBar, weightText);
        BarListener.barListener(heightBar, heightText);


        /**
         * if User values equal 0 calculation doesnt work
         * When user presses Laske button WeightText and HeightText gets sended to calculationclass.
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (weightText.getText().toString().equals("0") | heightText.getText().toString().equals("0") | ageText.getText().toString().equals("0")) {        

                } else {
                    bmiCalculateButton.onClick(view, weightText, heightText);

                    String bmi = bmiCalculateButton.getBmi();
                    String bmiLuokka = bmiCalculateButton.getClassification();
/**
 * Sending Bmi results to DisplayResultActivity and starting it
 */
                    Intent intent = new Intent(MainActivity.this, DisplayResultActivity.class);
                    intent.putExtra(BMI_RESULT_Number, bmi);
                    intent.putExtra(BMI_RESULT_STRING, bmiLuokka);
                    startActivity(intent);
                }
            }
        });
    }
}