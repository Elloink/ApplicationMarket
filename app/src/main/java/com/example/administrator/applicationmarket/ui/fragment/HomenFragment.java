package com.example.administrator.applicationmarket.ui.fragment;

import android.view.View;

import com.example.administrator.applicationmarket.app.Const;
import com.example.administrator.applicationmarket.bean.HomeBean;
import com.example.administrator.applicationmarket.network.HeiMaRetrofit;
import com.leon.loopviewpagerlib.FunBanner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/26.
 */

public class HomenFragment extends AppAllFragment {
    private List<String> mPicture;

    @Override
    protected void onStartLoadMore() {

        HeiMaRetrofit.getInstance().getApi().listHome(getList().size()).enqueue(new Callback<HomeBean>() {

            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                getList().addAll(response.body().getList());
                mPicture = response.body().getPicture();
                getListAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
            }
        });
    }

    @Override
    public View onCreateListHeader() {


        return new FunBanner.Builder(getContext())
                .setHeightWidthRatio(0.377f)
                .setEnableAutoLoop(true)
                .setImageUrlHost(Const.url)
                .setImageUrls(mPicture)
                .build();
    }

    @Override
    public void startDateLoad() {

        HeiMaRetrofit.getInstance().getApi().listHome(0).enqueue(new Callback<HomeBean>() {

            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                getList().addAll(response.body().getList());
                mPicture = response.body().getPicture();
                loadDateSuccess();
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                loadDateError();
            }
        });

    }

}
