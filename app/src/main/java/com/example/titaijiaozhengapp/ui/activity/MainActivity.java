package com.example.titaijiaozhengapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.fragment.DataFrameLayout;
import com.example.titaijiaozhengapp.fragment.HomeFrameLayout;
import com.example.titaijiaozhengapp.fragment.SuggestFrameLayout;
import com.example.titaijiaozhengapp.fragment.UserFrameLayout;
import com.example.titaijiaozhengapp.ui.adapter.MainViewPagerFragmentAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.xuexiang.xui.widget.progress.CircleProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {


    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView mBottomNavigationView;

    @BindView(R.id.main_layout_viewPager)
    public ViewPager mViewPager;

    @BindView(R.id.main_drawer)
    public DrawerLayout mDrawerLayout;

    @BindView(R.id.drawer_navigation)
    public NavigationView mNavigationView;

    private HomeFrameLayout mHomeFrameLayout;
    private DataFrameLayout mDataFrameLayout;
    private SuggestFrameLayout mSuggestFrameLayout;
    private UserFrameLayout mUserFrameLayout;
    private FragmentManager mFragmentManager;


    public CircleProgressView mDrawCircle;
    private int progess;
    private View mView;
    private List<Fragment> mFragmentList;
    private MainViewPagerFragmentAdapter mMainViewPagerFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListener();
        initView();
    }

    private void initView() {

        mHomeFrameLayout = new HomeFrameLayout();
        mDataFrameLayout = new DataFrameLayout();
        mSuggestFrameLayout = new SuggestFrameLayout();
        mUserFrameLayout = new UserFrameLayout();

        mFragmentList = new ArrayList<>();
        mFragmentList.add(mHomeFrameLayout);
        mFragmentList.add(mDataFrameLayout);
        mFragmentList.add(mSuggestFrameLayout);
        mFragmentList.add(mUserFrameLayout);

        mFragmentManager = getSupportFragmentManager();
        mMainViewPagerFragmentAdapter = new MainViewPagerFragmentAdapter(mFragmentManager,mFragmentList);
        mViewPager.setAdapter(mMainViewPagerFragmentAdapter);

    }

    private void initListener() {
        //导航栏监听
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    mViewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.navigation_data) {
                    mViewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.navigation_suggest) {
                    mViewPager.setCurrentItem(2);
                } else if (item.getItemId() == R.id.navigation_user) {
                    mViewPager.setCurrentItem(3);
                }
                return true;
            }
        });

        //ViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当滑到哪个页面，导航栏就会被选中
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //侧滑栏的监听
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.drawer_menu_data:
                        startActivity(new Intent(getApplicationContext(), UserDataActivity.class));
                    case R.id.drawer_menu_head:
                    case R.id.drawer_menu_setting:
                    case R.id.drawer_menu_about:
                }
                mDrawerLayout.closeDrawer(Gravity.LEFT,true);
                return false;
            }
        });
    }
}
