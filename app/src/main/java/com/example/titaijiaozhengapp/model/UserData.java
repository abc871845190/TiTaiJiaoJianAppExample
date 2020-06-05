package com.example.titaijiaozhengapp.model;

public class UserData {
    //data属性title标题
    private String userDataTitle;
    //data属性value数值
    private int userDataValue;
    //以后再说

    public UserData(String userDataTitle,int userDataValue){
        this.userDataTitle = userDataTitle;
        this.userDataValue = userDataValue;
    }

    public String getUserDataTitle() {
        return userDataTitle;
    }

    public int getUserDataValue() {
        return userDataValue;
    }

    public void setUserDataTitle(String userDataTitle) {
        this.userDataTitle = userDataTitle;
    }

    public void setUserDataValue(int userDataValue) {
        this.userDataValue = userDataValue;
    }
}
