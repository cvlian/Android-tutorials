package com.example.yangjiwon.city0816;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class MainActivity extends Activity {

    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(receiver, filter);
    }

    void showDialog(String sms){
        DialogFragment newFragment = C1Fragment.newInstance(sms);
        newFragment.show(getFragmentManager(), "dialog");
    }

    class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Bundle bundle = intent.getExtras();
            String msg;
            String sender;
            if(bundle != null){
                Object rawData[] = (Object[])bundle.get("pdus");
                SmsMessage[] sms = new SmsMessage[rawData.length];
                for(int i=0; i<sms.length; i++){
                    sms[i] = SmsMessage.createFromPdu((byte[])rawData[i]);
                }
                for(int i=0; i<sms.length; i++){
                    msg = sms[i].getMessageBody();
                    sender = sms[i].getOriginatingAddress();
                    showDialog(msg+" from "+sender);
                }
            }
        }
    }
}