package com.xiaobu.com.xiaobugift.fragment.gift;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftTabAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.gift.GiftTabData;

/**
 * Created by xiaoBu on 16/11/22.
 * 榜单Fragment 框架及Tab页
 */
public class GiftFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public int setLayout() {
        return R.layout.fragment_gift;
    }

    @Override
    public void initView(View view) {

        tabLayout = (TabLayout) view.findViewById(R.id.tab_gift);
        viewPager = (ViewPager) view.findViewById(R.id.vp_gift);
    }

    @Override
    public void initData() {

        isResolve();

    }

    String url = "http://api.liwushuo.com/v2/ranks_v2/ranks";

    private void isResolve() {

        /* 使用Volley */
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                /* 使用Gson */
                Gson gson = new Gson();
                GiftTabData data = gson.fromJson(response, GiftTabData.class);

                /* 适配器 */
                GiftTabAdapter adapter = new GiftTabAdapter(getChildFragmentManager());
                adapter.setGiftTabData(data.getData().getRanks());
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                // TabLayout设置字体颜色
                tabLayout.setTabTextColors(Color.argb(255, 50, 30, 30), Color.argb(255, 255, 45, 71));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}
