package com.xiaobu.com.xiaobugift.activity.welcome;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.main.MainActivity;
import com.xiaobu.com.xiaobugift.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaoBu on 16/12/9.
 * 欢迎页
 */

public class WelcomeActivity extends BaseActivity {

    private ImageView mImageView;

    @Override
    public int setLayout() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//不显示标题栏
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {

        mImageView = (ImageView) findViewById(R.id.iv_welcome);
    }

    @Override
    public void initData() {

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task, 2500);

        isJump();//点击图片跳转

    }

    /**
     * 点击图片直接进入主界面
     */
    private void isJump() {

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
