package com.example.yangjiwon.city0503;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Citizen01 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen01);
        final String data[]={"CITIZEN", "CIVILIAN", "JEESHA"};
        Spinner spin=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(ad);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                Toast.makeText(getApplicationContext(), data[(int)arg3], Toast.LENGTH_SHORT).show();
            }
            @Override
        public void onNothingSelected(AdapterView<?> arg0){
                Toast.makeText(getApplicationContext(), "didn't select", Toast.LENGTH_SHORT).show();
            }
        });
    }
}