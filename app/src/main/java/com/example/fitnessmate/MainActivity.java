package com.example.fitnessmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
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