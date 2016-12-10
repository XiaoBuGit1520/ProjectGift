package com.xiaobu.com.xiaobugift.fragment.gift;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.gift.GiftNextActivity;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftNextOneAdapter;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftNextOneVpAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.gift.GiftNextOneBodyData;
import com.xiaobu.com.xiaobugift.bean.gift.GiftNextOneHeadData;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/12/3.
 * 榜单Fragment--二级界面--单品Tab
 */

public class GiftNextOneFragment extends BaseFragment {

    private ViewPager mViewPager;
    private String urlHead;
    private String urlBody;
    //private ArrayList<View> data;

    private RecyclerView mRecyclerView;
    private TextView tvHeadShortDescription, tvHeadName, tvHeadPrice, tvHeadLikesCount, tvHeadDescription;

    @Override
    public int setLayout() {
        return R.layout.fragment_gift_next_one;
    }

    @Override
    public void initView(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.vp_gift_next_one);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_gift_next_one);

        tvHeadShortDescription = (TextView) view.findViewById(R.id.tv_gift_next_one_head_short_description);
        tvHeadName = (TextView) view.findViewById(R.id.tv_gift_next_one_head_name);
        tvHeadPrice = (TextView) view.findViewById(R.id.tv_gift_next_one_head_price);
        tvHeadLikesCount = (TextView) view.findViewById(R.id.tv_gift_next_one_head_likes_count);
        tvHeadDescription = (TextView) view.findViewById(R.id.tv_gift_next_one_head_description);

    }

    @Override
    public void initData() {

        String id = GiftNextActivity.id();
        Log.d("GiftNextOneFragment", id);

//        data = new ArrayList<>();

//        View viewOne = LayoutInflater.from(getContext()).inflate(R.layout.view_gift_next_vp, null);
//        View viewTwo = LayoutInflater.from(getContext()).inflate(R.layout.view_gift_next_vp, null);
//        View viewThree = LayoutInflater.from(getContext()).inflate(R.layout.view_gift_next_vp, null);

//        data.add(viewOne);
//        data.add(viewTwo);
//        data.add(viewThree);

        urlHead = "http://api.liwushuo.com/v2/items/" + id;
        urlBody = "http://api.liwushuo.com/v2/items/" + id + "/recommend?num=20&post_num=5";

        isVpResolve();//头部vp图片解析
        //isHeaderResolve();//头部tv解析
        isBottomResolve();//尾部解析

    }

    /**
     * ViewPager图片解析
     * 下方TextView解析
     */
    private void isVpResolve() {

        NetHelper.MyRequest(urlHead, GiftNextOneHeadData.class, new NetListener<GiftNextOneHeadData>() {
            @Override
            public void successListener(GiftNextOneHeadData response) {

                tvHeadShortDescription.setText(response.getData().getShort_description());
                tvHeadName.setText(response.getData().getName());
                tvHeadPrice.setText(response.getData().getPrice());
                tvHeadLikesCount.setText(response.getData().getLikes_count() + "");
                tvHeadDescription.setText(response.getData().getDescription());

                // 初始化适配器
                GiftNextOneVpAdapter adapter = new GiftNextOneVpAdapter(getContext());
                // 设置数据
                adapter.setData(response);
                // 绑定适配器
                mViewPager.setAdapter(adapter);

                String url = response.getData().getUrl();
                String idComment = response.getData().getId() + "";

                /* 发送广播 */
                Intent intentBR = new Intent(getContext().getPackageName() + ".MyBR");
                intentBR.putExtra("url", url);
                intentBR.putExtra("idComment", idComment);
                getContext().sendBroadcast(intentBR);
                //LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intentBR);
                Log.d("GiftNextOneFragment1", url);
                Log.d("GiftNextOneFragment1", idComment);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }

    /**
     * 中部横向rv解析
     * 尾部rv解析
     */
    private void isBottomResolve() {

        NetHelper.MyRequest(urlBody, GiftNextOneBodyData.class, new NetListener<GiftNextOneBodyData>() {
            @Override
            public void successListener(GiftNextOneBodyData response) {

                // 初始化适配器
                final GiftNextOneAdapter adapterB = new GiftNextOneAdapter(getContext());
                // 设置数据
                adapterB.setDataBody(response);
                // 绑定适配器
                mRecyclerView.setAdapter(adapterB);
                // 设置Manager
                final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return (adapterB.isMiddleView(position) ? gridLayoutManager.getSpanCount() : 1);
                    }
                });

                mRecyclerView.setLayoutManager(gridLayoutManager);

                /* 接收由GiftNextOneAdapter传来的pos */
                //int pos = GiftNextOneAdapter.sendPos();

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }

}
