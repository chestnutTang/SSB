package com.shangshaban.zhaopin.activity.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.shangshaban.zhaopin.activity.R;
import com.shangshaban.zhaopin.activity.ui.view.CircleImageViewGlide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 首页列表
 */
public class HomePageFragment extends BaseFragment {


    @BindView(R.id.text_show)
    TextView textShow;
    @BindView(R.id.head_iv)
    ImageView headIv;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
        }
        unbinder = ButterKnife.bind(this, view);
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        RequestOptions options = new RequestOptions().transform(new CircleImageViewGlide());
        options.diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(view).load(R.drawable.ic_message_unchecked).apply(options).into(headIv);
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.ssb_fragment_base;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
