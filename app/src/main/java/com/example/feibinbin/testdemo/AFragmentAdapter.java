package com.example.feibinbin.testdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feibinbin
 * @date 2018/6/12 20:12
 * @describle TODO
 */

public class AFragmentAdapter extends FragmentPagerAdapter {


    public AFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    List<String> tabsList = new ArrayList<>();


    public void setTabsList(List<String> tabs) {
        tabsList.clear();
        tabsList.addAll(tabs);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            A1Fragment a1Fragment = A1Fragment.getInstance();
            return a1Fragment;
        }else{
            A2Fragment a2Fragment = A2Fragment.getInstance();
            return a2Fragment;
        }

    }

    @Override
    public int getCount() {
        return tabsList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabsList.get(position);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if(position == 0){
            A1Fragment fragment = (A1Fragment) super.instantiateItem(container, position);
            return fragment;
        }else if (position == 1){
            A2Fragment fragment = (A2Fragment) super.instantiateItem(container, position);
            fragment.setT("A2");
            return fragment;
        }else {
            A2Fragment fragment = (A2Fragment) super.instantiateItem(container, position);
            fragment.setT("A3");
            return fragment;
        }

    }
}
