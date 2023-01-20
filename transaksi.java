package com.example.responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class transaksi extends AppCompatActivity {
    Button ton1,ton2;
    EditText editsewa,editharga;
    TextView totalbiaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);


        ton2 = (Button) findViewById(R.id.button2);
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte = new Intent(transaksi.this, tampiluser.class);
                startActivity(inte);
            }
        });

        ton1 = (Button) findViewById(R.id.button1);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                editsewa = (EditText) findViewById(R.id.EditText01);
                editharga = (EditText) findViewById(R.id.EditText02);
                totalbiaya = (TextView) findViewById(R.id.TextView03);

                String Sewa = editsewa.getText().toString().trim();
                String Harga = editharga.getText().toString().trim();

                double s = Double.parseDouble(Sewa);
                double h = Double.parseDouble(Harga);
                double total = (s * h);
                totalbiaya.setText("Total Harga Sewa : " + total);
            }
        });
    }

}