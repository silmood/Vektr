package com.silmood.vektr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShapeTransformationFragment extends PagerFragment{

    public ShapeTransformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_shape_transformation, container, false);
        return root;
    }

    @Override
    public int getTitleRes() {
        return R.string.title_transformation;
    }
}
