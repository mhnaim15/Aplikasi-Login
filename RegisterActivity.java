package com.login.naimganteng;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText User1, Pass1, Confirm;
    Button BtnRegister1;
    DBHelper dbHelper1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper1 = new DBHelper(this);

        User1 = (EditText)findViewById(R.id.reguser);
        Pass1 = (EditText)findViewById(R.id.regpass);
        Confirm = (EditText)findViewById(R.id.confirmpass);
        BtnRegister1 = (Button)findViewById(R.id.btnRegister);
        TextView reg = (TextView)findViewById(R.id.home);

        reg.setText(fromHtml("Back to " +
                "</font><font color='#3b5998'>Login</font>"));

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        BtnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = User1.getText().toString().trim();
                String password1 = Pass1.getText().toString().trim();
                String conPassword1 = Confirm.getText().toString().trim();

                ContentValues values = new ContentValues();


                if (!password1.equals(conPassword1)){
                    Toast.makeText(RegisterActivity.this, "Password not match", Toast.LENGTH_SHORT).show();
                }else if (password1.equals("") || username1.equals("")){
                    Toast.makeText(RegisterActivity.this, "Username or Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else {
                    values.put(DBHelper.row_username, username1);
                    values.put(DBHelper.row_password, password1);
                    dbHelper1.insertData(values);

                    Toast.makeText(RegisterActivity.this, "Register successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }

    public static Spanned fromHtml(String html){
        Spanned result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}
