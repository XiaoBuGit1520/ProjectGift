package com.xiaobu.com.xiaobugift.fragment.gift;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.gift.GiftNextActivity;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftClick;
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

public class GiftUseFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private String path;
    private GiftUseData data;

    @Override
    public int setLayout() {
        return R.layout.fragment_gift_use;
    }

    @Override
    public void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_gift);

    }

    @Override
    public void initData() {

        isBundle();//接收传值
        isResolve();//解析

    }

    /**
     * 接收传值
     * 复用
     */
    private void isBundle() {

        Bundle bundle = getArguments();

        String msg = bundle.get("key").toString();

        // 网址拼接
        path = "http://api.liwushuo.com/v2/ranks_v3/ranks/" + msg + "?limit=20&offset=0";
    }

    /**
     * 请求网络数据并解析--主要数据
     * (Volley二次封装)
     */
    private void isResolve() {

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

                data = new GiftUseData();//初始化
                data = response;//赋值

                /*** RecyclerView的监听事件 ***/

                adapter.setGiftClick(new GiftClick() {
                    @Override
                    public void myGiftListener(int pos) {

                        // 第一张图(头布局)不可被点击
                        if (pos != 0) {

                            String id = data.getData().getItems().get(pos - 1).getId() + "";
                            Intent intent = new Intent(getContext(), GiftNextActivity.class);
                            intent.putExtra("id", id);
                            startActivity(intent);
                        }
                    }
                });
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    /**
     * newInstance()
     * 复用
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
