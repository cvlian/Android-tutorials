package com.yangjiwon.example.city0523;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Yangjiwon on 2016-05-29.
 */
public class ListFragment extends Fragment {
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View view = inflater.inflate(R.layout.fragment1, container, false);
    MainActivity.citizenList = (ListView)view.findViewById(R.id.listView);
    return view;
}
}