package com.example.yangjiwon.city0813;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends Activity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        text = (EditText)findViewById(R.id.editText2);
        Intent intent = getIntent();
        text.setText(intent.getStringExtra("name"));
    }

   public void edit(View view){
       String name = text.getText().toString();
       if(!name.equals("")){
           Intent data = new Intent();
           data.putExtra("name", name);
           setResult(RESULT_OK, data);
           finish();
       }
   }
}