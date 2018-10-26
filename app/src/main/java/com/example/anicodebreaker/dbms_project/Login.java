package com.example.anicodebreaker.dbms_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button loginBtn, newRegisterBtn;
    EditText userNameIn, pwdIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        newRegisterBtn = (Button) findViewById(R.id.newRegisterBtn);
        userNameIn = (EditText) findViewById(R.id.userNameIn);
        pwdIn = (EditText) findViewById(R.id.pwdIn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userNameIn.getText().toString();
                String pwd = pwdIn.getText().toString();

                if(user.equals("")) {
                    userNameIn.setError("Enter user name");
                }
                if(pwd.equals("")) {
                    pwdIn.setError("Enter password");
                }
                if (!user.equals("") && !pwd.equals("")) {

                }
            }
        });
    }
}
