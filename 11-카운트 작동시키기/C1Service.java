package com.example.yangjiwon.city0815;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class C1Service extends Service {

    private int num = 0;

    public C1Service() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "카운트 시작!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        for(int i = 0; i < 1000; i++){ // 최대치
            num++;
            if(num % 10 == 0){  // 카운트 10마다 토스트. 카운트 10개가 1초
                Toast.makeText(getApplicationContext(), "Count : "+num, Toast.LENGTH_SHORT).show();
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "종료", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}