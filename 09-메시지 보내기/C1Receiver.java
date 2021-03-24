package com.example.yangjiwon.city0817;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class C1Receiver extends BroadcastReceiver {
    public C1Receiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int result = getResultCode();
        switch (result){
            case Activity.RESULT_OK:
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                Toast.makeText(context, "Generic Failure", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_RADIO_OFF:
                Toast.makeText(context, "Radio Off", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_NULL_PDU:
                Toast.makeText(context, "Null Pdu", Toast.LENGTH_SHORT).show();
                break;
            case SmsManager.RESULT_ERROR_NO_SERVICE:
                Toast.makeText(context, "No Service", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}