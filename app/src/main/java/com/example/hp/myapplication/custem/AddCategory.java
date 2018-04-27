package com.example.hp.myapplication.custem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hp.myapplication.R;

public class AddCategory extends AppCompatActivity {
    ListView lst;
    String[] Category = {"Food","Clothes","Communication","Eating out", "Health" , "House" , "Transport" , "Sports","Baby Care"};
    Integer[] imigd = {R.drawable.food,R.drawable.dress,R.drawable.communications,R.drawable.eating_out,R.drawable.health,R.drawable.rent,R.drawable.car,R.drawable.sports,R.drawable.baby};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
         lst = findViewById(R.id.listcategory);
         CustomListview customListview = new CustomListview(this,Category,imigd);
         lst.setAdapter(customListview);

    }



    }