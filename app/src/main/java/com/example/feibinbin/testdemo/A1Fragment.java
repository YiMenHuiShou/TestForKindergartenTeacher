package com.example.feibinbin.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author feibinbin
 * @date 2018/6/12 20:13
 * @describle TODO
 */

public class A1Fragment extends Fragment {

    @Bind(R.id.rv)
    RecyclerView rv;

    MultipleItemQuickAdapter adapter;

    public static A1Fragment getInstance() {
        A1Fragment a1Fragment = new A1Fragment();
        return a1Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a1, container, false);
        ButterKnife.bind(this, view);
        initRV();
        return view;
    }

    private void initRV() {

        List<MultipleItem> data = new ArrayList<>();
        data.add(new MultipleItem(1));
        data.add(new MultipleItem(2));
        data.add(new MultipleItem(3));
        data.add(new MultipleItem(4));
        adapter = new MultipleItemQuickAdapter(data);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}
