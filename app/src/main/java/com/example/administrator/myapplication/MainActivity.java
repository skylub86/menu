package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)this.findViewById(R.id.listView);



        ArrayList<String> mDrink = new ArrayList<String>();
        mDrink.add("Coffee");
        mDrink.add("Juice/Tea");
        mDrink.add("Smoothie");
        mDrink.add("Side");


        ArrayAdapter<String> Adapter;
        Adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, mDrink);
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(Adapter);


    }
}
