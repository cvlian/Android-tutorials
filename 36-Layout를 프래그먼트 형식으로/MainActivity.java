package com.example.yangjiwon.city0912;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    public static EditText et;
    public static Button bt;
    public static ListView listView;
    public static ArrayList<String> list;
    public static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    public void addCitizen(View view){
        list.add(et.getText().toString());
        adapter.notifyDataSetChanged();
        et.setText("");
    }
}