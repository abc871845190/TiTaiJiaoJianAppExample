package com.example.titaijiaozhengapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.model.UserData;

import java.util.List;

public class UserDataListFragmentAdapter extends RecyclerView.Adapter<UserDataListFragmentAdapter.InnerHolder> {
    //初设的数据
    private List<UserData> mUserData;

    public UserDataListFragmentAdapter(List<UserData> data){
        this.mUserData = data;
    }

    /**
     * 这个类啊，是用来创建条目的View
     *
     * @param parent
     * @param viewType
     * @return 需要返回一个内部的View类
     */
    @NonNull
    @Override
    public UserDataListFragmentAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_data_list_item, parent, false);
        return new InnerHolder(view);
    }

    /**
     * 用于绑定内部holder，用来设置数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull UserDataListFragmentAdapter.InnerHolder holder, int position) {
        //绑定数据到item上
        holder.setData(mUserData.get(position));
    }

    @Override
    public int getItemCount() {
        //获得size
        if (mUserData != null) {
            return mUserData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private final TextView mDataTitle;
        private final TextView mDataValue;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mDataTitle = itemView.findViewById(R.id.user_data_list_item_title);
            mDataValue = itemView.findViewById(R.id.user_data_list_item_value);
        }

        /**
         * 设置数据
         *
         * @param data
         */
        public void setData(UserData data) {
            mDataTitle.setText(data.getUserDataTitle());
            mDataValue.setText(data.getUserDataValue()+"");
        }
    }
}
