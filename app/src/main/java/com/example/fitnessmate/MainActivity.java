package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String Name_TEXT = "com.example.myfirstapp.MESSAGE";
    public static final String AGE_TEXT = "com.example.myfirstapp.AGE";
    public SeekBar ageBar;
    public SeekBar weightBar;
    public SeekBar heightBar;
    public TextView ageText;
    public TextView weightText;
    public TextView heightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
//The application will display without Title

        ageBar = (SeekBar) findViewById(R.id.Age_SeekBar);
        weightBar = (SeekBar) findViewById(R.id.Weight_SeekBar);
        heightBar = (SeekBar) findViewById(R.id.height_SeekBar);
        ageText = (TextView) findViewById(R.id.Age_Number);
        weightText = (TextView) findViewById(R.id.Weight_Number);
        heightText = (TextView) findViewById(R.id.height_Number2);


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

    }
}