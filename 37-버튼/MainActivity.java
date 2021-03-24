package com.yangjiwon.example.city0524;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button bt1;
    private Button bt2;
    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button)findViewById(R.id.button);
        bt2 = (Button)findViewById(R.id.button2);
        bt3 = (Button)findViewById(R.id.button3);
    }

    public void Clickbt(View view){
        int id = view.getId();
        switch(id){
            case R.id.button:
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this, "Citizen", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
            Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            break;
        }
    }
}