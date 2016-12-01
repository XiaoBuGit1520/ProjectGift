package com.xiaobu.com.xiaobugift.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.home.HomeGlideAdapterTwo;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.bean.home.HomeGlideDataTwo;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/12/1.
 * 轮播图二级界面
 */

public class HomeGlideActivity extends BaseActivity {

    private ListView mListView;
    private String mUrl;

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

        Intent intent = getIntent();
        String idGlide = intent.getStringExtra("keyGlide");

        Log.d("HomeGlideActivity", idGlide);

        // 网址拼接
        mUrl = "http://api.liwushuo.com/v2/collections/" + idGlide + "/posts?limit=20&offset=0";

        isResolve();

    }

    /**
     * 轮播图二级页面解析
     */
    private void isResolve() {

        NetHelper.MyRequest(mUrl, HomeGlideDataTwo.class, new NetListener<HomeGlideDataTwo>() {
            @Override
            public void successListener(HomeGlideDataTwo response) {

                HomeGlideAdapterTwo adapter = new HomeGlideAdapterTwo(getBaseContext());
                adapter.setData(response);
                mListView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

//        RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
//        StringRequest stringRequest = new StringRequest(mUrl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Gson gson = new Gson();
//                HomeGlideDataTwo data = gson.fromJson(response, HomeGlideDataTwo.class);
//
//                HomeGlideAdapterTwo adapter = new HomeGlideAdapterTwo(getBaseContext());
//                adapter.setData(data);
//                mListView.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        requestQueue.add(stringRequest);
    }


}
