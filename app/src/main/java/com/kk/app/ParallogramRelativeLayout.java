package com.kk.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/2 0002.
 */
public class ParallogramRelativeLayout extends TextView {


    Paint mInnerPaint;

    public ParallogramRelativeLayout(Context context) {
        super(context);
        init();
    }

    public ParallogramRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ParallogramRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        mInnerPaint = new Paint();
        mInnerPaint.setAntiAlias(true);
        mInnerPaint.setColor(Color.WHITE);
        mInnerPaint.setStyle(Paint.Style.FILL);
        mInnerPaint.setStrokeJoin(Paint.Join.ROUND);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth()-30, getHeight());
        path.lineTo(0, getHeight());
        canvas.drawPath(path, mInnerPaint);
    }

}