package com.example.administrator.applicationmarket.ui.fragment;

import android.widget.BaseAdapter;

import com.example.administrator.applicationmarket.adapter.SubjectAdapter;
import com.example.administrator.applicationmarket.bean.SubjectBean;
import com.example.administrator.applicationmarket.network.HeiMaRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/26.
 */

public class SubjectFragment extends BaseLoadMoreListFragment {

    private List<SubjectBean> mListData;

    @Override
    protected void onStartLoadMore() {
        HeiMaRetrofit.getInstance().getApi().listSubject(mListData.size()).enqueue(new Callback<List<SubjectBean>>() {

            @Override
            public void onResponse(Call<List<SubjectBean>> call, Response<List<SubjectBean>> response) {
                List<SubjectBean> body = response.body();
                mListData.addAll(body);
                getListAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SubjectBean>> call, Throwable t) {

            }
        });
    }

    @Override
    public void startDateLoad() {

        Call<List<SubjectBean>> subject = HeiMaRetrofit.getInstance().getApi().listSubject(0);
        subject.enqueue(callback);

    }

    private Callback<List<SubjectBean>> callback = new Callback<List<SubjectBean>>() {

        @Override
        public void onResponse(Call<List<SubjectBean>> call, Response<List<SubjectBean>> response) {
            mListData = response.body();
            loadDateSuccess();
        }

        @Override
        public void onFailure(Call<List<SubjectBean>> call, Throwable t) {
            loadDateError();
        }
    };

    @Override
    protected void onListItemClick(int position) {

    }

    @Override
    protected BaseAdapter onCreateAdapter() {
        return new SubjectAdapter(getContext(), mListData);
    }
}
