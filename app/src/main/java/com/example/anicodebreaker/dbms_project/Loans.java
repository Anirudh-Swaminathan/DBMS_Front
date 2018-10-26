package com.example.anicodebreaker.dbms_project;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anicodebreaker.dbms_project.model.Account;
import com.example.anicodebreaker.dbms_project.model.CustAccLoan;
import com.example.anicodebreaker.dbms_project.model.Loan;
import com.example.anicodebreaker.dbms_project.rest.ApiClient;
import com.example.anicodebreaker.dbms_project.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Loans extends AppCompatActivity {

    ListView loansList;
    ApiInterface apiService;
    List<Loan> loanData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loans);

        loansList = (ListView) findViewById(R.id.loansList);
        apiService = ApiClient.getClient().create(ApiInterface.class);

        SharedPreferences shared = Loans.this.getSharedPreferences(Loans.this.getString(R.string.app_name), Context.MODE_PRIVATE);
        String u = shared.getString("user", "");
        fetchLoans(u);

        loansList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void fetchLoans(String username) {
        if (username != null) {
            Call<CustAccLoan> call = apiService.getCustomerDetails(username);
            call.enqueue(new Callback<CustAccLoan>() {
                @Override
                public void onResponse(Call<CustAccLoan> call, Response<CustAccLoan> response) {
                    try {
                        loanData = response.body().getLoans();
                        Toast.makeText(Loans.this, Integer.toString(loanData.size()), Toast.LENGTH_SHORT).show();
                        ArrayAdapter<Loan> accountsArrayAdapter = new ArrayAdapter<Loan>(Loans.this, android.R.layout.simple_expandable_list_item_1, loanData);
                        loansList.setAdapter(accountsArrayAdapter);
                    } catch (Exception e) {
                        Toast.makeText(Loans.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CustAccLoan> call, Throwable t) {
                    Toast.makeText(Loans.this, "Failure is the next step to success", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Loans.this, "The error was " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(Loans.this, "Not Logged in", Toast.LENGTH_SHORT).show();
        }
    }
}
