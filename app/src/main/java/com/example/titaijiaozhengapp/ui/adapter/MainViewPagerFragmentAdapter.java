package com.example.titaijiaozhengapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;


/*
* 这个是主界面的viewpager的适配器
* */
public class MainViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public MainViewPagerFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
