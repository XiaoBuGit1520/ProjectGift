package com.xiaobu.com.xiaobugift.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by xiaoBu on 16/11/22.
 * 基类:BaseActivity
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }

    // 设置布局
    public abstract int setLayout();

    // 初始化组件
    public abstract void initView();

    // 初始化数据
    public abstract void initData();

    public <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

}
