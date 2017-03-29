package com.example.administrator.applicationmarket.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.administrator.applicationmarket.R;
import com.example.administrator.applicationmarket.bean.CategoryBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/28.
 */

public class CategoryListItemView extends RelativeLayout {

    @BindView(R.id.category_tv_title)
    TextView mCategoryTvTitle;
    @BindView(R.id.category_tl)
    TableLayout mCategoryTl;

    public CategoryListItemView(Context context) {
        this(context, null);
    }

    public CategoryListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        View.inflate(getContext(), R.layout.item_category, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(CategoryBean categoryBean) {
        //添加标题
        mCategoryTvTitle.setText(categoryBean.getTitle());
        //应为Adapter的回收机制，第二次重复使用会导致数据多次加载，需要把以前的数据溢出
        mCategoryTl.removeAllViews();

        //获取表格的所有数据,给表格添加item
        List<CategoryBean.InfosBean> infos = categoryBean.getInfos();
        for (int i = 0; i < infos.size(); i++) {
            //创建行-view
            TableRow tableRow = new TableRow(getContext());

            //自动获取表格的item宽度
            int itemWidth = getResources().getDisplayMetrics().widthPixels - mCategoryTl.getPaddingLeft() - mCategoryTl.getPaddingRight();

            //设置item的布局参数-宽度评分
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(getContext(), null);
            layoutParams.width = itemWidth / 3;

            CategoryBean.InfosBean infosBean = infos.get(i);

            //创建每个格的view
            CategoryItemRowView categoryItemRowView = new CategoryItemRowView(getContext());
            categoryItemRowView.bindView(infosBean.getName1(), infosBean.getUrl1());
            categoryItemRowView.setLayoutParams(layoutParams);
            tableRow.addView(categoryItemRowView);

            //判断是否存在第二个格子
            if(infosBean.getName2().length() > 0) {
                CategoryItemRowView categoryItemRowView2 = new CategoryItemRowView(getContext());
                categoryItemRowView2.bindView(infosBean.getName2(), infosBean.getUrl2());
                categoryItemRowView2.setLayoutParams(layoutParams);
                tableRow.addView(categoryItemRowView2);
            }

            //判断是否存在第三个格子
            if(infosBean.getName3().length() > 0) {
                CategoryItemRowView categoryItemRowView3 = new CategoryItemRowView(getContext());
                categoryItemRowView3.bindView(infosBean.getName3(), infosBean.getUrl3());
                categoryItemRowView3.setLayoutParams(layoutParams);
                tableRow.addView(categoryItemRowView3);
            }

            mCategoryTl.addView(tableRow);
        }
    }
}
