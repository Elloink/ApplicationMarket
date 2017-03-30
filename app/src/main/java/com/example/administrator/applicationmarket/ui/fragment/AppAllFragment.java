package com.example.administrator.applicationmarket.ui.fragment;

import android.widget.BaseAdapter;

import com.example.administrator.applicationmarket.adapter.AppAllAdapter;
import com.example.administrator.applicationmarket.bean.GameBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public abstract class AppAllFragment extends BaseLoadMoreListFragment {

    private List<GameBean> mList = new ArrayList<>();

    @Override
    protected BaseAdapter onCreateAdapter() {
        return new AppAllAdapter(getContext(), mList);
    }

    public List<GameBean> getList() {
        return mList;
    }

}
