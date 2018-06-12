package com.example.feibinbin.testdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Bind(R.id.bottom_navigation_bar_container)
    BottomNavigationBar bottom;
    @Bind(R.id.fragment_container)
    FrameLayout fragment_container;


    private List<Fragment> fragmentList = new ArrayList<>();
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private DFragment dFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addFragments();
        initBottomNavBar();
    }

    private void addFragments() {

        aFragment = AFragment.getInstance();
        bFragment = BFragment.getInstance();
        cFragment = CFragment.getInstance();
        dFragment = DFragment.getInstance();

        fragmentList.add(aFragment);
        fragmentList.add(bFragment);
        fragmentList.add(cFragment);
        fragmentList.add(dFragment);

    }


    private void initBottomNavBar() {

        bottom.setAutoHideEnabled(true);//自动隐藏
        bottom.setMode(BottomNavigationBar.MODE_FIXED);
        bottom.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottom.setBarBackgroundColor(R.color.white); //背景颜色
        bottom.setInActiveColor(R.color.title_color); //未选中时的颜色
        bottom.setActiveColor(R.color.mediumblue);//选中时的颜色

        BottomNavigationItem AItem = new BottomNavigationItem(R.mipmap.ic_launcher, "A");
        BottomNavigationItem BItem = new BottomNavigationItem(R.mipmap.ic_launcher, "B");
        BottomNavigationItem CItem = new BottomNavigationItem(R.mipmap.ic_launcher, "C");
        BottomNavigationItem DItem = new BottomNavigationItem(R.mipmap.ic_launcher, "D");

        bottom.addItem(AItem).addItem(BItem).addItem(CItem).addItem(DItem);
        bottom.setFirstSelectedPosition(0);
        bottom.initialise();
        bottom.setTabSelectedListener(this);
        setDefaultFrag();
    }

    @Override
    public void onTabSelected(int position) {

        hideAllFrag();
        switch (position) {
            case 0:
                if (aFragment == null) {
                    aFragment = AFragment.getInstance();
                }
                addFrag(aFragment);
                getSupportFragmentManager().beginTransaction().show(aFragment).commit();
                break;
            case 1:
                if (bFragment == null) {
                    bFragment = BFragment.getInstance();
                }
                addFrag(bFragment);
                getSupportFragmentManager().beginTransaction().show(bFragment).commit();
                break;
            case 2:
                if (cFragment == null) {
                    cFragment = CFragment.getInstance();
                }
                addFrag(cFragment);
                getSupportFragmentManager().beginTransaction().show(cFragment).commit();

                break;
            case 3:
                if (dFragment == null) {
                    dFragment = DFragment.getInstance();
                }
                addFrag(dFragment);
                getSupportFragmentManager().beginTransaction().show(dFragment).commit();

                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragmentList != null) {
            if (position < fragmentList.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragmentList.get(position);
                ft.hide(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }


    private void setDefaultFrag() {
        if (aFragment == null) {
            aFragment = AFragment.getInstance();
        }
        addFrag(aFragment);
        getSupportFragmentManager().beginTransaction().show(aFragment).commit();

    }

    private void addFrag(Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (frag != null && !frag.isAdded()) {
            ft.add(R.id.fragment_container, frag);
        }
        ft.commit();
    }

    private void hideAllFrag() {
        hideFrag(aFragment);
        hideFrag(bFragment);
        hideFrag(cFragment);
        hideFrag(dFragment);
    }

    private void hideFrag(Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (frag != null && frag.isAdded()) {
            ft.hide(frag);
        }
        ft.commit();
    }
}
