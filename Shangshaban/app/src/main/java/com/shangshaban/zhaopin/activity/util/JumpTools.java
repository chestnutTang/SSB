package com.shangshaban.zhaopin.activity.util;

import android.content.Context;
import android.content.Intent;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * Intent 显示跳转工具里
 */

public class JumpTools {

    /**
     * @param context
     * @param targetActivity
     * 不带参数的跳转
     */
    public static void jumpOnly(Context context, Class<?> targetActivity) {
        Intent intent = new Intent(context, targetActivity);
        context.startActivity(intent);
    }

}
