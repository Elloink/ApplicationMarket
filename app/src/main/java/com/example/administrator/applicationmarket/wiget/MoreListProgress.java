package com.example.administrator.applicationmarket.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.applicationmarket.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/29.
 */

public class MoreListProgress extends RelativeLayout {

    public MoreListProgress(Context context) {
        this(context, null);
    }

    public MoreListProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.view_list_progress, this);
        ButterKnife.bind(this, this);
    }
}
