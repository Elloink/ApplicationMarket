package com.example.administrator.applicationmarket.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.network.Api;
import com.example.administrator.applicationmarket.network.HeiMaRetrofit;
import com.example.administrator.applicationmarket.utils.RandomUtils;
import com.example.administrator.applicationmarket.wiget.FlowLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2017/3/26.
 */

public class HotFragment extends BaseFragment {

    private List<String> mDataList;

    @Override
    public void startDateLoad() {

        Api api = HeiMaRetrofit.getInstance().getApi();//获取api
        Call<List<String>> listCall = api.listHot();//获取网络请求call
        listCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                //加载成功，获得网络数据
                mDataList = response.body();
                //调用基类封装的，数据加载成功的页面
                loadDateSuccess();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                //请求失败，调用加载失败的方法
                loadDateError();
            }
        });
    }

    /**
     * 创建自己的视图
     * @return
     */
    @Override
    public View onCreatContentView() {

        //创建一个可以滚动view控件，防止布局超出
        ScrollView scrollView = new ScrollView(getContext());

        //创建一个流式布局
        FlowLayout flowLayout = new FlowLayout(getContext());

        //设置内编剧
        int padding = getResources().getDimensionPixelOffset(R.dimen.padding);

        //设置流式布局的内编剧
        flowLayout.setPadding(padding, padding, padding, padding);

        //将网络数据，加载到流式布局中
        for (int i = 0; i < mDataList.size(); i++) {
            final String data = mDataList.get(i);
            //创建一个selector
            StateListDrawable stateListDrawable = getStateListDrawable();

            final TextView textView = getTextView(padding, data);
            textView.setBackgroundDrawable(stateListDrawable);

            flowLayout.addView(textView);
        }
        scrollView.addView(flowLayout);
        return scrollView;
    }

    /**
     * 创建一个选择器
     * @return
     */
    @NonNull
    private StateListDrawable getStateListDrawable() {

        //创建一个share
        GradientDrawable share = new GradientDrawable();
        //设置圆角
        share.setCornerRadius(15);
        int rgb  = RandomUtils.getRGB();
        //设置背景颜色
        share.setColor(rgb);

        //创建一个选择器
        StateListDrawable selector = new StateListDrawable();

        //添加按下去的状态Drable
        GradientDrawable downShare = new GradientDrawable();
        //设置圆角
        downShare.setCornerRadius(15);
        //设置颜色
        downShare.setColor(Color.DKGRAY);
        //设置选择器按下和普通状态
        selector.addState(new int[]{android.R.attr.state_pressed}, downShare);
        selector.addState(new int[]{}, share);

        //创建一个选择器
        return selector;
    }

    /**
     * 创建一个TextView
     * @param padding
     * @param data
     * @return
     */
    @NonNull
    private TextView getTextView(int padding, final String data) {
        //创建textview来加载数据
        final TextView textView = new TextView(getContext());
        textView.setText(data);
        textView.setPadding(padding, padding, padding, padding);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20.0f);

        //设置tv可以点击
        textView.setClickable(true);
        //设置点击事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
        return textView;
    }

}
