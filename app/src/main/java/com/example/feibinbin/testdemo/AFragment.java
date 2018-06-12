package com.example.feibinbin.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author feibinbin
 * @date 2018/6/12 19:46
 * @describle TODO
 */

public class AFragment extends Fragment {

    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.vp)
    ViewPager vp;

    AFragmentAdapter adapter;


    public static AFragment getInstance() {
        AFragment aFragment = new AFragment();
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("A1");
        tabList.add("A2");
        tabList.add("A3");
        tab.addTab(tab.newTab().setText("A1"));
        tab.addTab(tab.newTab().setText("A2"));
        tab.addTab(tab.newTab().setText("A3"));
        adapter = new AFragmentAdapter(getChildFragmentManager());
        adapter.setTabsList(tabList);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(adapter.getCount());
        tab.setupWithViewPager(vp);

    }
}
