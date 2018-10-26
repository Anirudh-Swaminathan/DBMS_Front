package com.example.anicodebreaker.dbms_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anicodebreaker.dbms_project.model.CustLogin;
import com.example.anicodebreaker.dbms_project.rest.ApiClient;
import com.example.anicodebreaker.dbms_project.rest.ApiInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button loginBtn, newRegisterBtn;
    EditText userNameIn, pwdIn;

    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        newRegisterBtn = (Button) findViewById(R.id.newRegisterBtn);
        userNameIn = (EditText) findViewById(R.id.userNameIn);
        pwdIn = (EditText) findViewById(R.id.pwdIn);

        apiService = ApiClient.getClient().create(ApiInterface.class);

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
                    loginCust(user, pwd);
                }
            }
        });

        newRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, createCust.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void loginCust(final String user, String pass) {
        Map<String, String> data = new HashMap<>();
        data.put("username", user);
        data.put("password", pass);
        Call<CustLogin> call = apiService.customerLogin(data);
        call.enqueue(new Callback<CustLogin>() {
            @Override
            public void onResponse(Call<CustLogin> call, Response<CustLogin> response) {
                try {
                    if (response.body().getSuccess().equals("true")) {
                        Toast.makeText(Login.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();

                        final SharedPreferences loginInfo = Login.this.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
                        final SharedPreferences.Editor edit = loginInfo.edit();
                        edit.putString("user", user);
                        edit.apply();

                        Intent i = new Intent(Login.this, ProjMain.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(Login.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CustLogin> call, Throwable t) {
                Toast.makeText(Login.this, "Failure is the next step to success", Toast.LENGTH_SHORT).show();
                Toast.makeText(Login.this, "The error was " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
