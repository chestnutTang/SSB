package com.shangshaban.zhaopin.activity.app;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * 入口类
 */
public class SsbApplication extends MultiDexApplication {

    private static SsbApplication instance;

    private List<Activity> activityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * @return 初始化
     */
    public static SsbApplication getInstance() {
        if (instance == null) {
            synchronized (SsbApplication.class) {
                if (instance == null) {
                    instance = new SsbApplication();
                }
            }
        }
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //拆包所用
        MultiDex.install(this);
    }

    /**
     * @param activity 所有Activity添加到一个栈里，方面统一管理
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            if (!activityList.contains(activity)) {
                activityList.add(activity);
            }
        }
    }

    /**
     * 移除所有Activity
     */
    public void removeAllActivity() {
        if (activityList != null && activityList.size() > 0) {
            for (Activity activity : activityList) {
                activity.finish();
            }
            activityList.clear();
        }
    }

}
