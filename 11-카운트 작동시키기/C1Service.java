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
        Toast.makeText(getApplicationContext(), "ī��Ʈ ����!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        for(int i = 0; i < 1000; i++){ // �ִ�ġ
            num++;
            if(num % 10 == 0){  // ī��Ʈ 10���� �佺Ʈ. ī��Ʈ 10���� 1��
                Toast.makeText(getApplicationContext(), "Count : "+num, Toast.LENGTH_SHORT).show();
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "����", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}