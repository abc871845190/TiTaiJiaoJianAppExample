package com.example.titaijiaozhengapp.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.ui.adapter.SuggestPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.xuexiang.xui.widget.actionbar.TitleBar;

import java.util.ArrayList;
import java.util.List;

public class SuggestFrameLayout extends Fragment {

    //    在此fragment添加viewPager+tablayout+fragment，分页展示日程和视频。
    private View mView;
    private TitleBar mTitleBar;
    private DrawerLayout mDrawerLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_suggest, container, false);

        initView();
        initListener();

        return mView;
    }

    private void initView() {
        mTitleBar = mView.findViewById(R.id.suggset_titlebar);
        mDrawerLayout = getActivity().findViewById(R.id.main_drawer);

        //搞viewpager和tablayout适配
        ViewPager viewPager = mView.findViewById(R.id.suggest_viewPager);
        List<String> tabtitles = new ArrayList<>();
        tabtitles.add("康复方案");
        tabtitles.add("视频");

        viewPager.setAdapter(new SuggestPagerAdapter(getChildFragmentManager(), tabtitles));
        //view和tab绑定
        TabLayout tabLayout = mView.findViewById(R.id.suggest_tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initListener() {
        //titlebar左上角监听
        mTitleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //drawer向右弹出
                mDrawerLayout.openDrawer(Gravity.LEFT, true);
            }
        });
    }
}
