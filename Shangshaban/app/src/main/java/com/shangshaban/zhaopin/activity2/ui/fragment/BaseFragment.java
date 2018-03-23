package com.shangshaban.zhaopin.activity2.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;


/**
 * 所有碎片的基类
 */
public abstract class BaseFragment extends Fragment {

    protected View view;
    protected abstract int getLayoutId();
}
