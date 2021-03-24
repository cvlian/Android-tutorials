package com.example.yangjiwon.city0820;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> strs;
    private int idx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        strs = new ArrayList<String>();
        strs.add("Alan");
        strs.add("Schezar");
        strs.add("Jeesha");
        strs.add("Ysera");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        idx = info.position;
        switch(item.getItemId()){
            case R.id.delete:
                showDialog();
                return true;
        }
        return false;
    }

    void showDialog(){
        DialogFragment newFragment = MainFragment.newInstance("진짜 삭제하시렵니까?");
        newFragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick(){
        strs.remove(idx);
        adapter.notifyDataSetChanged();
    }

    public void doNegativeClick(){
        Toast.makeText(this, "그럴줄 알았어 쫄보야", Toast.LENGTH_SHORT).show();
    }

}