package com.example.administrator.applicationmarket.wiget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.app.Const;
import com.example.administrator.applicationmarket.bean.AppInfoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/30.
 */

public class AppInfoPropertyView extends RelativeLayout {


    @BindView(R.id.ll_attr_property)
    LinearLayout mLlAttrProperty;
    @BindView(R.id.img_property)
    ImageView mImgProperty;
    @BindView(R.id.ll_attr_info)
    LinearLayout mLlAttrInfo;
    private boolean mIsopen;

    public AppInfoPropertyView(Context context) {
        this(context, null);
    }

    public AppInfoPropertyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mIsopen = true;
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.view_app_info_property, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(AppInfoBean appInfoBean) {
        List<AppInfoBean.SafeBean> safe = appInfoBean.getSafe();
        for (int i = 0; i < safe.size(); i++) {

            AppInfoBean.SafeBean safeBean = safe.get(i);
            String url = Const.url + safeBean.getSafeUrl();
            //创建一个图片控件
            ImageView imageView = new ImageView(getContext());
            Glide.with(getContext())
                    .load(url)
                    .override(240, 120)
                    .into(imageView);
            //将控件加载到布局
            mLlAttrProperty.addView(imageView);

            //创建一个布局
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            //创建图片控件
            String urlDes = Const.url + safeBean.getSafeDesUrl();
            ImageView checkBox = new ImageView(getContext());
            Glide.with(getContext())
                    .load(urlDes)
                    .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .into(checkBox);
            linearLayout.addView(checkBox);
            TextView textView = new TextView(getContext());
            textView.setText(safeBean.getSafeDes());
            //判断颜色是不是为0，显示不同的颜色，提示用户应用是否安全
            if (safeBean.getSafeDesColor() != 0) {
                textView.setTextColor(getResources().getColor(R.color.app_detail_safe_warning));
            } else {
                textView.setTextColor(getResources().getColor(R.color.app_detail_safe_normal));
            }
            linearLayout.addView(textView);
            mLlAttrInfo.addView(linearLayout);
        }

    }

    @OnClick(R.id.img_property)
    public void onClick() {
        //箭头的点击事件
        toggle();
    }

    private void toggle() {

        if (mIsopen) {
            mLlAttrInfo.measure(0, 0);
            //测量LiearLayout的高度
            int measuredHeight = mLlAttrInfo.getMeasuredHeight();

            //创建一个View动画
            ValueAnimator viewAnimator = ValueAnimator.ofInt(0, measuredHeight);
            viewAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int values = (int) animation.getAnimatedValue();
                    //获取布局的参数，根据动画变化的数据改变布局参数
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mLlAttrInfo.getLayoutParams();
                    layoutParams.height = values;
                    mLlAttrInfo.setLayoutParams(layoutParams);
                }
            });
            //开启动画
            viewAnimator.start();

            //设置属性动画
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImgProperty, "rotation", 0, -180);
            objectAnimator.start();


        } else {
            //测量LiearLayout的高度
            int measuredHeight = mLlAttrInfo.getMeasuredHeight();
            //创建一个View动画
            ValueAnimator viewAnimator = ValueAnimator.ofInt(measuredHeight, 0);
            //监听动画执行过程
            viewAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int values = (int) animation.getAnimatedValue();
                    //获取布局的参数，根据动画变化的数据改变布局参数
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mLlAttrInfo.getLayoutParams();
                    layoutParams.height = values;
                    mLlAttrInfo.setLayoutParams(layoutParams);
                }
            });
            //开启动画
            viewAnimator.start();
            //设置属性动画
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImgProperty, "rotation", -180, 0);
            objectAnimator.start();
        }
        mIsopen = !mIsopen;
    }
}
