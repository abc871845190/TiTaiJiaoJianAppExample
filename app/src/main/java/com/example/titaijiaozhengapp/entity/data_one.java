package com.example.titaijiaozhengapp.entity;

public class data_one {
    //持续时间
    private String duration;
    //脊柱
    private int spine;
    //脚步压力
    private int footPress;
    //步态
    private String typeofFoot;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getSpine() {
        return spine;
    }

    public void setSpine(int spine) {
        this.spine = spine;
    }

    public int getFootPress() {
        return footPress;
    }

    public void setFootPress(int footPress) {
        this.footPress = footPress;
    }

    public String getTypeofFoot() {
        return typeofFoot;
    }

    public void setTypeofFoot(String typeofFoot) {
        this.typeofFoot = typeofFoot;
    }
}
