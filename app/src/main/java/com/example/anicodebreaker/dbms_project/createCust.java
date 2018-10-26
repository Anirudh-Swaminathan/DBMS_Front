package com.example.anicodebreaker.dbms_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anicodebreaker.dbms_project.model.UpdCust;
import com.example.anicodebreaker.dbms_project.rest.ApiClient;
import com.example.anicodebreaker.dbms_project.rest.ApiInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class createCust extends AppCompatActivity {

    TextView user, cname, pass, street, city;
    Button crtBtn;

    String cuser, ccname, cpass, cstrt, ccity;

    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cust);

        user = (TextView) findViewById(R.id.custUserIn);
        cname = (TextView) findViewById(R.id.custNameIn);
        pass = (TextView) findViewById(R.id.custPwdIn);
        street = (TextView) findViewById(R.id.custStreetIn);
        city = (TextView) findViewById(R.id.custCityIn);

        crtBtn = (Button) findViewById(R.id.custConfBtn);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        crtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuser = user.getText().toString();
                ccname = cname.getText().toString();
                cpass = pass.getText().toString();
                cstrt = street.getText().toString();
                ccity = city.getText().toString();

                Map<String, String> data = new HashMap<>();
                data.put("username", cuser);
                data.put("name", ccname);
                data.put("password", cpass);
                data.put("street", cstrt);
                data.put("city", ccity);

                Call<UpdCust> call = apiService.createNewCustomer(data);
                call.enqueue(new Callback<UpdCust>() {
                    @Override
                    public void onResponse(Call<UpdCust> call, Response<UpdCust> response) {
                        try {
                            if (response.body().getSuccess().equals("true")) {
                                Toast.makeText(createCust.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(createCust.this, Login.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(createCust.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(createCust.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdCust> call, Throwable t) {
                        Toast.makeText(createCust.this, "Failure is the next step to success", Toast.LENGTH_SHORT).show();
                        Toast.makeText(createCust.this, "The error was " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
