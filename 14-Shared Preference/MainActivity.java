package com.example.yangjiwon.city0829;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Map;

public class MainActivity extends Activity {

    private EditText text;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.editText);
        name = (TextView)findViewById(R.id.textView);
    }

    public void clear(View view){
        text.setHint("");
    }

    public void edit(View view){
        String str = text.getText().toString();
        name.setText("User Name : " + str);
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor =  pref.edit();
        String str = name.getText().toString();
        editor.putString("Saved_name", str);
        editor.commit();
    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        if(pref.contains("Saved_name")) name.setText(pref.getString("Saved_name", ""));
    }
}
