package com.example.anicodebreaker.dbms_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProjMain extends AppCompatActivity {

    Button loansBtn, accountsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_main);

        loansBtn = (Button) findViewById(R.id.loansBtn);
        accountsBtn = (Button) findViewById(R.id.accountsBtn);

        loansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProjMain.this, Loans.class);
                startActivity(i);
            }
        });

        accountsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProjMain.this, Accounts.class);
                startActivity(i);
            }
        });
    }
}
