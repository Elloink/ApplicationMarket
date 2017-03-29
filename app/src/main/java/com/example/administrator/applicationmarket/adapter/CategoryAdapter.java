package com.example.administrator.applicationmarket.adapter;

import android.content.Context;

import com.example.administrator.applicationmarket.bean.CategoryBean;
import com.example.administrator.applicationmarket.wiget.CategoryListItemView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */

public class CategoryAdapter extends BaseListAdapter {

    private final Context mContext;
    private final List<CategoryBean> mData;

    public CategoryAdapter(Context context, List<CategoryBean> data) {
        super(context, data);
        mContext = context;
        mData = data;
    }

    @Override
    protected void onBindViewHolder(ViewHolder viewHolder, int position) {
        ((CategoryListItemView)viewHolder.holdView).bindView(mData.get(position));
    }

    @Override
    protected ViewHolder onCreateViewHolder(int position) {
        return new ViewHolder(new CategoryListItemView(mContext, null));
    }
}
