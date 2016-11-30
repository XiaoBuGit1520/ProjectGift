package com.xiaobu.com.xiaobugift.fragment.category;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryStrategyAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomData;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyHeadData;

/**
 * Created by xiaobu on 2016/11/27.
 * 榜单Fragment--攻略Tab--All
 */

public class CategoryStrategyFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private CategoryStrategyAdapter mAdapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_category_strategy;
    }

    @Override
    public void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_category_strategy);

    }

    @Override
    public void initData() {
        mAdapter = new CategoryStrategyAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        isResolveHead();
        isResolveBottom();


    }

    /**
     * 头部横向rv数据解析
     */
    private void isResolveHead() {

        String url1 = "http://api.liwushuo.com/v2/columns";

        RequestQueue mRequestQueue = Volley.newRequestQueue(getContext());
        StringRequest mStringRequest = new StringRequest(url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                CategoryStrategyHeadData data = gson.fromJson(response, CategoryStrategyHeadData.class);

                /* 适配器 */
                mAdapter.setDataHead(data);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(mStringRequest);
    }

    /**
     * 尾部三布局数据解析
     */
    private void isResolveBottom() {

        String url2 = "http://api.liwushuo.com/v2/channel_groups/all";

        RequestQueue mRequestQueue = Volley.newRequestQueue(getContext());
        StringRequest mStringRequest = new StringRequest(url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                CategoryStrategyBottomData data = gson.fromJson(response, CategoryStrategyBottomData.class);

                /* 适配器 */
                mAdapter.setDataBottom(data);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(mStringRequest);
    }
}
