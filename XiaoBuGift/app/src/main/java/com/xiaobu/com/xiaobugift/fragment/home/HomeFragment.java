package com.xiaobu.com.xiaobugift.fragment.home;

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
import com.xiaobu.com.xiaobugift.adapter.home.HomeTabAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.home.HomeTabData;
import com.xiaobu.com.xiaobugift.constant.StaticConstant;

import java.util.List;

/**
 * Created by xiaoBu on 16/11/22.
 * 首页Fragment--框架(Tab+ViewPager)
 */

public class HomeFragment extends BaseFragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<HomeTabData.DataBean.ChannelsBean> homeTabData;

    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.vp_home);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_home);
    }

    @Override
    public void initData() {

        // 调用解析的方法
        isResolve();

    }

    /**
     * 解析部分(Tab标题)
     */
    private void isResolve() {

         /* 使用Volley */
        // 1.创建请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        // 2.网络请求 (网址, 网络数据获取成功时的回调, 网络数据获取失败时的回调)
        StringRequest stringRequest = new StringRequest(StaticConstant.HOME_TAB_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                /* 使用Gson */
                Gson gson = new Gson();
                HomeTabData bean = gson.fromJson(response, HomeTabData.class);
                homeTabData = bean.getData().getChannels();

                /* 适配器 */
                // 初始化适配器
                HomeTabAdapter homeTabAdapter = new HomeTabAdapter(getChildFragmentManager());
                // 给适配器(FragmentPagerAdapter)加入解析出的数据
                homeTabAdapter.setHomeTabData(homeTabData);
                // 绑定适配器
                viewPager.setAdapter(homeTabAdapter);
                // ViewPager与TabLayout相关联
                tabLayout.setupWithViewPager(viewPager);
                // TabLayout设置字体颜色
                tabLayout.setTabTextColors(Color.argb(255, 50, 30, 30), Color.argb(255, 255, 45, 71));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // 3.将网络数据加入到请求队列之中
        requestQueue.add(stringRequest);

    }


}
