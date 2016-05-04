package com.kk.app;

/**
 * Created by sun.aoyang on 16/5/4.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BezierCurveView extends View{

    private static final String TAG = "com.example.propertyanimsecdemo.BezierCurveView";

    private Paint paint;

    private Path path;

    public BezierCurveView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }

    public BezierCurveView(Context context){
        super(context);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(1);

        path = new Path();
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
      //  Log.v(TAG, "width = " + MeasureSpec.getSize(widthMeasureSpec) + "| height = " + MeasureSpec.getSize(heightMeasureSpec));
    }

    public void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        path.reset();
        path.moveTo(0, 0);
        path.cubicTo(getMeasuredWidth()*2, 0, 0, getMeasuredHeight()/2,getMeasuredWidth()/2, 100);
        canvas.drawPath(path, paint);
    }

}