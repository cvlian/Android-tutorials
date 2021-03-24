package com.yangjiwon.example.city0518;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(new CustomDrawableView(getApplicationContext()));
    }

    public class CustomDrawableView extends View {
        private ShapeDrawable mDrawable1;
        private ShapeDrawable mDrawable2;
        private ShapeDrawable mDrawable3;

        public CustomDrawableView(Context context){
            super(context);
            int x = 100;
            int y = 500;
            int width = 300;
            int height = 300;
            mDrawable1 = new ShapeDrawable(new OvalShape());
            mDrawable1.getPaint().setColor(0xff74AC23);
            mDrawable1.setBounds(x, y, x + width, y + height);
            x=10;
            y=120;
            mDrawable2 = new ShapeDrawable(new ArcShape(10, 280));
            mDrawable2.getPaint().setColor(0xff74AC23);
            mDrawable2.setBounds(x, y, x + width, y + height);
            x=350;
            mDrawable3 = new ShapeDrawable(new RectShape());
            mDrawable3.getPaint().setColor(0xff74AC23);
            mDrawable3.setBounds(x, y, x+width, y+height);
        }
        protected void onDraw(Canvas canvas){
            Paint textPaint = new Paint();
            textPaint.setColor(0xff893456);
            textPaint.setTextSize(60);
            canvas.drawText("The World of 2D", 10, 80, textPaint);
            mDrawable1.draw(canvas);
            mDrawable2.draw(canvas);
            mDrawable3.draw(canvas);
        }
    }
}
