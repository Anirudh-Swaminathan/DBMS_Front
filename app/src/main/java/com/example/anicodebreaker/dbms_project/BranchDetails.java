package com.example.anicodebreaker.dbms_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BranchDetails extends AppCompatActivity {

    TextView branchDetailsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_details);

        branchDetailsText = (TextView) findViewById(R.id.branchDetailsText);

        Bundle b = getIntent().getExtras();

        String branchname = b.getString("branchname");
        String branchcity = b.getString("branchcity");
        int assets = b.getInt("assets");

        branchDetailsText.setText(branchname + "\n" + branchcity + "\n" + assets);
    }
}
