package com.xiaobu.com.xiaobugift.activity.gift;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftNextAdapter;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.fragment.gift.GiftNextCommentFragment;
import com.xiaobu.com.xiaobugift.fragment.gift.GiftNextOneFragment;
import com.xiaobu.com.xiaobugift.fragment.gift.GiftNextParticularsFragment;

import java.util.ArrayList;

/**
 * Created by xiaoBu on 16/12/3.
 * 榜单Fragment--二级界面
 */

public class GiftNextActivity extends BaseActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> data;
    private static String mId;

//    private MyIdBR myIdBR;
//    private static String mId2;

    @Override
    public int setLayout() {
        return R.layout.activity_gift_use_next;
    }

    @Override
    public void initView() {

        mTabLayout = (TabLayout) findViewById(R.id.tab_gift_next);
        mViewPager = (ViewPager) findViewById(R.id.vp_gift_next);
    }

    @Override
    public void initData() {

        myKey();
        isTabAndVp();
        //isBRRegister();//动态注册广播

    }

    /**
     * Tab+Vp
     */
    private void isTabAndVp() {
        // 让预加载加载两页
        mViewPager.setOffscreenPageLimit(2);
        data = new ArrayList<>();

        data.add(new GiftNextOneFragment());
        data.add(new GiftNextParticularsFragment());
        data.add(new GiftNextCommentFragment());

        // 初始化适配器
        GiftNextAdapter adapter = new GiftNextAdapter(getSupportFragmentManager());
        // 设置数据
        adapter.setData(data);
        // 绑定适配器
        mViewPager.setAdapter(adapter);
        // tab和vp绑定
        mTabLayout.setupWithViewPager(mViewPager);
        // TabLayout设置字体颜色
        mTabLayout.setTabTextColors(Color.argb(255, 50, 30, 30), Color.argb(255, 255, 45, 71));

    }

    /**
     * 接收上一级页面从每个Tab传来的id
     */
    private void myKey() {
        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        Log.d("GiftNextActivity", mId);
    }

    /**
     * 使用静态方法传值到Tab
     *
     * @return
     */
    public static String id() {
        Log.d("GiftNextActivityStatic", mId);
        return mId;
    }

//    /**
//     * 动态注册广播
//     */
//    private void isBRRegister() {
//        myIdBR = new MyIdBR();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(this.getPackageName() + ".MyBR");
//        this.registerReceiver(myIdBR, intentFilter);
//
//    }

//    /**
//     * 解除注册广播
//     */
//    @Override
//    public void onDestroy() {
//        // 解除注册
//        super.onDestroy();
//        this.unregisterReceiver(myIdBR);
//
//    }

//    /**
//     * 广播内部类
//     */
//    class MyIdBR extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            // 获取广播中发送的内容
//            mId2 = intent.getStringExtra("idComment");
//            Log.d("MyIdBR", mId2);
//
//        }
//    }

//    /**
//     * 静态方法
//     *
//     * @return
//     */
//    public static String sendId() {
//        return mId2;
//    }


}
