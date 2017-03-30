package com.example.administrator.applicationmarket.ui.fragment;

import com.example.administrator.applicationmarket.bean.GameBean;
import com.example.administrator.applicationmarket.network.HeiMaRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/26.
 */

public class AppFragment extends AppAllFragment {

    @Override
    protected void onStartLoadMore() {

        HeiMaRetrofit.getInstance().getApi().listApp(getList().size()).enqueue(new Callback<List<GameBean>>() {

            @Override
            public void onResponse(Call<List<GameBean>> call, Response<List<GameBean>> response) {
                getList().addAll(response.body());
                getListAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GameBean>> call, Throwable t) {

            }
        });
    }

    @Override
    public void startDateLoad() {

        HeiMaRetrofit.getInstance().getApi().listApp(0).enqueue(new Callback<List<GameBean>>() {
            
            @Override
            public void onResponse(Call<List<GameBean>> call, Response<List<GameBean>> response) {
                getList().addAll(response.body());
                loadDateSuccess();
            }

            @Override
            public void onFailure(Call<List<GameBean>> call, Throwable t) {
                loadDateError();
            }
        });

    }

    @Override
    protected void onListItemClick(int position) {

    }
}
