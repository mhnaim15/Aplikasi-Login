package com.example.responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginadmin extends AppCompatActivity {

    Button b1,b2;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginadmin);
        b1 = (Button) findViewById(R.id.btnlogin);
        b2 = (Button) findViewById(R.id.btnback);
        ed1 = (EditText) findViewById(R.id.user);
        ed2 = (EditText) findViewById(R.id.pass);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")) {
                    Intent inte = new Intent(loginadmin.this, tampiladmin.class);
                    startActivity(inte);
                    Toast.makeText(loginadmin.this, "Log in Berhasil ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(loginadmin.this, "Log in Gagal Silahkan Cek kembali ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginadmin.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}