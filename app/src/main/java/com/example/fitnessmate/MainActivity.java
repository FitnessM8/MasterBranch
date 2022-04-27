package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String Name_TEXT = "com.example.myfirstapp.MESSAGE";
    public static final String AGE_TEXT = "com.example.myfirstapp.AGE";
    public SeekBar ageBar;
    public SeekBar weightBar;
    public SeekBar heightBar;
    public static TextView ageText;
    public static TextView weightText;
    public static TextView heightText;
    Button button;
    ImageView male, female;
    String typeofuser = "0";

    CalculateButton onclick = new CalculateButton();
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
        button = (Button) findViewById(R.id.Calculate_Button);
        weightBar.setMax(300);
        heightBar.setMax(200);

        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderselected));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gendernotselected));
                typeofuser = "Memale";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.genderselected));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gendernotselected));
                typeofuser = "Female";
            }
        });

        BarListener.barListener(ageBar, ageText);
        BarListener.barListener(weightBar, weightText);
        BarListener.barListener(heightBar, heightText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.onClick(view, weightText, heightText);
            }
        });

    }
}