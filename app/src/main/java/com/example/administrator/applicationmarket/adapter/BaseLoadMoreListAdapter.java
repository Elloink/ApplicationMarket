package com.example.administrator.applicationmarket.adapter;

import android.content.Context;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class BaseLoadMoreListAdapter<T> extends BaseListAdapter<T> {

    //两种展示效果，一种是进度条显示状态，一种是普通显示状态
    private static final int ITEM_PROGRESS = 166;
    private static final int ITEM_NORMEL = 166;

    protected BaseLoadMoreListAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    protected void onBindViewHolder(ViewHolder viewHolder, int position) {

    }

    @Override
    protected ViewHolder onCreateViewHolder(int position) {
        return null;
    }

    /**
     * 多了一个加载更多的条目，需要添加一个条目
     * @return
     */
    @Override
    public int getCount() {

        if (getListData() == null) {
            return 0;
        } else {
            return getListData().size() + 1;
        }
    }
}
