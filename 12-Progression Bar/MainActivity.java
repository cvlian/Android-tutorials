package com.example.yangjiwon.city0828;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ProgressBar progressBar;
    private int vol = 50;
    IBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(vol);
    }

    public void bind(View view){
        Intent intent = new Intent(getApplicationContext(), C1Service.class);
        bindService(intent, sc, Context.BIND_AUTO_CREATE);
    }

    public void volumeUp(View view){
        if(binder != null){
            vol = ((C1Service.C1Inner)binder).volUp();
            progressBar.setProgress(vol);
        } else{
            Toast.makeText(getApplicationContext(), "Bind 먼저", Toast.LENGTH_SHORT).show();
        }
    }

    public void volumeDown(View view){
        if(binder != null){
            vol = ((C1Service.C1Inner)binder).volDown();
            progressBar.setProgress(vol);
        } else{
            Toast.makeText(getApplicationContext(), "Bind 먼저", Toast.LENGTH_SHORT).show();
        }
    }

    public void unbind(View view){
        unbindService(sc);
        binder = null;
    }

    public ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binder = null;
        }
    };

}