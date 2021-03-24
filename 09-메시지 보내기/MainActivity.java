package com.example.yangjiwon.city0817;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText content;
    private EditText phonenumber;
    private String msg;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = (EditText)findViewById(R.id.editText);
        phonenumber = (EditText)findViewById(R.id.editText2);
    }

    public void sendMsg(View view){
        msg = content.getText().toString();
        number = phonenumber.getText().toString();
        if(msg.length() <= 0){
            Toast.makeText(getApplicationContext(), "메세지 내용을 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        } else if(number.length() <= 0){
            Toast.makeText(getApplicationContext(), "번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        } else {
            PendingIntent Sendintent = PendingIntent.getBroadcast(this, 0 , new Intent("SENT"), 0);
            PendingIntent Deliveredintent = PendingIntent.getBroadcast(this, 0, new Intent("DELIVERED"), 0);
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(number, null, msg, Sendintent, Deliveredintent);
        }

    }
}