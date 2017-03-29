package com.example.administrator.applicationmarket.ui.fragment;

import android.view.View;

import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.adapter.StellarMapAdapter;
import com.example.administrator.applicationmarket.network.HeiMaRetrofit;
import com.example.administrator.applicationmarket.wiget.StellarMap;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/26.
 */

public class RecommendFragment extends BaseFragment {

    private static final String TAG = "RecommendFragment";
    private List<String> mData;

    @Override
    public void startDateLoad() {
        //获得网络解析的数据结构对象
        Call<List<String>> listCommend = HeiMaRetrofit.getInstance().getApi().listCommend();

        //将连接添加到队列
        listCommend.enqueue(callback);
    }

    private Callback<List<String>> callback = new Callback<List<String>>() {

        @Override
        public void onResponse(Call<List<String>> call, Response<List<String>> response) {
            //获取到网络请求的数据
            mData =  response.body();
            loadDateSuccess();
        }

        @Override
        public void onFailure(Call<List<String>> call, Throwable t) {
            loadDateError();
        }
    };

    /**
     * 创建自己的ui，加载到页面
     * @return
     */
    @Override
    public View onCreatContentView() {

        //创建星状图
        StellarMap stellarMap = new StellarMap(getContext());
        //设置adapter
        stellarMap.setAdapter(new StellarMapAdapter(mData, getContext()));

        //设置星状图内部的边距
        int padding = getResources().getDimensionPixelOffset(R.dimen.padding);
        stellarMap.setPadding(padding, padding, padding, padding);

        //设置网格布局，会自动按照网格放置条目
        stellarMap.setRegularity(15, 20);

        //初始化数组
        stellarMap.setGroup(0, false);

        return stellarMap;
    }
}
