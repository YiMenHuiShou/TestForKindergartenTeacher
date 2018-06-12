package com.example.feibinbin.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author feibinbin
 * @date 2018/6/12 20:55
 * @describle TODO
 */

public class A2Fragment extends Fragment {

    @Bind(R.id.text)
    TextView textView;

    private String textTab = "";

    public static A2Fragment getInstance() {
        A2Fragment a2Fragment = new A2Fragment();
        return a2Fragment;
    }

    public void setT(String textTab){
        this.textTab = textTab;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a2, container, false);
        ButterKnife.bind(this, view);
        textView.setText(textTab);
        return view;
    }
}
