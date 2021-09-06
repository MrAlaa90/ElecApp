package com.example.elecapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Users_DB extends SQLiteOpenHelper

{

    public static final String DBname = "data.db";

    public Users_DB(@Nullable Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL
            ("create table users ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, password STRING)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData (String name,String password)  {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        long result = sqLiteDatabase.insert("users",null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
}
