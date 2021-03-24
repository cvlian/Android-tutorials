package com.yangjiwon.example.city0523;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Yangjiwon on 2016-05-29.
 */
public class AddFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment2, container, false);
        MainActivity.name = (EditText)view.findViewById(R.id.editText);
        MainActivity.save = (Button)view.findViewById(R.id.button);
        return view;
    }
}