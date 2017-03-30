package com.example.administrator.applicationmarket.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class HomeBean {
    private List<String> picture;
    /**
     * id : 1525489
     * name : 黑马程序员
     * packageName : com.itheima.www
     * iconUrl : app/com.itheima.www/icon.jpg
     * stars : 5
     * size : 91767
     * downloadUrl : app/com.itheima.www/com.itheima.www.apk
     * des : 产品介绍：google市场app测试。
     */

    private List<GameBean> list;

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public List<GameBean> getList() {
        return list;
    }

    public void setList(List<GameBean> list) {
        this.list = list;
    }

}
