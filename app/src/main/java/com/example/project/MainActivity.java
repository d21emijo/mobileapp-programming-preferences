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
    //SharedPreferences preferences;
    EditText EditText1;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("===create","geaga");


        save = findViewById(R.id.save);
        EditText1 =new EditText(this);
        EditText1 = (EditText)findViewById(R.id.edit_text);
        textViewName = findViewById(R.id.name);




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);
                SharedPreferences.Editor myPreferenceEditor = preferences.edit();




                myPreferenceEditor.putString("name1",EditText1.getText().toString());
                myPreferenceEditor.apply();
                Log.d("===", preferences.getString("name1", "nopes"));
                openNewActivity();


            }
        });





        //
        /*
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", "test");
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
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        //String name = preferences.getString("name", "NO NAME FOUdthrhtrhrND");
        //textViewName.setText(name);
        textViewName.setText(preferences.getString("name1", "No preference found."));
        //Log.d("===nn",name);
        Log.d("===resume","geaga");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("===stop","geaga");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("===destroy","geagatutu");
    }
}
