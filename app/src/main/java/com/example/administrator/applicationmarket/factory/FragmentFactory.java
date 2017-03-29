package com.example.administrator.applicationmarket.factory;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.administrator.applicationmarket.ui.fragment.AppFragment;
import com.example.administrator.applicationmarket.ui.fragment.CategoryFragment;
import com.example.administrator.applicationmarket.ui.fragment.GameFragment;
import com.example.administrator.applicationmarket.ui.fragment.HomenFragment;
import com.example.administrator.applicationmarket.ui.fragment.HotFragment;
import com.example.administrator.applicationmarket.ui.fragment.RecommendFragment;
import com.example.administrator.applicationmarket.ui.fragment.SubjectFragment;


/**
 * Created by Administrator on 2017/3/26.
 */

public class FragmentFactory {

    private static final String TAG = "FragmentFactory";
    /**首页*/
    private static final int FRAGMENT_HOME = 0;
    /**应用*/
    private static final int FRAGMENT_APP = 1;
    /**游戏*/
    private static final int FRAGMENT_GAME = 2;
    /**专题*/
    private static final int FRAGMENT_SUBJECT = 3;
    /**推荐*/
    private static final int FRAGMENT_RECOMMEND = 4;
    /**分类*/
    private static final int FRAGMENT_CATEGORY = 5;
    /**热门*/
    private static final int FRAGMENT_HOT = 6;

    private static FragmentFactory fragmentFactory;

    /**
     * 初始化FragmentFactory对象
     *
     * @return
     */
    public static FragmentFactory initFragment() {

        if (fragmentFactory == null) {
            /**
             * 同步锁，如果多个线程进入，不会创建多个对象
             */
            synchronized (FragmentFactory.class) {
                //再次判断，防止在线程等待的时候，前面的线程已经创建了，只有判断过后才能再次执行
                if (fragmentFactory == null) {
                    fragmentFactory = new FragmentFactory();
                }
            }

        }
        return fragmentFactory;
    }

    public Fragment getFragment(int position) {

        Log.d(TAG, position+"");
        switch (position) {
            case FRAGMENT_HOME:
                return new HomenFragment();

            case FRAGMENT_APP:
                return new AppFragment();

            case FRAGMENT_GAME:
                return new GameFragment();

            case FRAGMENT_SUBJECT:
                return new SubjectFragment();

            case FRAGMENT_RECOMMEND:
                return new RecommendFragment();

            case FRAGMENT_CATEGORY:
                return new CategoryFragment();

            case FRAGMENT_HOT:
                return new HotFragment();
        }
        return null;
    }

}
