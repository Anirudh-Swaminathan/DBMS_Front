package com.example.anicodebreaker.dbms_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProjMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_main2);

        ((Button) findViewById(R.id.createBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crtIntent = new Intent(ProjMain.this, CreateAct.class);
                startActivity(crtIntent);
            }
        });

        ((Button) findViewById(R.id.updateBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updIntent = new Intent(ProjMain.this, UpdateAct.class);
                startActivity(updIntent);
            }
        });

        ((Button) findViewById(R.id.viewBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent(ProjMain.this, ViewAct.class);
                startActivity(viewIntent);
            }
        });
    }
}
