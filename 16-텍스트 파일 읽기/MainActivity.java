package com.example.yangjiwon.city0830;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends Activity {

    private FileInputStream fis;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);
    }

    public void read(View view){
        try{
            fis = openFileInput("test.txt");
            StringBuffer Sbuffer = new StringBuffer();
            byte[] buffer = new byte[40];
            while((fis.read(buffer, 0, 40))!=-1){
                String str = new String(buffer);
                Sbuffer.append(str);
                if(fis.available()<40){
                    Arrays.fill(buffer, 0, 40, (byte) ' ');
                }
                fis.close();
                text.setText(Sbuffer);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}