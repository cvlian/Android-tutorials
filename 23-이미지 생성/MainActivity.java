package com.example.yangjiwon.city0906;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (RelativeLayout)findViewById(R.id.relativeLayout);
    }

    public void createImage(View view){
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.black); // drawable에 있는 파일 명
        image.setTranslationX(0);
        image.setTranslationY(0);
        layout.addView(image, 100, 100); 
    }
}