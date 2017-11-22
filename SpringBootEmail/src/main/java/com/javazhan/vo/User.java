package com.javazhan.vo;

import java.util.UUID;

/**
 * Created by yando on 2017/11/22.
 */
public class User {
    private String userId = UUID.randomUUID().toString().replaceAll("-", ""); ;
    private String userEmail ;
    private String name ;
    private String userPass ;
    private String userRepass ;
    private int state = 0 ; // 0:表示未激活

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRepass() {
        return userRepass;
    }

    public void setUserRepass(String userRepass) {
        this.userRepass = userRepass;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
