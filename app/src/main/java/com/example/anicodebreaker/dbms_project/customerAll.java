package com.example.anicodebreaker.dbms_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anicodebreaker.dbms_project.model.CustAll;
import com.example.anicodebreaker.dbms_project.rest.ApiClient;
import com.example.anicodebreaker.dbms_project.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class customerAll extends AppCompatActivity {

    ApiInterface apiService;
    TextView resTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_all);

        resTxt = (TextView) findViewById(R.id.allCustTxt);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        getAllCusts();
    }

    public void getAllCusts() {
        final String[] ansTxt = {""};
        Call<List<CustAll>> call = apiService.getAllCustomers();
        call.enqueue(new Callback<List<CustAll>>() {
            @Override
            public void onResponse(Call<List<CustAll>> call, Response<List<CustAll>> response) {
                try {
                    for (CustAll cust : response.body()) {
                        ansTxt[0] += cust.toString();
                    }

                    resTxt.setText(ansTxt[0]);
                } catch (Exception e) {
                    Toast.makeText(customerAll.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CustAll>> call, Throwable t) {
                Toast.makeText(customerAll.this, "Failure is the next step to success", Toast.LENGTH_SHORT).show();
                Toast.makeText(customerAll.this, "The error was " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
