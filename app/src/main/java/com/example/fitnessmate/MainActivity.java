package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
  public static final String Name_TEXT = "com.example.myfirstapp.MESSAGE";
public static final String AGE_TEXT = "com.example.myfirstapp.AGE";
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayResultActivity.class);
        Bundle nameAndAge = new Bundle();
        EditText nameText = (EditText) findViewById(R.id.nameText);
        EditText ageText = (EditText) findViewById(R.id.ageText);
        String nameMessage = nameText.getText().toString();
        String ageMessage = ageText.getText().toString();
        nameAndAge.putString("NAME_MESSAGE", nameMessage);
        nameAndAge.putString("AGE_MESSAGE", ageMessage);
        intent.putExtras(nameAndAge);
        startActivity(intent);

    }
}