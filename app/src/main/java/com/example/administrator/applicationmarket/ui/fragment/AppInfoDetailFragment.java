package com.example.administrator.applicationmarket.ui.fragment;

import android.view.View;

import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.bean.AppInfoBean;
import com.example.administrator.applicationmarket.network.HeiMaRetrofit;
import com.example.administrator.applicationmarket.wiget.AppInfoNewsView;
import com.example.administrator.applicationmarket.wiget.AppInfoPropertyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/30.
 */

public class AppInfoDetailFragment extends BaseFragment {

    @BindView(R.id.app_new_view)
    AppInfoNewsView mAppNewView;
    @BindView(R.id.app_property_view)
    AppInfoPropertyView mAppPropertyView;
    private AppInfoBean mAppInfoBean;

    @Override
    public void startDateLoad() {

        String packageName = getActivity().getIntent().getStringExtra("package_name");
        HeiMaRetrofit.getInstance().getApi().listAppInfo(packageName).enqueue(new Callback<AppInfoBean>() {
            @Override
            public void onResponse(Call<AppInfoBean> call, Response<AppInfoBean> response) {
                mAppInfoBean = response.body();
                loadDateSuccess();
            }

            @Override
            public void onFailure(Call<AppInfoBean> call, Throwable t) {
                loadDateError();
            }
        });
    }

    @Override
    public View onCreatContentView() {

        View inflate = View.inflate(getContext(), R.layout.view_app_info, null);
        ButterKnife.bind(this, inflate);
        //加载详情页面的信息ui
        mAppNewView.bindView(mAppInfoBean);
        mAppPropertyView.bindView(mAppInfoBean);
        return inflate;
    }

}
