package com.yangjiwon.example.city0525;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button red;
    private Button green;
    private Button blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = (Button)findViewById(R.id.button);
        green =(Button)findViewById(R.id.button2);
        blue = (Button)findViewById(R.id.button3);
    }

    public void changeFragment(View view){
        int id = view.getId();
        Fragment fragment = null;
        switch(id){
            case R.id.button:
                fragment = new RedFragment();
                break;
            case R.id.button2:
                fragment = new GreenFragment();
                break;
            case R.id.button3:
                fragment = new BlueFragment();
                break;
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }
}