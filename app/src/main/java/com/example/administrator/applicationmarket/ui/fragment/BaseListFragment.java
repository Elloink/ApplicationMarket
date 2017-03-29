package com.example.administrator.applicationmarket.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/3/27.
 */

/**
 * 首页、应用，游戏，专题，分类都是通过listview来设计的布局
 * 所有可以抽取listview来定义一个公共的基类
 */
public abstract class BaseListFragment extends BaseFragment {

    private ListView mListView;
    private ListAdapter mListAdapter;

    @Override
    public abstract void startDateLoad();

    @Override
    public View onCreatContentView() {

        //抽取的公共布局
        mListView = new ListView(getContext());
        mListAdapter = onCreateAdapter();
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClick(position);
            }
        });
        mListView.setDivider(null);
        return mListView;
    }

    /**
     * 子类必须实现这个方法，来设置Item的点击事件
     * @param position
     */
    protected abstract void onListItemClick(int position);

    /**
     * 子类必须实现这个方法来创建ListView的Adapter
     * @return
     */
    protected abstract ListAdapter onCreateAdapter();

    //创建get方法，通过外部调用
    public ListView getListView() {
        return mListView;
    }

    public ListAdapter getListAdapter() {
        return mListAdapter;
    }
}
