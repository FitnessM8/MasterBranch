package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fitnessmate.DisplayMessageActivity;
import com.example.fitnessmate.R;

public class MainActivity extends AppCompatActivity {
    public static final String Name_TEXT = "com.example.myfirstapp.MESSAGE";
    public static final String AGE_TEXT = "com.example.myfirstapp.AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /** Called when the user taps the Send button */
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.Name);
        EditText editAge = (EditText) findViewById(R.id.Age);
        String message = editText.getText().toString();
        String ageMessage = editAge.getText().toString();
        intent.putExtra(Name_TEXT, "Hello " + message +  ", you are " + ageMessage + " years old");
        startActivity(intent);

    }


}