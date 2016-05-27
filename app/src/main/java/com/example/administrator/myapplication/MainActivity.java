package com.example.administrator.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    ArrayList<mDrink> armDrink;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        armDrink=new ArrayList<mDrink>();
        mDrink mdrink;
        mdrink=new mDrink(R.drawable.c1,"Coffee","겁나 써요써");
        armDrink.add(mdrink);
        mdrink=new mDrink(R.drawable.c2,"Cafe Latte","겁나 부드러움");
        armDrink.add(mdrink);
        mdrink=new mDrink(R.drawable.c3,"Lemonade","겁나 상큼함");
        armDrink.add(mdrink);
        mdrink=new mDrink(R.drawable.c4,"Milk Tea","겁나 달달함");
        armDrink.add(mdrink);
        mdrink=new mDrink(R.drawable.choa,"Choa","겁나 이뻐요");
        armDrink.add(mdrink);
        mdrink=new mDrink(R.drawable.cho,"조현영","아이고 귀여워");
        armDrink.add(mdrink);

        MyAdapter adapter = new MyAdapter(this, R.layout.itemlist, armDrink);

        listView = (ListView)this.findViewById(R.id.listView);
        listView.setAdapter(adapter);

//
//        ArrayList<String> mDrink = new ArrayList<String>();
//        mDrink.add("Coffee");
//        mDrink.add("Juice/Tea");
//        mDrink.add("Smoothie");
//        mDrink.add("Side");
//
//        MyAdapter adapter1 = new MyAdapter(this, R.layout.itemlist,mDrink);
//        listView=(ListView)findViewById(R.id.listView);
//        listView.setAdapter(adapter1);
    }
}

class MyAdapter extends BaseAdapter{
    Context con;
    int resource;
    ArrayList<mDrink> li;
    LayoutInflater inflater;
    int ct;
    MyAdapter(Context context, int act, ArrayList<mDrink> ali) {
        con = context;
        ct = act;
        li = ali;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.v("생성자확인", "콜");
    }

    @Override
    public int getCount(){
        Log.v("어댑터","카운터값"+li.size());
        return li.size();

    }
    @Override
    public Object getItem(int position){

        return li.get(position).name;
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("확인","겟뷰");
        if(convertView==null){
            convertView=inflater.inflate(ct,parent,false);
        }
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);
        img.setImageResource(li.get(position).cImage);

        TextView txt1 = (TextView)convertView.findViewById(R.id.textView1);
        txt1.setText(li.get(position).name);
        TextView txt2= (TextView)convertView.findViewById(R.id.textView2);
        txt2.setText(li.get(position).cont);

        return convertView;
    }

}


