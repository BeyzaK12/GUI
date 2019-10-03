package com.example.listviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    Button arrayAdapterButton;
    Button customAdapterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapterButton = findViewById(R.id.array_adapter);
        customAdapterButton = findViewById(R.id.custom_adapter);

        AdapterButtonListener listener = new AdapterButtonListener();
        //View.OnClickListener listener = new AdapterButtonListener();

        arrayAdapterButton.setOnClickListener(listener);


        View.OnClickListener listener2 = new View.OnClickListener(){
            //anonymous class
            @Override
            public void onClick(View v) {
                Log.d("AdapterButtonListener","Clicked");
                Intent intent = new Intent(MainActivity.this,CustomAdapterActivity.class);
                startActivity(intent);
            }
        };

        customAdapterButton.setOnClickListener(listener2);


    }

    private class AdapterButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Log.d("AdapterButtonListener","Clicked");
            Intent intent = new Intent(MainActivity.this,ArrayAdapterActivity.class);
            startActivity(intent);
        }
    }
}
