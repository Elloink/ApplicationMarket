package com.example.administrator.applicationmarket.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */

/**
 * 首页，应用，游戏，专题，分类都包含一个ListView，所以都会实现Adapter的方法
 * 现在抽取一个Adapter的方法，可以复用，减少重复代码
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

    private final List<T> mListData;
    private final Context mContext;

    protected BaseListAdapter(Context context, List<T> data){
        mListData = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        if(mListData != null) {
            return mListData.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {

            viewHolder = onCreateViewHolder(position);

            convertView = viewHolder.holdView;

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        onBindViewHolder(viewHolder, position);

        return convertView;
    }

    /**
     * 绑定ViewHolder，设置ViewHolder的参数View的显示值
     * @param viewHolder
     * @param position
     */
    protected abstract void onBindViewHolder(ViewHolder viewHolder, int position);

    /**
     * 让子类来创建ViewHolder和convertView
     * @param position
     * @return
     */
    protected abstract ViewHolder onCreateViewHolder(int position);


    //定义ViewHolder，在内部定义convertView
    static class ViewHolder{
        View holdView;
        public ViewHolder(View v) {
            holdView = v;
        }
    }

    public List<T> getListData() {
        return mListData;
    }

    public Context getContext() {
        return mContext;
    }
}
