package com.xiaobu.com.xiaobugift.fragment.gift;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.base.BaseFragment;

/**
 * Created by xiaoBu on 16/12/3.
 */

public class GiftNextParticularsFragment extends BaseFragment {

    private WebView mWebView;
    private MyBR myBR;

    @Override
    public int setLayout() {
        return R.layout.fragment_gift_next_particulars;
    }

    @Override
    public void initView(View view) {

        mWebView = (WebView) view.findViewById(R.id.web_gift_next_particulars);
    }

    @Override
    public void initData() {

        isBRRegister();//动态注册广播
    }

    /**
     * 解除注册广播
     */
    @Override
    public void onDestroy() {
        // 解除注册
        super.onDestroy();
        getContext().unregisterReceiver(myBR);
    }

    /**
     * 动态注册广播
     */
    private void isBRRegister() {
        myBR = new MyBR();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getContext().getPackageName() + ".MyBR");
        getContext().registerReceiver(myBR, intentFilter);
    }

    /**
     * 广播内部类
     */
    class MyBR extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 获取到广播中发送的内容
            String url = intent.getStringExtra("url");
            Log.d("MyBR", url);
            mWebView.loadUrl(url);
        }
    }
}
