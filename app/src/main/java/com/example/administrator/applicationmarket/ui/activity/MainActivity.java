package com.example.administrator.applicationmarket.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.adapter.IndicatorAdapter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.left_nag_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private String[] mIndicatorArray;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        super.init();

        mIndicatorArray = getResources().getStringArray(R.array.indicator);
        addBar();

        //设置左侧菜单的点击事件
        mNavigationView.setNavigationItemSelectedListener(mItemSelectedListener);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new IndicatorAdapter(mIndicatorArray, supportFragmentManager));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * 设置viewpager的数据
     */
    private PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return mIndicatorArray.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText(mIndicatorArray[position]);
            container.addView(tv);

            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mIndicatorArray[position];
        }
    };

    private void addBar() {

        setSupportActionBar(mToolbar);

        //定义一个系统的标题栏
        ActionBar actionBar = getSupportActionBar();

        //设置返回按钮是否可见
        actionBar.setDisplayHomeAsUpEnabled(true);

        //关联左侧菜单
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        //如果抽屉没打开就打开，同步DrawerLayout的状态
        mActionBarDrawerToggle.syncState();

        //菜单状态发生变化，触发状态
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    /**
     * 设置标题条的点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //点击哪个条目，就选择哪个条目
                mActionBarDrawerToggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    };

    /**
     * 左侧菜单的点击事件
     * 左侧菜单是通过NavigationView来设置的
     */
    private NavigationView.OnNavigationItemSelectedListener
            mItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            //关闭左侧菜单
            mDrawerLayout.closeDrawer(GravityCompat.START);
            //设置点击的条目未选中状态
            return true;
        }
    };

}
