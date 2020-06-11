package com.example.titaijiaozhengapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.titaijiaozhengapp.fragment.SuggestScheduleFragment;
import com.example.titaijiaozhengapp.fragment.SuggestVideoFragment;

import java.util.List;

public class SuggestPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mStringList;
    //page少使用这个存fragment,参照例子使用
    private SparseArrayCompat<Fragment> mFragments = new SparseArrayCompat<>();

    public SuggestPagerAdapter(@NonNull FragmentManager fm, List<String> stringList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mStringList = stringList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mFragments.get(position);

        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new SuggestScheduleFragment();
                    break;
                case 1:
                    fragment = new SuggestVideoFragment();
                    break;
            }
            mFragments.put(position,fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mStringList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStringList.get(position);
    }
}
