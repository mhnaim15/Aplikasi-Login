package com.example.responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginuser extends AppCompatActivity {

    Button b1,b2;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginuser);
        b1 = (Button) findViewById(R.id.btnlogin);
        b2 = (Button) findViewById(R.id.btnadmin);
        ed1 = (EditText) findViewById(R.id.user);
        ed2 = (EditText) findViewById(R.id.pass);
        b1.setOnClickListener(view -> {
            if(ed1.getText().toString().equals("user")&&ed2.getText().toString().equals("user"))
            {
                Intent homepage = new Intent(loginuser.this, tampiluser.class);
                startActivity(homepage);
                Toast.makeText(loginuser.this, "Log in Berhasil ", Toast.LENGTH_SHORT).show();
            }
            else if(ed1.getText().toString().equals("naim")&&ed2.getText().toString().equals("naim14"))
            {
                Intent homepage = new Intent(loginuser.this, tampiluser.class);
                startActivity(homepage);
                Toast.makeText(loginuser.this, "Log in Berhasil ", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(loginuser.this, "Log in Gagal Silahkan Cek kembali ", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(loginuser.this, loginadmin.class);
                startActivity(inte);
            }
        });
    }
}