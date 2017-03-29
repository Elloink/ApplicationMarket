package com.example.administrator.applicationmarket.adapter;

import android.content.Context;

import com.example.administrator.applicationmarket.bean.SubjectBean;
import com.example.administrator.applicationmarket.wiget.SubjectItemView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class SubjectAdapter extends BaseLoadMoreListAdapter<SubjectBean> {

    private final Context mContext;
    private final List<SubjectBean> mData;

    public SubjectAdapter(Context context, List<SubjectBean> data) {
        super(context, data);
        mData = data;
        mContext = context;
    }

    @Override
    protected void onBindNomelViewHolder(ViewHolder viewHolder, int position) {
        ((SubjectItemView)viewHolder.holdView).bindView(mData.get(position));
    }

    @Override
    public ViewHolder onCreateNomelViewHolder(int position) {
        return new ViewHolder(new SubjectItemView(mContext));
    }


}
