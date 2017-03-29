package com.example.administrator.applicationmarket.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.app.Const;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/28.
 */

public class CategoryItemRowView extends RelativeLayout {

    @BindView(R.id.view_category_iv)
    ImageView mViewCategoryIv;
    @BindView(R.id.view_category_tv)
    TextView mViewCategoryTv;

    public CategoryItemRowView(Context context) {
        this(context, null);
    }

    public CategoryItemRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.view_category_row, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(String text, String url) {
        mViewCategoryTv.setText(text);
        String urlApp = Const.url + url;
        Glide.with(getContext())
                .load(urlApp)
                .placeholder(R.drawable.ic_default)
                .centerCrop()
                .into(mViewCategoryIv);
    }
}
