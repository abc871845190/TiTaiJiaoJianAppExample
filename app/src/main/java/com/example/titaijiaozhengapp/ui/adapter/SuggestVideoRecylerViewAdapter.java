package com.example.titaijiaozhengapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dueeeke.videocontroller.component.PrepareView;
import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.Utils.logUtils;
import com.example.titaijiaozhengapp.model.VideoBean;
import com.example.titaijiaozhengapp.ui.adapter.listener.RecylerViewListener;

import java.util.List;

public class SuggestVideoRecylerViewAdapter extends RecyclerView.Adapter<SuggestVideoRecylerViewAdapter.VideoHolder> {

    public List<VideoBean> videos;
    private RecylerViewListener mRecyclerListener;

    public SuggestVideoRecylerViewAdapter(List<VideoBean> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public SuggestVideoRecylerViewAdapter.VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_suggest_video_item, parent, false);
        logUtils.i(this,"is onCreateViewHolder");
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestVideoRecylerViewAdapter.VideoHolder holder, int position) {
        VideoBean videoBean = videos.get(position);
        //使用glide加载视频缩略图 图已经有
        Glide.with(holder.mPrepareImg.getContext())
                .load(videoBean.getImg())
                .placeholder(R.color.darker_gray)
                .into(holder.mPrepareImg);
        holder.mPosition = position;
        logUtils.i(this,"is onBindViewHolder");
        logUtils.i(this,""+position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mPrepareImg;
        public PrepareView mPrepareView;
        public int mPosition;
        public TextView mTitle;
        public FrameLayout mFrameLayout;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            logUtils.i(this,"is VideoHolder");
            mFrameLayout = itemView.findViewById(R.id.player_container);
            mPrepareView = itemView.findViewById(R.id.prepare_view);
            mTitle = itemView.findViewById(R.id.tv_title);
            mPrepareImg = mPrepareView.findViewById(R.id.thumb);

            if (mRecyclerListener != null) {
                mFrameLayout.setOnClickListener(this);
            }
            //通过tag将ViewHolder和itemView绑定
            itemView.setTag(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.player_container) {
                if (mRecyclerListener != null) {
                    mRecyclerListener.onItemClick(mPosition);
                }
            }
        }
    }

    //接口回调，在fragment_suggest里面调用方法拿数据
    public void setOnItemClickListener(RecylerViewListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    //添加数据，增加视频item
    public void addData(List<VideoBean> beanList) {

    }

}
