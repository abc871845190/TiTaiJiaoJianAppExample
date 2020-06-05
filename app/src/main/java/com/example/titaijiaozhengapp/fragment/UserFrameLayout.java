package com.example.titaijiaozhengapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.ui.activity.UserDataActivity;
import com.xuexiang.xui.widget.actionbar.TitleBar;

public class UserFrameLayout extends Fragment {

    private View mView;
    private View mItemAccount;
    private TitleBar mTitleBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_user, container, false);

        initView();
        initListener();
        return mView;
    }

    private void initView() {
        mItemAccount = mView.findViewById(R.id.user_item_account_manager);
        mTitleBar = mView.findViewById(R.id.user_titlebar);
        mTitleBar.disableLeftView();
    }

    private void initListener() {
        mItemAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), UserDataActivity.class));
            }
        });
    }


}
