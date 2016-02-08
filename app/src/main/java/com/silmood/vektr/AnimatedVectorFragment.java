package com.silmood.vektr;


import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimatedVectorFragment extends PagerFragment{

    ImageView mAnimatedAndroid;

    public AnimatedVectorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_animated_vector, container, false);

        mAnimatedAndroid = (ImageView) root.findViewById(R.id.animated_android);

        Drawable drawable = mAnimatedAndroid.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }

        return root;
    }

    @Override
    public int getTitleRes() {
        return R.string.title_animated_vector;
    }
}
