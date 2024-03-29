package com.example.anicodebreaker.dbms_project;

import android.content.Context;
import android.content.Intent;
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
import com.example.anicodebreaker.dbms_project.model.Branch;
import com.example.anicodebreaker.dbms_project.model.CustAccLoan;
import com.example.anicodebreaker.dbms_project.rest.ApiClient;
import com.example.anicodebreaker.dbms_project.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Accounts extends AppCompatActivity {

    ListView accountsList;
    ApiInterface apiService;
    List<Account> accList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_accounts);

        accountsList = (ListView) findViewById(R.id.accountsList);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        SharedPreferences shared = Accounts.this.getSharedPreferences(Accounts.this.getString(R.string.app_name), Context.MODE_PRIVATE);
        String u = shared.getString("user", "");

        fetchAccounts(u);

        accountsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(Accounts.this, BranchDetails.class);
                String branchname, branchcity;
                int assets;
                Account acc = accList.get(i);
                Branch branch = acc.getBranch();
                branchname = branch.getBranchname();
                branchcity = branch.getBranchcity();
                assets = branch.getAssets();
                Bundle b = new Bundle();
                b.putString("branchname", branchname);
                b.putString("branchcity", branchcity);
                b.putInt("assets", assets);
                i1.putExtras(b);
                startActivity(i1);
            }
        });
    }

    public void fetchAccounts(String username) {
        if (username != null) {
            Call<CustAccLoan> call = apiService.getCustomerDetails(username);
            call.enqueue(new Callback<CustAccLoan>() {
                @Override
                public void onResponse(Call<CustAccLoan> call, Response<CustAccLoan> response) {
                    try {
                        accList = response.body().getAccounts();
                        Toast.makeText(Accounts.this, Integer.toString(accList.size()), Toast.LENGTH_SHORT).show();
                        ArrayAdapter<Account> accountsArrayAdapter = new ArrayAdapter<Account>(Accounts.this, android.R.layout.simple_list_item_1, accList);
                        accountsList.setAdapter(accountsArrayAdapter);
                    } catch (Exception e) {
                        Toast.makeText(Accounts.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CustAccLoan> call, Throwable t) {
                    Toast.makeText(Accounts.this, "Failure is the next step to success", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Accounts.this, "The error was " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
