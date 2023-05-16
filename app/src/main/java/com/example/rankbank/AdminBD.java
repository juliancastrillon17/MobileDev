package com.example.rankbank;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class AdminBD extends SQLiteOpenHelper {


    public AdminBD(@Nullable Context context,@Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // sqLiteDatabase.execSQL("create table usuario(identificacion int primary key, nombre text,numero int)");
        String createTableQuery = "CREATE TABLE usuario (" +
                "identificacion INTEGER PRIMARY KEY," +
                "usuario TEXT," +
                "pass TEXT)";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

}