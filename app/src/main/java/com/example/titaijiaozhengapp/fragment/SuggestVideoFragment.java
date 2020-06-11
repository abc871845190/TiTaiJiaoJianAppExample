package com.example.titaijiaozhengapp.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videocontroller.component.CompleteView;
import com.dueeeke.videocontroller.component.ErrorView;
import com.dueeeke.videocontroller.component.GestureView;
import com.dueeeke.videocontroller.component.TitleView;
import com.dueeeke.videocontroller.component.VodControlView;
import com.dueeeke.videoplayer.player.VideoView;
import com.example.titaijiaozhengapp.R;
import com.example.titaijiaozhengapp.Utils.DataUtils;
import com.example.titaijiaozhengapp.Utils.Utils;
import com.example.titaijiaozhengapp.Utils.logUtils;
import com.example.titaijiaozhengapp.model.VideoBean;
import com.example.titaijiaozhengapp.ui.adapter.SuggestVideoRecylerViewAdapter;
import com.example.titaijiaozhengapp.ui.adapter.listener.RecylerViewListener;

import java.util.ArrayList;
import java.util.List;

public class SuggestVideoFragment extends androidx.fragment.app.Fragment implements RecylerViewListener {

    private List<VideoBean> mVideoBeanList = new ArrayList<>();
    private View mView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private SuggestVideoRecylerViewAdapter mViewAdapter;

    /**
     * 当前播放列表位置
     */
    private int mNowPosition = -1;

    /**
     * 记录上一次播放列表位置
     */
    private int mLastPosition = mNowPosition;
    private VideoView mVideoView;
    private StandardVideoController mStandardVideoController;
    private ErrorView mErrorView;
    private CompleteView mCompleteView;
    private TitleView mTitleView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_suggest_video, container, false);
        initView();
        return mView;
    }

    /**
     *
     */
    private void initVideoData() {
        logUtils.i(this,"is initVideoData");
        //初始化播放器
        mVideoView = new VideoView(mView.getContext());
        mVideoView.setOnStateChangeListener(new VideoView.SimpleOnStateChangeListener() {
            @Override
            public void onPlayerStateChanged(int playerState) {
                //监听VideoViewManager释放，重置状态
                if (playerState == VideoView.STATE_IDLE) {
                    Utils.removeViewFormParent(mVideoView);
                    mLastPosition = mNowPosition;
                    mNowPosition = -1;
                }
                ;
            }
        });

        mStandardVideoController = new StandardVideoController(getActivity());
        //添加加载错误view
        mErrorView = new ErrorView(getActivity());
        mStandardVideoController.addControlComponent(mErrorView);
        //添加播放完成view
        mCompleteView = new CompleteView(getActivity());
        mStandardVideoController.addControlComponent(mCompleteView);
        //添加播放器标题view
        mTitleView = new TitleView(getActivity());
        mStandardVideoController.addControlComponent(mTitleView);
        //添加播放器底部控制器view
        mStandardVideoController.addControlComponent(new VodControlView(getActivity()));
        //添加播放器手势控制view
        mStandardVideoController.addControlComponent(new GestureView(getActivity()));
        //设置播放器旋转
        mStandardVideoController.setEnableOrientation(true);
        //播放器绑定控制器
        mVideoView.setVideoController(mStandardVideoController);
    }

    private void initView() {
        initVideoData();
        logUtils.i(this,"is initView");
        mRecyclerView = mView.findViewById(R.id.suggest_video_RecylerView);
        mLinearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        //初始化adapter
        mViewAdapter = new SuggestVideoRecylerViewAdapter(mVideoBeanList);
        mViewAdapter.setOnItemClickListener(this);

        if (mLinearLayoutManager==null){
            logUtils.i(this,"manager is null");
        }else if (mViewAdapter==null){
            logUtils.i(this,"adapter is null");
        }
        //绑定adapter
        mRecyclerView.setAdapter(mViewAdapter);
        mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            /**
             * 当添加子View时回调
             * @param view
             */
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {

            }

            /**
             * 当移除子View时回调
             * @param view
             */
            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {
                FrameLayout frameLayout = view.findViewById(R.id.player_container);
                View v = frameLayout.getChildAt(0);
                if (v != null && v == mVideoView && mVideoView.isFullScreen()) {
                    releaseVideoView();
                }
            }
        });


    }

    private void initData() {
        List<VideoBean> list = DataUtils.getVideoList();
        mVideoBeanList.addAll(list);
        mViewAdapter.notifyDataSetChanged();
    }

    /**
     * fragment活跃之前的方法，生命周期
     */
    @Override
    public void onResume() {
        super.onResume();
        logUtils.i(this,"is onResume");
        initData();
        if (mLastPosition == -1) {
            return;
        }
        //恢复上一次播放视频的列表位置
        startPlay(mLastPosition);
    }

    /**
     * fragment关闭调用的方法。生命周期
     */
    @Override
    public void onPause() {
        super.onPause();
        releaseVideoView();
    }

    /**
     * prepareView被点击
     *
     * @param position
     */
    @Override
    public void onItemClick(int position) {
        logUtils.i(this,"item is onclick");
        startPlay(position);
    }

    /**
     * 开始播放
     *
     * @param position 列表位置
     */
    private void startPlay(int position) {
        if (mNowPosition == position) {
            return;
        }
        if (mNowPosition != -1) {
            releaseVideoView();
        }

        VideoBean videoBean = mVideoBeanList.get(position);
        //边播边存
//        String proxyUrl = ProxyVideoCacheManager.getProxy(getActivity()).getProxyUrl(videoBean.getUrl());
//        mVideoView.setUrl(proxyUrl);
        mVideoView.setUrl(videoBean.getUrl());
        mTitleView.setTitle(videoBean.getTitle());
        View itemView = mLinearLayoutManager.findViewByPosition(position);
        if (itemView == null) {
            return;
        }

        SuggestVideoRecylerViewAdapter.VideoHolder videoHolder = (SuggestVideoRecylerViewAdapter.VideoHolder) itemView.getTag();

        //把列表中预置的PrepareView添加到控制器中，注意isPrivate此处只能为true。
        mStandardVideoController.addControlComponent(videoHolder.mPrepareView, true);

        Utils.removeViewFormParent(mVideoView);
        //item容器添加VideoView
        videoHolder.mFrameLayout.addView(mVideoView, 0);

        mVideoView.start();
        mNowPosition = position;

    }

    /**
     * 释放资源
     */
    private void releaseVideoView() {
        mVideoView.release();
        if (mVideoView.isFullScreen()) {
            mVideoView.stopFullScreen();
        }

        if (getActivity().getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        mNowPosition = -1;
    }
}
