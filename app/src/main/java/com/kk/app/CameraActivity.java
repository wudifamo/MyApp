package com.kk.app;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.linj.camera.view.CameraContainer;
import com.linj.camera.view.CameraView;

public class CameraActivity extends Activity {
    private int width, height;
    private ImageView imgIv, lightIv, peopleIv;
    private ValueAnimator valueAnimator;
    private CameraContainer mContainer;
    private RelativeLayout camera_mainrl;
    private boolean inited=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.camera_main);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = (int) (wm.getDefaultDisplay().getHeight() * 3 / 2f);
        imgIv = (ImageView) findViewById(R.id.camera_ufo);
        lightIv = (ImageView) findViewById(R.id.camera_light);
        peopleIv = (ImageView) findViewById(R.id.camera_people);
        camera_mainrl = (RelativeLayout) findViewById(R.id.camera_mainrl);
        camera_mainrl.getBackground().setAlpha(40);
        mContainer = (CameraContainer) findViewById(R.id.container);

        valueAnimator = ValueAnimator.ofObject(new BezierEvaluator(), new PointF(0, 0), new PointF((width / 2 - 55), 100));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                //  Log.d("point:", String.valueOf(pointF.x) + " , " + String.valueOf(pointF.y));
                if (pointF.x > 200) {
                    imgIv.setVisibility(View.VISIBLE);
                }
                imgIv.setX(pointF.x);
                imgIv.setY(pointF.y);
            }
        });
        valueAnimator.setTarget(imgIv);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imgIv, pvhY, pvhZ);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(objectAnimator).with(valueAnimator);
        animSet.setDuration(3000);
        animSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                lightIv.setVisibility(View.VISIBLE);
                blinkImage();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animSet.start();

    }


    class BezierEvaluator implements TypeEvaluator<PointF> {

        @Override
        public PointF evaluate(float fraction, PointF startValue,
                               PointF endValue) {
            final float t = fraction;
            float oneMinusT = 1.0f - t;
            PointF point = new PointF();

            PointF point0 = (PointF) startValue;

            PointF point1 = new PointF();
            point1.set(width * 2, 0);

            PointF point2 = new PointF();
            point2.set(0, height / 2);

            PointF point3 = (PointF) endValue;

            point.x = oneMinusT * oneMinusT * oneMinusT * (point0.x)
                    + 3 * oneMinusT * oneMinusT * t * (point1.x)
                    + 3 * oneMinusT * t * t * (point2.x)
                    + t * t * t * (point3.x);

            point.y = oneMinusT * oneMinusT * oneMinusT * (point0.y)
                    + 3 * oneMinusT * oneMinusT * t * (point1.y)
                    + 3 * oneMinusT * t * t * (point2.y)
                    + t * t * t * (point3.y);
            return point;
        }
    }

    private void blinkImage() {
        final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        animation.setDuration(100); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(5); // Repeat animation infinitely
        animation.setRepeatMode(Animation.REVERSE); //
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mContainer.setVisibility(View.VISIBLE);
                sView();
                inited=true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lightIv.setAnimation(animation);
        animation.start();
        lightIv.startAnimation(animation);
    }

    private void sView() {
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(0, -200);
        valueAnimator0.setTarget(peopleIv);
        valueAnimator0.setDuration(500);
        valueAnimator0.setInterpolator(new LinearInterpolator());
        valueAnimator0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                peopleIv.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator0.start();
    }

    @Override
    public void onBackPressed() {
        if (inited) {
            finish();
        }
    }
}
