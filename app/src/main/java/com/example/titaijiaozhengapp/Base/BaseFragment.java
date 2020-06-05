package com.example.titaijiaozhengapp.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder mUnbinder;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = loadRootView(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, mView);

        initView(mView);
        initListener();
        return loadRootView(inflater, container, savedInstanceState);
    }

    //加载
    protected void initView(View view) {
    }

    ;

    //监听
    protected void initListener() {
    }

    ;

    protected View loadRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int resId = getRootViewResId();
        return inflater.inflate(resId, container, false);
    }

    protected abstract int getRootViewResId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    //    //加载头顶的title

}
