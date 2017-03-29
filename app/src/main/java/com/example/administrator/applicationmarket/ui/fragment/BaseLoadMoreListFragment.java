package com.example.administrator.applicationmarket.ui.fragment;

/**
 * Created by Administrator on 2017/3/29.
 */

import android.widget.AbsListView;

/**
 * 加载更多的基类封装
 */
public abstract class BaseLoadMoreListFragment extends BaseListFragment {

    public void initListView() {
        super.initListView();

        getListView().setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //当滚动状态为空闲
                if(scrollState == SCROLL_STATE_IDLE) {
                    //当当前条目为最后一个条目时
                    if(view.getLastVisiblePosition() == getAdapterItemPos()) {
                        onStartLoadMore();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    private int getAdapterItemPos() {
        return getListAdapter().getCount()-1 + getListView().getHeaderViewsCount();
    }

    /**
     * 加载更多的数据，交给子类来实现这个方法
     */
    protected abstract void onStartLoadMore();
}
