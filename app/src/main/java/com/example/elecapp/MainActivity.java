package com.example.elecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText username, pass;
    private Button login;
    private SharedPreferences shared;
    Users_DB db = new Users_DB(this);

    EditText name , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shared = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if (shared.getString("save","").equals("done")){
             startActivity(new Intent(MainActivity.this,TapActivity.class));
        }else {
            setContentView(R.layout.activity_main);
            if (shared.getInt("shortcut",0)!=1){
                creatShortcut();
            }
        }
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTextUserName);
        pass = findViewById(R.id.editTextPass);
        login = findViewById(R.id.LoginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shared.edit().putString("data", username.getText().toString()).commit();
                shared.edit().putString("data",pass.getText().toString()).commit();
                shared.edit().putString("save","done").commit();
                Intent i = new Intent(MainActivity.this,TapActivity.class);
                startActivity(i);
            }
        });

                 name = (EditText) findViewById(R.id.editTextUserName);
                 password = (EditText) findViewById(R.id.editTextPass);

        }
    private void creatShortcut(){
        Intent ishortcut = new Intent(getBaseContext(), MainActivity.class);
        ishortcut.setAction(Intent.ACTION_MAIN);
        Intent shortcut = new Intent();
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, ishortcut);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, "ELEC APP");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                R.drawable.ic_launcher_background);
        shortcut.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        sendBroadcast(shortcut);
        shared.edit().putInt("shortcut",1).commit();


    }

    public void SignupBtn(View view) {
        String Name = name.getText().toString();
        String Password = password.getText().toString();
       Boolean result = db.insertData(Name,Password);
       if (result == true) {
           Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                name.setText("");
                password.setText("");
         }else {
           Toast.makeText(MainActivity.this, "NO", Toast.LENGTH_SHORT).show();
       }

    }
}