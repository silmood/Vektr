package com.silmood.vektr;


import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShapeTransformationFragment extends PagerFragment{


    FloatingActionButton mPlayButton;

    public ShapeTransformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_shape_transformation, container, false);

        mPlayButton = (FloatingActionButton) root.findViewById(R.id.button_play);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayButton.setSelected(!mPlayButton.isSelected());
                mPlayButton.setImageResource(mPlayButton.isSelected() ? R.drawable.animated_play_arrow : R.drawable.animated_stop);
                Drawable drawable = mPlayButton.getDrawable();
                if (drawable instanceof Animatable)
                    ((Animatable)drawable).start();
            }
        });

        return root;
    }

    @Override
    public int getTitleRes() {
        return R.string.title_transformation;
    }
}
