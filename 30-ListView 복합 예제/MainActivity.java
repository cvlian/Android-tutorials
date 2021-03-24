package com.example.yangjiwon.city0910;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText name;
    private Button create;
    private ListView citizenList;
    private ArrayList<Citizen> list;
    private C1Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editText);
        create = (Button)findViewById(R.id.button);
        citizenList = (ListView)findViewById(R.id.listView);
        list = new ArrayList<Citizen>();
        adapter=new C1Adapter(this, R.layout.layout, list);
        citizenList.setAdapter(adapter);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Citizen c = new Citizen();
                c.setName(name.getText().toString());
                list.add(0, c);
                adapter.notifyDataSetChanged();
                name.setText("");
            }
        });
    }
}