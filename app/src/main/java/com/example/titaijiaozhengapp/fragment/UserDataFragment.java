package com.example.titaijiaozhengapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.model.UserData;
import com.example.titaijiaozhengapp.ui.adapter.UserDataListFragmentAdapter;
import com.xuexiang.xui.widget.actionbar.TitleBar;

import java.util.ArrayList;
import java.util.List;

public class UserDataFragment extends Fragment {

    private View mView;
    private RecyclerView mRecyclerView;
    private TitleBar mTitleBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.user_data_fragment,container,false);

        initView();
        initListener();
        return mView;
    }

    private void initView() {
        //给recylerview设置适配器，模拟数据集
        mRecyclerView = mView.findViewById(R.id.user_data_list);

        List<UserData> dataList = new ArrayList<>();
        UserData userData = new UserData("身高",1);
        dataList.add(userData);
        UserData userData1 = new UserData("体重",2);
        dataList.add(userData1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        UserDataListFragmentAdapter userDataListFragmentAdapter = new UserDataListFragmentAdapter(dataList);
        mRecyclerView.setAdapter(userDataListFragmentAdapter);

        mTitleBar = mView.findViewById(R.id.user_data_titlebar);
    }

    private void initListener() {
        mTitleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }
}
