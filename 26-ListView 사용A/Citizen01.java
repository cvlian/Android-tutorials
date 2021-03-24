package com.example.yangjiwon.city0506;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class Citizen01 extends ListActivity {
    private ArrayList<String> strs;
    private ArrayAdapter<String> adapter;
    private EditText edtxt;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen01);
        edtxt = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        strs = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs);
        setListAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strs.add(0, edtxt.getText().toString());
                adapter.notifyDataSetChanged();
                edtxt.setText(" ");
            }
        });
    }
}