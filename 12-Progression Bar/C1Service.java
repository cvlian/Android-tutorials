package com.example.yangjiwon.city0828;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class C1Service extends Service {

    private int volume = 50;
    private Binder m = new C1Inner();

    public C1Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "º¼·ý ¼³Á¤½ÃÀÛ", Toast.LENGTH_SHORT).show();
        return m;
    }

    @Override
    public boolean onUnbind(Intent intent){
        super.onUnbind(intent);
        Toast.makeText(getApplicationContext(), "º¼·ý ¼³Á¤Á¾·á", Toast.LENGTH_SHORT).show();
        return false;
    }

    class C1Inner extends Binder{
        public int volUp(){
            volume+=10;
            if(volume>=100) volume = 100;
            Toast.makeText(getApplicationContext(), "º¼·ý UP", Toast.LENGTH_SHORT).show();
            return volume;
        }

        public int volDown(){
            volume-=10;
            if(volume<0) volume = 0;
            Toast.makeText(getApplicationContext(), "º¼·ý DOWN", Toast.LENGTH_SHORT).show();
            return volume;
        }
    }
}