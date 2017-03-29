package com.example.administrator.applicationmarket.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.administrator.applicationmarket.R;

/**
 * Created by Administrator on 2017/3/26.
 */

public abstract class BaseFragment extends Fragment {

    private ProgressBar mProgressBar;
    private LinearLayout mLinearLayout;
    private ImageView mImageView;
    private Button mButton;
    private FrameLayout mBaseFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_base, null);

        mProgressBar = (ProgressBar) root.findViewById(R.id.pb_fragment);
        mLinearLayout = (LinearLayout) root.findViewById(R.id.ll_error_fragment);
        mImageView = (ImageView) root.findViewById(R.id.img_error_fragment);
        mButton = (Button) root.findViewById(R.id.bt_error_fragment);
        mBaseFragment = (FrameLayout) root.findViewById(R.id.base_fragment);

        return root;
    }

    /**
     * 当布局创建之后，调用加载数据
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startDateLoad();
    }

    //加载数据，子类自己必须执行
    public abstract void startDateLoad();

    //子类自定义视图，添加到基类的页面中
    public abstract View onCreatContentView();

    /**
     * 加载失败调用
     */
    public void loadDateError() {
        mLinearLayout.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    /**
     * 数据加载成功
     */
    public void loadDateSuccess() {
        mProgressBar.setVisibility(View.GONE);
        mLinearLayout.setVisibility(View.GONE);
        //加载成功，将子类的页面填充到基类的布局
        mBaseFragment.addView(onCreatContentView());
    }
}
