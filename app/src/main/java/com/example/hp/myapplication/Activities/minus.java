package com.example.hp.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.hp.myapplication.R;
import com.example.hp.myapplication.custem.CategoryAdapter;
import com.example.hp.myapplication.custem.CategoryItem;

import java.util.ArrayList;

public class minus extends AppCompatActivity {

    private ArrayList<CategoryItem> mCategoryList;
    private CategoryAdapter mAdapter;

    Button add_spent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minus);
        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner);

        mAdapter = new CategoryAdapter(this, mCategoryList);
        spinnerCountries.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        add_spent = findViewById(R.id.add_spent);
        add_spent .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(minus.this,moneymanager.class));    }
        });
    }


        private void initList(){
            mCategoryList = new ArrayList<>();
            mCategoryList.add(new CategoryItem("Select Your Category", R.drawable.ic_chevron_right_black_24dp));
            mCategoryList.add(new CategoryItem("Food", R.drawable.food));
            mCategoryList.add(new CategoryItem("Clothes", R.drawable.dress));
            mCategoryList.add(new CategoryItem("Communication", R.drawable.communications));
            mCategoryList.add(new CategoryItem("Eating Out", R.drawable.eating_out));
            mCategoryList.add(new CategoryItem("Health", R.drawable.health));
            mCategoryList.add(new CategoryItem("House", R.drawable.rent));
            mCategoryList.add(new CategoryItem("Transport", R.drawable.car));
            mCategoryList.add(new CategoryItem("Sport", R.drawable.sports));
            mCategoryList.add(new CategoryItem("Baby Care", R.drawable.baby));

        }


}

