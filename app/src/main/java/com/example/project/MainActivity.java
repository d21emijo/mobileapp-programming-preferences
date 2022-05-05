package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TextView textViewName;
    SharedPreferences preferences;
    EditText EditText1;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);








        save = findViewById(R.id.save);
        EditText1 = findViewById(R.id.edit_text);
        textViewName = findViewById(R.id.name);
        preferences = getSharedPreferences("preferences",MODE_PRIVATE);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("==>","rsh!");
                Log.d("==",EditText1.getText().toString());


                openNewActivity();






            }
        });





        /*
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", "emil");
        editor.apply();
        */
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, SecondaryActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        String name = preferences.getString("name", "NO NAME FOUND");
        textViewName.setText(name);

    }
}
