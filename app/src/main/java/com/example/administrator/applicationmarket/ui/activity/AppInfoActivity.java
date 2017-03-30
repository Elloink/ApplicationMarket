package com.example.administrator.applicationmarket.ui.activity;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.applicationmarket.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/3/30.
 */
public class AppInfoActivity extends BaseActivity {


    @BindView(R.id.tool_bar_info)
    Toolbar mToolBarInfo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_app_info;
    }

    @Override
    public void init() {
        super.init();
        initToolBar();
        setStatusBarColor();
    }

    private void setStatusBarColor() {
        //只有在sdk版本在21以上的时候才能设置标题栏的颜色
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();//获得系统设置
            //系统重新绘制标题栏的背景颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorBar));
        }
    }

    private void initToolBar() {

        setSupportActionBar(mToolBarInfo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.app_detail));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
