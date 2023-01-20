package com.example.responsi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "rentalmobil.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE user(no integer primary key autoincrement, nama text null, alamat text null, lamasewa integer null)";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql); sql = "INSERT INTO user(no, nama text null, alamat text null, lamasewa integer null)";
        sql = "INSERT INTO user (no, nama, alamat, lamasewa) VALUES('1','Naimganteng','Grobogan','14')";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS session");
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }
}