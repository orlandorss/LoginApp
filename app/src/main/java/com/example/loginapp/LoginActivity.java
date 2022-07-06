package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button signin;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        signin=findViewById(R.id.signin);
        DB=new DBHelper(this);


        signin.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (TextUtils.isEmpty(user)||TextUtils.isEmpty(pass))
                Toast.makeText(LoginActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
            else {
                Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                if (checkuserpass){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
