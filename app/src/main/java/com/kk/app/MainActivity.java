package com.kk.app;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private RelativeLayout first_rl, second_rl, third_rl, forth_rl;
    private int mCurrentPage = 0;
    private ArrayList<RelativeLayout> rls = new ArrayList<>();
    private Fragment0 fm0 = new Fragment0();
    private Fragment1 fm1 = new Fragment1();
    private Fragment2 fm2 = new Fragment2();
    private Fragment3 fm3 = new Fragment3();
    private ArrayList<Fragment> fms = new ArrayList<>();
    private ViewPager main_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        first_rl = (RelativeLayout) findViewById(R.id.first_rl);
        second_rl = (RelativeLayout) findViewById(R.id.second_rl);
        third_rl = (RelativeLayout) findViewById(R.id.third_rl);
        forth_rl = (RelativeLayout) findViewById(R.id.forth_rl);
        main_viewpager = (ViewPager) findViewById(R.id.main_viewpager);
        rls.add(first_rl);
        rls.add(second_rl);
        rls.add(third_rl);
        rls.add(forth_rl);
        fms.add(fm0);
        fms.add(fm1);
        fms.add(fm2);
        fms.add(fm3);
        main_viewpager.setAdapter(mAdapter);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        rotationView(first_rl, (ImageView) findViewById(R.id.first_img));
//        main_viewpager.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//
//        });
        main_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) first_rl
                        .getLayoutParams();

                Log.d("tag", String.valueOf(position) + ", " + String.valueOf(positionOffset));
            }

            @Override
            public void onPageSelected(int position) {
                selectedMenu(rls.get(position));
                mCurrentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void clickMenu(View view) {
        selectedMenu(view);
        main_viewpager.setCurrentItem(mCurrentPage);
    }

    private void selectedMenu(View view) {
        sView();
        ImageView imgView = null;
        switch (view.getId()) {
            case R.id.first_rl:
                imgView = (ImageView) findViewById(R.id.first_img);
                mCurrentPage = 0;
                break;
            case R.id.second_rl:
                imgView = (ImageView) findViewById(R.id.second_img);
                mCurrentPage = 1;
                break;
            case R.id.third_rl:
                imgView = (ImageView) findViewById(R.id.third_img);
                mCurrentPage = 2;
                break;
            case R.id.forth_rl:
                imgView = (ImageView) findViewById(R.id.forth_img);
                mCurrentPage = 3;
                break;
        }
        rotationView(view, imgView);
    }

    private void sView() {
        final RelativeLayout relativeLayout = rls.get(mCurrentPage);
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(150, 0);
        valueAnimator0.setTarget(relativeLayout);
        valueAnimator0.setDuration(1000);
        valueAnimator0.setInterpolator(new OvershootInterpolator());
        valueAnimator0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                relativeLayout.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator0.start();
    }

    private void rotationView(final View view, ImageView imgView) {

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 150);
        valueAnimator.setTarget(view);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new OvershootInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator.start();
        ObjectAnimator//
                .ofFloat(imgView, "rotationX", 0.0F, 360.0F)//
                .setDuration(1000)//
                .start();
    }

    FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public int getCount() {
            return fms.size();
        }

        @Override
        public Fragment getItem(int arg0) {
            return fms.get(arg0);
        }
    };

}
