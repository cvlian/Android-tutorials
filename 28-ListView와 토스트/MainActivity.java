package com.example.yangjiwon.city0908;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        list.add(0, "hello");
        list.add(0, "world");
        adapter.notifyDataSetChanged();
        AdapterView.OnItemClickListener m = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(MainActivity.this, arg2 + "", Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(m);
    }

}

/*
리스트의 내용을 얻고 싶다면

listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), list.get(position), Toast.LENGTH_SHORT).show();
            }
        });

또는 위의 코드를 고쳐서

AdapterView.OnItemClickListener m = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(MainActivity.this, list.get(arg2), Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(m);

ListActivity를 상속 받았다면

@Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getApplicationContext(), list.get(position), Toast.LENGTH_SHORT).show();
    }
*/