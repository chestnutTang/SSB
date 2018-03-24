package com.shangshaban.zhaopin.activity2.ui.activity;

import android.os.Bundle;

import com.shangshaban.zhaopin.activity2.R;
import com.shangshaban.zhaopin.activity2.ui.view.GLPanorama;

import butterknife.BindView;

public class OpenGLActivity extends BaseActivity {

    @BindView(R.id.mGLPanorama)
    GLPanorama mGLPanorama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLPanorama= (GLPanorama) findViewById(R.id.mGLPanorama);
        mGLPanorama.setGLPanorama(R.drawable.timg2);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_open_gl;
    }
}
