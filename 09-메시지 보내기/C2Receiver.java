package com.example.yangjiwon.city0817;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class C2Receiver extends BroadcastReceiver {
    public C2Receiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int result = getResultCode();
        switch(result){
            case Activity.RESULT_OK:
                Toast.makeText(context, "Receive : Success", Toast.LENGTH_SHORT).show();
                break;
            case Activity.RESULT_CANCELED:
                Toast.makeText(context, "Receive : Fail", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}