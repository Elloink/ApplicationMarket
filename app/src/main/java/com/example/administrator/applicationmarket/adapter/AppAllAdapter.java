package com.example.administrator.applicationmarket.adapter;

import android.content.Context;

import com.example.administrator.applicationmarket.bean.GameBean;
import com.example.administrator.applicationmarket.wiget.AppAllItemView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class AppAllAdapter extends BaseLoadMoreListAdapter {

    private final List<GameBean> mData;
    private final Context mContext;

    public AppAllAdapter(Context context, List<GameBean> data) {
        super(context, data);
        mData = data;
        mContext = context;
    }

    @Override
    protected void onBindNomelViewHolder(ViewHolder viewHolder, int position) {
        ((AppAllItemView)viewHolder.holdView).bindView(mData.get(position));
    }

    @Override
    public ViewHolder onCreateNomelViewHolder(int position) {
        return new ViewHolder(new AppAllItemView(mContext));
    }
}
