package com.example.administrator.applicationmarket.adapter;

import android.content.Context;

import com.example.administrator.applicationmarket.wiget.MoreListProgress;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

/**
 * 对专题、游戏、应用、首页的Adapter抽取，他们的共性是，可以下拉家在更多
 * @param <T>
 */
public abstract class BaseLoadMoreListAdapter<T> extends BaseListAdapter<T> {

    //两种展示效果，一种是进度条显示状态，一种是普通显示状态
    private static final int ITEM_PROGRESS = 0;
    private static final int ITEM_NORMEL = 1;

    protected BaseLoadMoreListAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    protected void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (ITEM_NORMEL == getItemViewType(position)) {
            onBindNomelViewHolder(viewHolder, position);
        }
    }

    @Override
    protected ViewHolder onCreateViewHolder(int position) {

        if (position == getCount() - 1) {
            return new ViewHolder(new MoreListProgress(getContext()));
        }else {
            return onCreateNomelViewHolder(position);
        }
    }

    //子类绑定普通的viewholder
    protected abstract void onBindNomelViewHolder(ViewHolder viewHolder, int position);

    /**
     * 让孩子来完成list数据的viewholder创建
     * @param position
     * @return
     */
    public abstract ViewHolder onCreateNomelViewHolder(int position);

    /**
     * 多了一个加载更多的条目，需要添加一个条目
     *
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

    /**
     * 获得ListView的item类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        if (position == getCount() - 1) {
            return ITEM_PROGRESS;
        } else {
            return ITEM_NORMEL;
        }
    }

    /**
     * item类型的数量
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
