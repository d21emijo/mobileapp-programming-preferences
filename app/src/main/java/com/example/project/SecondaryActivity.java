package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        SharedPreferences myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);

        //myPreferenceRef.getString("name","no name found");

        Log.d("===second",myPreferenceRef.getString("name1","no name found"));
        TextView textView = findViewById(R.id.text_Name);
        textView.setText(myPreferenceRef.getString("name1", "hejdå"));


    }
}
