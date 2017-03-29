package com.example.administrator.applicationmarket.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.administrator.applicationmarket.factory.FragmentFactory;

/**
 * Created by Administrator on 2017/3/26.
 */

/**
 * 关于碎片的Adapter适配器，存在两个
 * FragmentPagerAdapter : 有缓存，会缓存创建过的页面（适配小数据的时候，使用）
 * FragmentstatePagerAdapter  ： 没有缓存，每次都需要创建（对于数据过多，可以使用，太多缓存会导致oom）
 */
public class IndicatorAdapter extends FragmentPagerAdapter {
    private String TAG = "IndicatorAdapter";
    private String[] items = null;

    public IndicatorAdapter(String[] item, FragmentManager fragmentManager) {
        super(fragmentManager);
        items = item;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, ""+ position);
        return FragmentFactory.initFragment().getFragment(position);
    }

    @Override
    public int getCount() {
        if(items != null) {
            return items.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items[position];
    }
}
