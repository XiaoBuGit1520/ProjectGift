package com.xiaobu.com.xiaobugift.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.home.HomeGlideAdapterNext;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.bean.home.HomeGlideDataNext;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/12/1.
 * 轮播图二级界面
 */

public class HomeGlideActivity extends BaseActivity {

    private ListView mListView;
    private String mGlideUrl;

    @Override
    public int setLayout() {
        return R.layout.activity_homeglide;
    }

    @Override
    public void initView() {

        mListView = (ListView) findViewById(R.id.lv_glide_two);

    }

    @Override
    public void initData() {

        isGlideResolve();//轮播图
        isGridSixResolve();//六宫格

    }

    /**
     * 六宫格二级页面解析
     */
    private void isGridSixResolve() {


    }

    /**
     * 轮播图二级页面解析
     */
    private void isGlideResolve() {

        Intent intent = getIntent();
        String idGlide = intent.getStringExtra("keyGlide");
        Log.d("HomeGlideActivity", idGlide);

        // 网址拼接
        mGlideUrl = "http://api.liwushuo.com/v2/collections/" + idGlide + "/posts?limit=20&offset=0";

        NetHelper.MyRequest(mGlideUrl, HomeGlideDataNext.class, new NetListener<HomeGlideDataNext>() {
            @Override
            public void successListener(HomeGlideDataNext response) {

                HomeGlideAdapterNext adapter = new HomeGlideAdapterNext(getBaseContext());
                adapter.setData(response);
                mListView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }

    /**
     *
     */

}
