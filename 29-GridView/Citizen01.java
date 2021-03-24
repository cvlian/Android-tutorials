package com.example.yangjiwon.city0504;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Citizen01 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen01);
        GridView gv = (GridView) findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(this));
    }
}
    class ImageAdapter extends BaseAdapter{
        private Context mContext;
        public ImageAdapter(Context c){
            mContext = c;
        }
        @Override
        public int getCount(){
            return Idata.length;
        }
        @Override
        public Object getItem(int arg0){
            return null;
        }
        @Override
        public long getItemId(int arg0){
            return 0;
        }

        private Integer[]Idata = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};

        @Override
   public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView == null){
        imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
            else{
            imageView = (ImageView)convertView;
        }
            imageView.setImageResource(Idata[position]);
            return imageView;
        }
    }