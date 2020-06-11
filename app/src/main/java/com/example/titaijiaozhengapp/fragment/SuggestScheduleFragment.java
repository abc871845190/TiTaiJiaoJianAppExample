package com.example.titaijiaozhengapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.titaijiaozhengapp.R;

public class SuggestScheduleFragment extends androidx.fragment.app.Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_suggest_schedule, container,false);
        initView();
        initListener();
        return mView;
    }

    private void initView() {

    }

    private void initListener() {

    }

}
