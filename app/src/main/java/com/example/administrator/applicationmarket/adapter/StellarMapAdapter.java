package com.example.administrator.applicationmarket.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.applicationmarket.utils.RandomUtils;
import com.example.administrator.applicationmarket.wiget.StellarMap;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/27.
 */

public class StellarMapAdapter implements StellarMap.Adapter {

    private List<String> mListDate;
    private static final int ITEM_SIZE = 15;
    private final Context mContext;

    public StellarMapAdapter(List<String> data, Context context) {
        mListDate = data;
        mContext = context;
    }

    /**
     * 返回页面的数目
     *
     * @return
     */
    @Override
    public int getGroupCount() {
        //通过传递过来的数据，计算页面的数量
        int size = mListDate.size();
        if (size % ITEM_SIZE == 0) { //通过余数来判断页面的数量
            return size / ITEM_SIZE;
        } else { //如果余数多于0，则需要多家一个页面
            return size / ITEM_SIZE + 1;
        }
    }

    /**
     * 返回单个页面条目的数量
     *
     * @param group
     * @return
     */
    @Override
    public int getCount(int group) {
        //需要对最后一个页面进行判断，最后一个页面的数值是不确定的
        int size = mListDate.size();
        if (size % ITEM_SIZE != 0) {
            if (group == getGroupCount() - 1) { //如果是最后一个页面，返回余数
                return size % ITEM_SIZE;
            }
        }
        //正常页面的条目值为固定值
        return ITEM_SIZE;
    }

    /**
     * 布局对应组（页面）中的view（条目）
     *
     * @param group       组
     * @param position    条目下标
     * @param convertView 容器
     * @return
     */
    @Override
    public View getView(int group, int position, View convertView) {

        if (convertView == null) {
            convertView = new TextView(mContext);
        }


        TextView tv = (TextView) convertView;
        //设置tv的内容
        int index = group * ITEM_SIZE + position;
        tv.setText(mListDate.get(index));

        //随机大小
        Random random = new Random();
        tv.setTextSize(random.nextInt(4) + 14);

        //设置随机颜色
        int rgb = RandomUtils.getRGB();
        tv.setTextColor(rgb);

        return tv;
    }


    @Override
    public int getNextGroupOnPan(int group, float degree) {
        return 0;
    }

    /**
     * 返回放大或缩小的下一组下标
     *
     * @param group
     * @param isZoomIn
     * @return
     */
    @Override
    public int getNextGroupOnZoom(int group, boolean isZoomIn) {
        //判断是不是需要放大
        if (isZoomIn) {
            //放大就返回下一个页面，% 的作用，当页面为最后一个页面时，可以跳转到第一个页面
            return (group + 1) % getGroupCount();
        } else {
            //不放大就缩小，返回上一个页面
            //通过% 保证页面循环跳转
            return (group - 1 + getGroupCount()) % getGroupCount();
        }
    }
}
