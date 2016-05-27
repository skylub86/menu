package com.example.administrator.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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


        MyAdapter adapter = new MyAdapter(this, R.layout.itemlist);
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);


    }
}

class MyAdapter extends BaseAdapter{
    Context con;
    LayoutInflater inflater;
    ArrayList<MyAdapter> adt;
    int layout;
  
    public MyAdapter(Context context, int alayout, ArrayList<MyAdapter> aadt){
        con= context;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        adt=aadt;
    }
    @Override
    public int getCount(){
        return adt.size();
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        return convertView;
    }

}
