package com.example.elecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ElecActivity extends AppCompatActivity {

    Button trnsBtn, dis, k6Btn, chinvBtn, etchBtn, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elec);

        trnsBtn = findViewById(R.id.trnsBtn);
        dis = findViewById(R.id.dis);
        chinvBtn = findViewById(R.id.chinvBtn);
        etchBtn = findViewById(R.id.etchBtn);
        home = findViewById(R.id.home);
        k6Btn =findViewById(R.id.k6Btn);


        trnsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElecActivity.this, TransActivity.class);
                startActivity(i);

            }
        });

        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElecActivity.this, DieselActivity.class);
                startActivity(i);
            }
        });

        k6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElecActivity.this, SgMcc.class);
                startActivity(i);
            }
        });


        chinvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElecActivity.this, ChargerInverter.class);
                startActivity(i);
            }
        });
        etchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElecActivity.this, TechnicalActivity.class);
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ElecActivity.this, TapActivity.class);
                startActivity(i);
            }
        });

    }
}


