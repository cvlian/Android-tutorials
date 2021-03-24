package com.example.yangjiwon.city0816;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class C1Fragment extends DialogFragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public static C1Fragment newInstance(String param1) {
        C1Fragment fragment = new C1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public C1Fragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        mParam1 = getArguments().getString(ARG_PARAM1);
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(mParam1)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        C1Fragment.this.getDialog().cancel();
                    }
                }).create();
    }
}