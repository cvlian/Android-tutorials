package com.example.yangjiwon.city0910;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yangjiwon on 2016-09-12.
 */
public class C1Adapter extends ArrayAdapter<Citizen> {
    private ArrayList<Citizen> citizens;
    private Context context;
    private int resId;

    public C1Adapter(Context context, int textViewResourceId, ArrayList<Citizen> objects){
        super(context, textViewResourceId, objects);
        this.context = context;
        resId = textViewResourceId;
        this.citizens = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=vi.inflate(resId, null);
        }
        Citizen c=citizens.get(position);

        if(c!=null){
            TextView t =(TextView)convertView.findViewById(R.id.textView);
            ImageView i= (ImageView)convertView.findViewById(R.id.imageView);
            i.setImageResource(R.drawable.img1);
            t.setText(c.getName());
        }
        return convertView;
    }
}