package com.shangshaban.zhaopin.activity.util;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.shangshaban.zhaopin.activity.app.SsbApplication;
import com.shangshaban.zhaopin.activity.ui.activity.SettingsActivity;

import static com.shangshaban.zhaopin.activity.util.JumpTools.jumpOnly;

/**
 * 提示类的工具类
 */
public class TipTools {

    /**
     * @param context
     * @param toastStr 系统自带吐司
     */
    public static void toast(Context context, String toastStr) {
        Toast.makeText(context, toastStr, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param view
     * @param tipStr
     * @param rightStr 类似微信用的从底部弹出的提示框
     */
    public static void snackBar(final Context context,final View view, String tipStr, final String rightStr) {
        Snackbar.make(view, tipStr, Snackbar.LENGTH_SHORT).setAction(rightStr, new View
                .OnClickListener() {
            @Override
            public void onClick(View v) {
                toast(context,rightStr);
                jumpOnly(view.getContext(), SettingsActivity.class);
            }
        }).show();
    }

}
