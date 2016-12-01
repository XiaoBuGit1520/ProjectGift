package com.xiaobu.com.xiaobugift.fragment.gift;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftTabAdapter;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftUseAdapterUpdate;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.gift.GiftUseData;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/11/25.
 * 榜单---复用的Fragment
 */
// IllegalStateException非法语句异常
public class GiftUseFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private String path;

    @Override
    public int setLayout() {
        return R.layout.fragment_giftuse;
    }

    @Override
    public void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_gift);

    }

    @Override
    public void initData() {

        isBundle();
        isResolve();

    }

    /**
     * 接收传值
     */
    private void isBundle() {

        Bundle bundle = getArguments();

        String msg = bundle.get("key").toString();

        // 网址拼接
        path = "http://api.liwushuo.com/v2/ranks_v3/ranks/" + msg + "?limit=20&offset=0";
    }

    /**
     * 请求网络数据并解析--主要数据
     * (Volley + Gson)
     */
    private void isResolve() {

//        /* 使用Volley */
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                /* 使用Gson */
//                Gson gson = new Gson();
//                GiftUseData data = gson.fromJson(response, GiftUseData.class);
//
//                /* 适配器 */
//                //GiftUseAdapter adapter = new GiftUseAdapter(getContext());
//                final GiftUseAdapterUpdate adapter = new GiftUseAdapterUpdate(getContext());
//                adapter.setData(data);
//                mRecyclerView.setAdapter(adapter);
//
//                final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
//
//                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                    @Override
//                    public int getSpanSize(int position) {
//                        return (adapter.isHeadView(position) || adapter.isBottomView(position)) ? gridLayoutManager.getSpanCount() : 1;
//                    }
//                });
//
//                mRecyclerView.setLayoutManager(gridLayoutManager);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(stringRequest);

        NetHelper.MyRequest(path, GiftUseData.class, new NetListener<GiftUseData>() {
            @Override
            public void successListener(GiftUseData response) {

                final GiftUseAdapterUpdate adapter = new GiftUseAdapterUpdate(getContext());
                adapter.setData(response);
                mRecyclerView.setAdapter(adapter);

                final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return (adapter.isHeadView(position) || adapter.isBottomView(position)) ? gridLayoutManager.getSpanCount() : 1;
                    }
                });

                mRecyclerView.setLayoutManager(gridLayoutManager);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }

    /**
     * newInstance()
     *
     * @return
     */
    public static GiftUseFragment newInstance(int position) {

        Bundle args = new Bundle();

        args.putInt("key", position);

        String message = GiftTabAdapter.getMessage(position);
        args.putString("key", message);

        GiftUseFragment fragment = new GiftUseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
