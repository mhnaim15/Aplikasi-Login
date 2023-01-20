package com.example.responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class lihat extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton2, maps;
    TextView text, text1, text2, text3;

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        dbHelper = new DataHelper(this);
        text = (TextView) findViewById(R.id.textViewliat);
        text1 = (TextView) findViewById(R.id.textViewliat1);
        text2 = (TextView) findViewById(R.id.textViewliat2);
        text3 = (TextView) findViewById(R.id.textViewliat3);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM user WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text.setText(cursor.getString(0).toString());
            text1.setText(cursor.getString(1).toString());
            text2.setText(cursor.getString(2).toString());
            text3.setText(cursor.getString(3).toString() + " jam");
        }

        ton2 = (Button) findViewById(R.id.button1);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        maps = (Button) findViewById(R.id.btnmaps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maps = new Intent(lihat.this, MapsActivity.class);
                startActivity(maps);
            }
        });
    }
}