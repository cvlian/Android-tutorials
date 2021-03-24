package com.example.yangjiwon.city0901;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private EditText name;
    private EditText email;
    private ArrayAdapter adapter;
    private ArrayList<Citizen> list;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        name = (EditText)findViewById(R.id.editText);
        email = (EditText)findViewById(R.id.editText2);
        list = new ArrayList<Citizen>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listPrint();
        registerForContextMenu(listView);
    }

    public void clear(View view){
        ((EditText)view).setText("");
    }

    public void save(View view){
        String str_name = name.getText().toString();
        String str_email = email.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(C1ContentProvider.KEY_NAME, str_name);
        cv.put(C1ContentProvider.KEY_EMAIL, str_email);
        getContentResolver().insert(C1ContentProvider.CONTENT_URI, cv);
        listPrint();
        name.setText(" ");
        email.setText(" ");
    }

    public void listPrint(){
        cursor = getContentResolver().query(C1ContentProvider.CONTENT_URI, null, null, null, null);
        adapter.clear();
        if(cursor.moveToFirst()){
            do{
                Citizen c = new Citizen();
                c.setId(cursor.getInt(0));
                c.setName(cursor.getString(1));
                c.setEmail(cursor.getString(2));
                adapter.add(c);
            } while(cursor.moveToNext());
        }
        adapter.notifyDataSetChanged();
    }
}