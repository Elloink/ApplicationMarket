package com.example.administrator.applicationmarket.network;

import com.example.administrator.applicationmarket.bean.AppInfoBean;
import com.example.administrator.applicationmarket.bean.CategoryBean;
import com.example.administrator.applicationmarket.bean.GameBean;
import com.example.administrator.applicationmarket.bean.HomeBean;
import com.example.administrator.applicationmarket.bean.SubjectBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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

    @GET("subject")
    Call<List<SubjectBean>> listSubject(@Query("index") int index);

    @GET("game")
    Call<List<GameBean>> listGame(@Query("index") int index);

    @GET("home")
    Call<HomeBean> listHome(@Query("index") int index);

    @GET("app")
    Call<List<GameBean>> listApp(@Query("index") int index);

    @GET("detail")
    Call<AppInfoBean> listAppInfo(@Query("packageName") String packageName);

}
