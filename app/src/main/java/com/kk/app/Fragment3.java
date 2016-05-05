package com.kk.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

public class Fragment3 extends Fragment {
    private View viewFragment;
    Context context;
    private FrameLayout frame3_image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewFragment = inflater.inflate(R.layout.fragment3, null);
        final FoldingCell fc = (FoldingCell) viewFragment.findViewById(R.id.folding_cell);
        final FoldingCell fc1 = (FoldingCell) viewFragment.findViewById(R.id.folding_cell1);
        final FoldingCell fc2 = (FoldingCell) viewFragment.findViewById(R.id.folding_cell2);
        frame3_image = (FrameLayout) viewFragment.findViewById(R.id.frame3_image);
        fc.initialize(1500, Color.WHITE, 4);
        fc2.initialize(1500, Color.WHITE, 7);
        // attach click listener to folding cell
        fc.setOnClickListener(new expendListener());
        fc1.setOnClickListener(new expendListener());
        fc2.setOnClickListener(new expendListener());
        frame3_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, CameraActivity.class));
            }
        });
        return viewFragment;
    }

    private class expendListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            FoldingCell foldingCell = (FoldingCell) v;
            foldingCell.toggle(false);

        }
    }


}
