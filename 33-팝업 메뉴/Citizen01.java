package com.citizen.city0519;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Citizen01 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen01);
    }

    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        print("What? You must not JEeSha!!");
                        return true;
                    case R.id.item2:
                        print("Hi Alan");
                        return true;
                    case R.id.item3:
                        print("Hi Tom");
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.inflate(R.menu.menu_citizen01);
        popup.show();
    }

    public void print(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}