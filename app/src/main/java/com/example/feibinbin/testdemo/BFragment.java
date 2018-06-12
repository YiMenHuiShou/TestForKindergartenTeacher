package com.example.feibinbin.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author feibinbin
 * @date 2018/6/12 19:46
 * @describle TODO
 */

public class BFragment extends Fragment {

    public static BFragment getInstance() {
        BFragment bFragment = new BFragment();
        return bFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
