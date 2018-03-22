package com.shangshaban.zhaopin.activity.util;

import android.util.Log;

import com.shangshaban.zhaopin.activity.BuildConfig;


/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * 自定义日志控制类
 */

public class Logger {
    /**
     * 判断是否是测试模式，只有测试模式才输出log，正式版不输出log
     */
    private static final boolean isDebug = BuildConfig.DEBUG;

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

}
