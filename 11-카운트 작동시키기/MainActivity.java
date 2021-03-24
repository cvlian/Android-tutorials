package com.example.yangjiwon.city0815;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        Intent intent = new Intent(getApplicationContext(), C1Service.class);
        startService(intent);
    }

    public void stop(View view){
        Intent intent = new Intent(getApplicationContext(), C1Service.class);
        stopService(intent);
    }
}