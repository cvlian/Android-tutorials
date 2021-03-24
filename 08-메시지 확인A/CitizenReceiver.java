package com.example.yangjiwon.city0827;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class CitizenReceiver extends BroadcastReceiver {
    public CitizenReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String msg;
        String sender;
        if(bundle != null){
            Object rawData[] = (Object[])bundle.get("pdus");
            SmsMessage[] sms = new SmsMessage[rawData.length];
            for(int i=0; i<rawData.length; i++){
                sms[i] = SmsMessage.createFromPdu((byte[])rawData[i]);
            }
            for(int i=0; i<rawData.length; i++){
                msg = sms[i].getMessageBody();
                sender = sms[i].getOriginatingAddress();
                Toast.makeText(context, msg+" from "+sender, Toast.LENGTH_SHORT).show();
            }
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}