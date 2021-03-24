package com.example.yangjiwon.city0901s;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private ArrayAdapter<Citizen> adapter;
    private ArrayList<Citizen> list;
    private Cursor cursor;

    public static final Uri CONTENT_URI = Uri.parse("content://com.example.yangjiwon.city0901.C1Provider/email");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        list = new ArrayList<Citizen>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        show();
    }

    public void show(){
        cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        adapter.clear();
        if(cursor.moveToFirst()) {
            do {
                Citizen citizen = new Citizen();
                citizen.setId(cursor.getInt(0));
                citizen.setName(cursor.getString(1));
                citizen.setEmail(cursor.getString(2));
                adapter.add(citizen);
            } while (cursor.moveToNext());
        }
        adapter.notifyDataSetChanged();
    }
}