package com.example.titaijiaozhengapp.Utils;

import com.example.titaijiaozhengapp.model.VideoBean;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    /*
     *  CTV1高清：http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8
     *  CCTV5高清：http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8
     * */
    //模拟数据集采用网络url加载形式
    public static List<VideoBean> getVideoList() {
        List<VideoBean> list = new ArrayList<>();
        list.add(new VideoBean("预告片1",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4"));

        list.add(new VideoBean("预告片2",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://vfx.mtime.cn/Video/2019/03/21/mp4/190321153853126488.mp4"));

        list.add(new VideoBean("预告片3",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://vfx.mtime.cn/Video/2019/03/19/mp4/190319222227698228.mp4"));

        list.add(new VideoBean("预告片4",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://vfx.mtime.cn/Video/2019/03/19/mp4/190319212559089721.mp4"));

        list.add(new VideoBean("预告片5",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://vfx.mtime.cn/Video/2019/03/18/mp4/190318231014076505.mp4"));

        list.add(new VideoBean("预告片6",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://vfx.mtime.cn/Video/2019/03/18/mp4/190318214226685784.mp4"));

        return list;
    }
}
