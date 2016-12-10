package com.xiaobu.com.xiaobugift.fragment.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.main.SearchActivity;
import com.xiaobu.com.xiaobugift.adapter.home.HomePopGvAdapter;
import com.xiaobu.com.xiaobugift.adapter.home.HomeTabAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.home.HomeTabData;
import com.xiaobu.com.xiaobugift.constant.StaticConstant;
import com.xiaobu.com.xiaobugift.customize.MyGridView;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

import java.util.List;

/**
 * Created by xiaoBu on 16/11/22.
 * 首页Fragment--框架(Tab+ViewPager)
 */

public class HomeFragment extends BaseFragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<HomeTabData.DataBean.ChannelsBean> homeTabData;
    private ImageView ivHomePop;
    private MyGridView mGridView;
    private PopupWindow mPopupWindow;
    private RelativeLayout mRelativeLayout;
    private ImageView ivPopUp;
    private TextView tvSearch;

    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.vp_home);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_home);
        ivHomePop = (ImageView) view.findViewById(R.id.iv_home_pop);
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.rl_home_title);
        tvSearch = (TextView) view.findViewById(R.id.tv_search);
    }

    @Override
    public void initData() {

        // 调用解析的方法
        isResolve();
        isPop();
        isSearch();

    }

    private void isSearch() {

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

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

    /**
     * popWindow
     */
    private void isPop() {


        ivHomePop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPopupWindow = new PopupWindow(getContext());
                mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                mPopupWindow.setTouchable(true);
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setFocusable(true);
                mPopupWindow.setBackgroundDrawable(new BitmapDrawable());//去除边框

                View viewPop = LayoutInflater.from(getContext()).inflate(R.layout.view_pop, null);
                mPopupWindow.setContentView(viewPop);

                // 注意:这句话必须方法绑定视图代码下方
                mPopupWindow.showAsDropDown(mRelativeLayout);

                mGridView = (MyGridView) viewPop.findViewById(R.id.gv_pop);

                isGvForPop();//GirdView网络拉取数据并解析

                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (mPopupWindow.isShowing()) {
                            mPopupWindow.dismiss();
                            viewPager.setCurrentItem(position);
                        }
                    }
                });

                ivPopUp = (ImageView) viewPop.findViewById(R.id.iv_pop_up);
                ivPopUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mPopupWindow.isShowing()) {
                            mPopupWindow.dismiss();
                        }
                    }
                });

            }
        });

    }

    /**
     * GridView解析
     */
    private void isGvForPop() {

        NetHelper.MyRequest(StaticConstant.HOME_TAB_URL, HomeTabData.class, new NetListener<HomeTabData>() {
            @Override
            public void successListener(HomeTabData response) {
                HomePopGvAdapter adapter = new HomePopGvAdapter(getContext());
                adapter.setData(response);
                mGridView.setAdapter(adapter);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });


    }


}
