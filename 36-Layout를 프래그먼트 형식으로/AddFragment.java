package com.example.yangjiwon.city0912;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class AddFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        MainActivity.et = (EditText)view.findViewById(R.id.editText);
        MainActivity.bt = (Button)view.findViewById(R.id.button);
        return view;
    }

}