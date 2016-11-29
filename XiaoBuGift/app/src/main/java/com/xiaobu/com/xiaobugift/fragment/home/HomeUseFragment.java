package com.xiaobu.com.xiaobugift.fragment.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.home.HomeTabAdapter;
import com.xiaobu.com.xiaobugift.adapter.home.HomeUseAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.home.HomeUseData;

import java.util.List;

/**
 * Created by xiaoBu on 16/11/23.
 * 首页---复用的Fragment模板
 */
public class HomeUseFragment extends BaseFragment {

    private ListView listView;
    private HomeUseAdapter adapter;
    private List<HomeUseData.DataBean.ItemsBean> data;
    private String path;

    @Override
    public int setLayout() {
        return R.layout.fragment_homeuse;
    }


    @Override
    public void initView(View view) {

        listView = (ListView) view.findViewById(R.id.lv_home_use);
    }

    @Override
    public void initData() {

        isBundle();
        isResolve();
    }


    /**
     * newInstance() Fragment复用方法
     * 传值操作
     *
     * @param position
     * @return
     */
    public static HomeUseFragment newInstance(int position) {

        Bundle args = new Bundle();

        args.putInt("key", position);

        String message = HomeTabAdapter.getMessage(position);
        args.putString("key", message);

        HomeUseFragment fragment = new HomeUseFragment();
        fragment.setArguments(args);
        return fragment;

    }

    /**
     * 接收传值(Bundle)
     */
    private void isBundle() {

        Bundle bundle = getArguments();

        String msg = bundle.get("key").toString();

        // 网址拼接
        path = "http://api.liwushuo.com/v2/channels/" + msg + "/items_v2?gender=1&limit=20&offset=0&generation=2";

    }

    /**
     * 请求网络数据并解析--首页复用的数据
     * (Volley + Gson)
     */
    private void isResolve() {

        /* 使用Volley */
        // 1.创建请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        // 2.网络请求 (网址, 网络数据获取成功时的回调, 网络数据获取失败时的回调)
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                /* 使用Gson */
                Gson gson = new Gson();
                HomeUseData useBean = gson.fromJson(response, HomeUseData.class);
                data = useBean.getData().getItems();

                /* 适配器 */
                // 初始化适配器
                adapter = new HomeUseAdapter(getContext());
                // 给适配器(BaseAdapter)加入解析后的数据
                adapter.setData(data);
                // 绑定适配器
                listView.setAdapter(adapter);

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



