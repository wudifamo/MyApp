package com.kk.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Fragment1 extends Fragment {
    private View viewFragment;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragment1, null);
        LinearLayout frame0_mainrl = (LinearLayout) viewFragment.findViewById(R.id.frame1_mainll);
        frame0_mainrl.getBackground().setAlpha(76);



        return viewFragment;
    }


}
