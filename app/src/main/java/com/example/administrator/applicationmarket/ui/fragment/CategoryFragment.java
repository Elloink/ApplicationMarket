package com.example.administrator.applicationmarket.ui.fragment;

import android.widget.ListAdapter;

import com.example.administrator.applicationmarket.adapter.CategoryAdapter;
import com.example.administrator.applicationmarket.bean.CategoryBean;
import com.example.administrator.applicationmarket.network.HeiMaRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/26.
 */

public class CategoryFragment extends BaseListFragment {
    private static final String TAG = "CategoryFragment";
    private List<CategoryBean> mListData;

    @Override
    public void startDateLoad() {
        Call<List<CategoryBean>> listCategory = HeiMaRetrofit.getInstance().getApi().listCategory();
        listCategory.enqueue(callback);
    }

    private Callback<List<CategoryBean>> callback = new Callback<List<CategoryBean>>() {

        @Override
        public void onResponse(Call<List<CategoryBean>> call, Response<List<CategoryBean>> response) {
            mListData = response.body();
            loadDateSuccess();
        }

        @Override
        public void onFailure(Call<List<CategoryBean>> call, Throwable t) {
            loadDateError();
        }
    };

    @Override
    protected void onListItemClick(int position) {

    }

    /**
     * 加载分类页面的Adapter数据
     * @return
     */
    @Override
    protected ListAdapter onCreateAdapter() {
        return new CategoryAdapter(getContext(), mListData);
    }
}
