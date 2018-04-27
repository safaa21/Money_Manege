package com.example.hp.myapplication.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.myapplication.DB.DatabaseHelper;
import com.example.hp.myapplication.DB.User;
import com.example.hp.myapplication.R;

import java.sql.BatchUpdateException;

public class plus extends signup {
    Button add_blance;
    EditText balance;
    String id = databaseHelper.getID();
    SharedPreferences prefs = getSharedPreferences(id, MODE_PRIVATE);
    int I_D = prefs.getInt("id", 0); //0 is the default value.




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        balance = findViewById(R.id.balance);
        add_blance = findViewById(R.id.add_balance);
        add_blance .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          /*      databaseHelper.upDateData(I_D,balance.getText().toString().trim());
                Cursor res = databaseHelper.getAllData();
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("id : " + res.getString(0) + "\n");
                    buffer.append("name : " + res.getString(1) + "\n");
                    buffer.append("password : " + res.getString(2) + "\n");
                    buffer.append("balance : " + res.getString(3) + "\n");
                }
                showMassege("User" , buffer.toString());*/
            }
                  //startActivity(new Intent(plus.this,moneymanager.class));
            });

    }
    public void showMassege (String title , String massege){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(massege);
        builder.show();
    }
}
