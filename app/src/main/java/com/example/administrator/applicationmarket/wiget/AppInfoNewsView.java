package com.example.administrator.applicationmarket.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.app.Const;
import com.example.administrator.applicationmarket.bean.AppInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/30.
 */

public class AppInfoNewsView extends RelativeLayout {

    @BindView(R.id.app_icon)
    ImageView mAppIcon;
    @BindView(R.id.app_name)
    TextView mAppName;
    @BindView(R.id.app_rating)
    RatingBar mAppRating;
    @BindView(R.id.app_down_size)
    TextView mAppDownSize;
    @BindView(R.id.app_version)
    TextView mAppVersion;
    @BindView(R.id.app_time)
    TextView mAppTime;
    @BindView(R.id.app_size)
    TextView mAppSize;

    public AppInfoNewsView(Context context) {
        this(context, null);
    }

    public AppInfoNewsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.view_app_news, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppInfoBean appInfoBean) {
        //加载应用图标
        Glide.with(getContext())
                .load(Const.url + appInfoBean.getIconUrl())
                .centerCrop()
                .into(mAppIcon);
        //加载名称
        mAppName.setText(appInfoBean.getName());
        //加载星级
        mAppRating.setRating((float) appInfoBean.getStars());
        //加载下载大小--设置显示的格式
        String stringFormatter = getResources().getString(R.string.download_count);
        String format = String.format(stringFormatter, appInfoBean.getDownloadNum());
        mAppDownSize.setText(format);
        //加载版本信息
        String stringVersion = getResources().getString(R.string.version_code);
        String version = String.format(stringVersion, appInfoBean.getVersion());
        mAppVersion.setText(version);
        //加载时间
        String stringTime = getResources().getString(R.string.time);
        String time = String.format(stringTime, appInfoBean.getDate());
        mAppTime.setText(time);
        //加载大小
        String sizeFormatter = getResources().getString(R.string.app_size);
        String size = String.format(sizeFormatter, appInfoBean.getSize());
        mAppSize.setText(size);
    }
}
