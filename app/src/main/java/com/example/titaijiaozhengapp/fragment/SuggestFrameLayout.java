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

import com.example.titaijiaozhengapp.R;
import com.xuexiang.xui.widget.actionbar.TitleBar;

public class SuggestFrameLayout extends Fragment {

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
