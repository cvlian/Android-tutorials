package com.yangjiwon.example.city0523;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yangjiwon on 2016-05-29.
 */
public class CitizenAdapter extends ArrayAdapter<Citizen> {
    private ArrayList<Citizen> citizens;
    private Context context;
    private int resId;
    private ImageView image;


    public CitizenAdapter(Context context, int textViewResourceId, ArrayList<Citizen> objects){
        super(context, textViewResourceId, objects);
        this.context = context;
        resId = textViewResourceId;
        this.citizens = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(resId, null);
        }
        Citizen c = citizens.get(position);
        if(c != null) {
            TextView t = (TextView) convertView.findViewById(R.id.textView);
            ImageView i = (ImageView) convertView.findViewById(R.id.imageView);
            if (t != null) {
                t.setText(c.getName());
                    i.setImageResource(R.drawable.citizen00);
            }
        }
    return convertView;
}
}