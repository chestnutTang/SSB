package com.shangshaban.zhaopin.activity2.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shangshaban.zhaopin.activity2.app.SsbApplication;

import butterknife.ButterKnife;

/**
 * 所有Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        SsbApplication.getInstance().addActivity(this);
    }

    /**
     * @return 返回布局文件ID
     */
    protected abstract int getLayoutId();

    protected void bindListener() {
    }

    @Override
    public void onClick(View v) {

    }
}
