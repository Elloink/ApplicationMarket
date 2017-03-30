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
import com.example.administrator.applicationmarket.bean.GameBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/29.
 */

public class AppAllItemView extends RelativeLayout {

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.ratingbar)
    RatingBar mRatingbar;
    @BindView(R.id.size)
    TextView mSize;
    @BindView(R.id.download)
    ImageView mDownload;
    @BindView(R.id.contenttext)
    TextView mContenttext;

    public AppAllItemView(Context context) {
        this(context, null);
    }

    public AppAllItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.view_app_all_adapter, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(GameBean gameBean) {

        //加载图标
        String url = Const.url + gameBean.getIconUrl();
        Glide.with(getContext())
                .load(url)
                .centerCrop()
                .into(mImg);

        //加载标题
        mTitle.setText(gameBean.getName());

        //加载星级
        mRatingbar.setRating((float) gameBean.getStars());

        //加载大小
        mSize.setText(android.text.format.Formatter.formatFileSize(getContext(),gameBean.getSize()));

        //加载内容,说明
        mContenttext.setText(gameBean.getDes());
    }
}
