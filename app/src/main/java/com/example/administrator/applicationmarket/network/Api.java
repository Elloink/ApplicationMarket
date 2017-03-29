package com.example.administrator.applicationmarket.network;

import com.example.administrator.applicationmarket.bean.CategoryBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/3/26.
 */

public interface Api {

    /**
     * 泛型T你想要解析后数据结构
     */
    @GET("hot")
    Call<List<String>> listHot();

    /**
     * 定义需要解析的数据结构
     * get参数是url最后的参数值（recommend）
     * http://localhost:8080/GooglePlayServer/recommend
     */
    @GET("recommend")
    Call<List<String>> listCommend();

    @GET("category")
    Call<List<CategoryBean>> listCategory();
}
