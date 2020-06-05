package com.example.titaijiaozhengapp.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.fragment.UserDataFragment;

public class UserDataActivity extends FragmentActivity {

    private UserDataFragment mUserDataFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data_layout);

        initView();

        initListener();
    }

    private void initView() {
        mUserDataFragment = new UserDataFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.user_data_framelayout,mUserDataFragment).commit();
    }

    private void initListener() {

    }
}
