/*
 * Copyright © 2017 宋小雄. All rights reserved.
 */

package com.iuling.cmmvp.ui.activities;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.iuling.cmmvp.R;
import com.iuling.cmmvp.ui.fragments.CommonFragment;
import com.iuling.cmmvp.ui.fragments.HomeFragment;
import com.iuling.cmmvp.ui.fragments.WealFragment;
import com.iuling.mvp.base.XFragmentAdapter;
import com.iuling.mvp.mvp.XActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends XActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    List<Fragment> mFragments = new ArrayList<>();
    String[] mTitles = {"首页", "Android", "iOS","福利","休息视频","前端","拓展资源","App","瞎推荐"};

    XFragmentAdapter adapter;

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);

        mFragments.clear();
        for (String type : mTitles) {
            if ("首页".equals(type)){
                mFragments.add(HomeFragment.newInstance());
            }else if ("福利".equals(type)){
                mFragments.add(WealFragment.newInstance());
            }else{
                mFragments.add(CommonFragment.newInstance(type));
            }
        }

        if (adapter == null) {
            adapter = new XFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles);
        }
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(mTitles.length - 1);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }
}
