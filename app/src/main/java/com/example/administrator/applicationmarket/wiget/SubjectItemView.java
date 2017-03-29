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
import com.example.administrator.applicationmarket.bean.SubjectBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/29.
 */

public class SubjectItemView extends RelativeLayout {

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.text)
    TextView mText;

    public SubjectItemView(Context context) {
        this(context, null);
    }

    public SubjectItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.item_subject, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(SubjectBean subjectBean) {
        String url = Const.url + subjectBean.getUrl();

        Glide.with(getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.recommend_29)
                .into(mImg);
        mText.setText(subjectBean.getDes());
    }
}
