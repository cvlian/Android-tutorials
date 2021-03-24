package com.yangjiwon.example.city0523;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity {
    public static EditText name;
    public static Button save;
    public static ListView citizenList;
    private ArrayList<Citizen> citizens;
    private CitizenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citizens = new ArrayList<Citizen>();
        adapter = new CitizenAdapter(this, R.layout.list_item, citizens);
        citizenList.setAdapter(adapter);
    }

    public void addCitizen(View view){
        Citizen c = new Citizen();
        c.setName(name.getText().toString());
        citizens.add(0, c);
        adapter.notifyDataSetChanged();
        name.setText("");
    }
}