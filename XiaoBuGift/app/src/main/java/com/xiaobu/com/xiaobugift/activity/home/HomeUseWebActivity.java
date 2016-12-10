package com.xiaobu.com.xiaobugift.activity.home;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.base.BaseActivity;

/**
 * Created by xiaoBu on 16/12/2.
 * 首页--复用 webview
 */
public class HomeUseWebActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    public int setLayout() {
        return R.layout.activity_home_use_web;
    }

    @Override
    public void initView() {

        mWebView = (WebView) findViewById(R.id.web_home_use);
    }

    @Override
    public void initData() {

        isHomeUseWeb();

    }

    private void isHomeUseWeb() {

        Intent intent = getIntent();
        String idHomeUseWeb = intent.getStringExtra("KeyHomeUse");

        // 网址拼接
        String url = "http://www.liwushuo.com/posts/" + idHomeUseWeb + "/content";
        mWebView.loadUrl(url);

        // 覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为,使网页用WebView打开
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                // 返回值是true的时候控制区WebView打开,false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }

        });
    }
}
