package com.example.titaijiaozhengapp.model;

public class VideoBean {
    //视频的名字
    private String title;
    //视频的地址，网络
    private String url;
    //视频的缩略图
    private String img;

    public VideoBean(String title,String url,String img){
        this.title = title;
        this.img = img;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
