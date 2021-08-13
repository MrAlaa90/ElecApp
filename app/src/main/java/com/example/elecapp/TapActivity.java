package com.example.elecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TapActivity extends AppCompatActivity {

    Button elecBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);

        elecBtn = findViewById(R.id.elecBtn);
        elecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TapActivity.this,ElecActivity.class);
                startActivity(i);
            }
        });

    }
}