package com.example.administrator.applicationmarket.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/26.
 */

public class HeiMaRetrofit {

    private static HeiMaRetrofit heiMaRetrofit;
    private static final String BASE_URL = "http://10.0.2.2:8080/GooglePlayServer/";

    private Gson mGson = new GsonBuilder().setLenient().create();//设置宽大处理畸形的json
    private final Api mApi;

    public HeiMaRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();
        mApi = retrofit.create(Api.class);

    }

    //单例模式，提供公共方法，暴露类的对象
    public static HeiMaRetrofit getInstance() {

        if(heiMaRetrofit == null) {

            synchronized (HeiMaRetrofit.class) {
                if (heiMaRetrofit == null) {
                    heiMaRetrofit = new HeiMaRetrofit();
                }
            }

        }
        return heiMaRetrofit;
    }

    /**
     * 返回Api对象，让外界通过对象调用网络请求
     * @return
     */
    public Api getApi() {
        return mApi;
    }
}
