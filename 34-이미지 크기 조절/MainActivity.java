package com.yangjiwon.example.city0521;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity {
    private ImageView imageView;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        imageView=(ImageView)findViewById(R.id.imageView);
        final String[] sizes = {"100x100", "200x200", "300x300"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.citizen00);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String name = sizes[position];
                Bitmap bitmap2 = null;
                switch(name){
                    case "100x100":
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
                        break;
                    case "200x200":
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, 200, 200, true);
                        break;
                    case "300x300":
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
                        break;
                }
                imageView.setImageBitmap(bitmap2);
            }
            @Override
        public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}
