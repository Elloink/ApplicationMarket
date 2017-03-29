package com.example.administrator.applicationmarket.utils;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Administrator on 2017/3/27.
 */

public class RandomUtils {

    /**
     * 随机产生颜色，通过三基色来产生
     * @return
     */
    public static int getRGB() {
        //设置随机的颜色
        int red = 40 + new Random().nextInt(200);
        int green = 40 + new Random().nextInt(200);
        int blue = 40 + new Random().nextInt(200);

        return Color.rgb(red, green, blue);
    }

}
