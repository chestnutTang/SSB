package com.shangshaban.zhaopin.activity2.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.shangshaban.zhaopin.activity2.R;
import com.shangshaban.zhaopin.activity2.ui.fragment.HomePageFragment;
import com.shangshaban.zhaopin.activity2.util.JumpTools;
import com.shangshaban.zhaopin.activity2.util.Tools;

import butterknife.BindView;

/**
 * 主页
 */
public class MainActivity extends BaseActivity implements BottomNavigationView
        .OnNavigationItemSelectedListener {


    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    ConstraintLayout container;

    private HomePageFragment homePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindFragment();
        bindListener();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void bindFragment() {
        homePageFragment = new HomePageFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, homePageFragment);
        transaction.commit();
    }

    private void switchFragmentText(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        transaction2.replace(R.id.container, fragment);
        transaction2.commit();
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        message.setOnClickListener(this);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.message:
                JumpTools.jumpOnly(this, SettingsActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                message.setText(R.string.title_home);
                switchFragmentText(homePageFragment);
                return true;
            case R.id.navigation_dashboard:
                message.setText(R.string.title_dashboard);
                return true;
            case R.id.navigation_notifications:
                message.setText(R.string.title_notifications);
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Tools.logoutSystem(this);
    }
}
