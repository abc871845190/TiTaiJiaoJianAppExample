package com.example.titaijiaozhengapp.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.titaijiaozhengapp.R;
import com.xuexiang.xui.widget.actionbar.TitleBar;

public class HomeFrameLayout extends Fragment {

    private View mView;
    private TextView mTextView;
    private TitleBar mTitleBar;
    private DrawerLayout mDrawerLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        initListener();
        return mView;
    }

    private void initView() {
        mTextView = mView.findViewById(R.id.home_button);
        mTitleBar = mView.findViewById(R.id.home_titlebar);
        mDrawerLayout = getActivity().findViewById(R.id.main_drawer);
    }

    private void initListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mView.getContext(), "anim is onclick", Toast.LENGTH_SHORT).show();
            }
        });

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
