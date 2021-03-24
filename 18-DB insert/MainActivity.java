package com.example.yangjiwon.city0813;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText et;
    private ListView listview;
    private C1DBAdapter adapter;
    private Cursor cursor;
    private ArrayList<Citizen> names;
    private ArrayAdapter<Citizen> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.editText);
        listview = (ListView)findViewById(R.id.listView);
        names = new ArrayList<Citizen>();
        arrayAdapter = new ArrayAdapter<Citizen>(getApplicationContext(), android.R.layout.simple_list_item_1, names);
        listview.setAdapter(arrayAdapter);
        DBinit();
    }

    public void save(View view){
       String name = et.getText().toString();
       if(!name.equals( "" )){
           adapter.insertData(name);
       }
       et.setText("");
       inArr();
    }
    public void DBinit(){
        adapter = new C1DBAdapter(this.getApplicationContext());
        adapter.open();
        inArr();
    }
    public void inArr(){
        String name;
        int id;
        cursor = adapter.getAll();
        names.clear();
        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(0);
                name = cursor.getString(1);
                names.add(new Citizen(id, name));
            } while(cursor.moveToNext());
            arrayAdapter.notifyDataSetChanged();
        }
    }

   
}