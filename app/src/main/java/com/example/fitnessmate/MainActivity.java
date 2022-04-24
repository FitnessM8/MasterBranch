package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public static final String Name_TEXT = "com.example.myfirstapp.MESSAGE";
    public static final String AGE_TEXT = "com.example.myfirstapp.AGE";
    public SeekBar ageBar;
    public SeekBar weightBar;
    public SeekBar heightBar;
    public static TextView ageText;
    public static TextView weightText;
    public static TextView heightText;
    Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        ageBar = (SeekBar) findViewById(R.id.Age_SeekBar);
        weightBar = (SeekBar) findViewById(R.id.Weight_SeekBar);
        heightBar = (SeekBar) findViewById(R.id.height_SeekBar);
        ageText = (TextView) findViewById(R.id.Age_Number);
        weightText = (TextView) findViewById(R.id.Weight_Number);
        heightText = (TextView) findViewById(R.id.height_Number2);
        Button = (Button) findViewById(R.id.Calculate_Button);

        weightBar.setMax(300);
        heightBar.setMax(300);

        ageBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ageText.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        weightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                weightText.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        heightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                heightText.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

            Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double bmi = 0;
                double valueheight = 0;
                double valueweight = 0;
                Double valueheightmeters;

                valueheight =Double.parseDouble(heightText.getText().toString());
                valueweight =Double.parseDouble(weightText.getText().toString());

                valueheightmeters = valueheight / 100; // Converting to meters.

                bmi = (valueweight / (valueheightmeters * valueheightmeters));

                Log.d("Tag", String.valueOf(bmi));

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
        });

    }
}