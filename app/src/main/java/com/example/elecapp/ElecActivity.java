package com.example.elecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ElecActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elec);

        editText = findViewById(R.id.et_lctc2);
        editText = findViewById(R.id.editrstg);

    }
}