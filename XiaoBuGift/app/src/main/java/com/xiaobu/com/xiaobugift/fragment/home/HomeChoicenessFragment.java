package com.xiaobu.com.xiaobugift.fragment.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.HomeGlideActivity;
import com.xiaobu.com.xiaobugift.adapter.home.HomeChoicenessAdapter;
import com.xiaobu.com.xiaobugift.adapter.home.HomeGridAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.home.HomeChoicenessData;
import com.xiaobu.com.xiaobugift.bean.home.HomeGlideData;
import com.xiaobu.com.xiaobugift.bean.home.HomeGridData;
import com.xiaobu.com.xiaobugift.constant.StaticConstant;
import com.xiaobu.com.xiaobugift.utils.glide.GlideImageLoader;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;

/**
 * Created by xiaoBu on 16/11/23.
 * 首页---精选Tab
 */

public class HomeChoicenessFragment extends BaseFragment {

    private ListView listView;
    private GridView gridView;
    private View headView;
    private Banner banner;

    private HomeGlideData mHomeGlideData;
    private ArrayList<String> pics;
    private String idGlide;

    @Override
    public int setLayout() {
        return R.layout.fragment_homechoiceness;
    }

    @Override
    public void initView(View view) {

        listView = (ListView) view.findViewById(R.id.lv_home_choice);

        // 注入头布局
        headView = LayoutInflater.from(getContext()).inflate(R.layout.item_home_choiceness_head, null);
        // 使用headView绑定banner组件
        banner = (Banner) headView.findViewById(R.id.banner_home_choice);
        // ListView加入头布局
        listView.addHeaderView(headView);
        // 注意 需要用headView进行绑定
        gridView = (GridView) headView.findViewById(R.id.gv_home_choice);

    }

    @Override
    public void initData() {

        mHomeGlideData = new HomeGlideData();
        pics = new ArrayList<>();

        // 调用轮播图的解析方法
        isResolve();
        // 调用轮播图的banner
        isGlideResolve();
        // 六宫格
        isGridViewResolve();

    }

    /**
     * 六宫格 拉取网络数据并解析
     */
    private void isGridViewResolve() {

        //NetHelper.MyRequest(StaticConstant);

        /* 使用Volley */
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(StaticConstant.HOME_CHOICE_GRID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                HomeGridData data = gson.fromJson(response, HomeGridData.class);
                Log.d("HomeChoicenessFragment", "data:" + data);

                /* 适配器 */
                HomeGridAdapter adapter = new HomeGridAdapter(getContext());
                adapter.setData(data);
                gridView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    /**
     * 轮播图 拉取网络数据并解析
     */
    private void isGlideResolve() {

        NetHelper.MyRequest(StaticConstant.HOME_CHOICE_GLIDE, HomeGlideData.class, new NetListener<HomeGlideData>() {
            @Override
            public void successListener(HomeGlideData response) {

                for (int i = 0; i < response.getData().getBanners().size(); i++) {

                    pics.add(response.getData().getBanners().get(i).getImage_url());
                    mHomeGlideData = response;
                }

                // 写在别的地方可能会导致空指针
                isGlideBanner(pics);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    /**
     * 轮播图 设置并开启(利用Banner依赖)
     */
    private void isGlideBanner(ArrayList<String> data) {

        // 设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        // 设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        // 设置图片集合
        banner.setImages(data);
        // 设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        // 设置标题集合 (当banner样式有显示title)
        // banner.setBannerTitles(Arrays.asList("Title", "Title1", "Title2"));
        // 设置自动轮播 默认为true
        banner.isAutoPlay(true);
        // 设置轮播时间
        banner.setDelayTime(2000);
        // 设置指示器位置 (当banner模式中有指示器时)
        banner.setIndicatorGravity(BannerConfig.CENTER);

        // 设置监听
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

                Intent intent = new Intent(getContext(), HomeGlideActivity.class);

                idGlide = mHomeGlideData.getData().getBanners().get(position - 1).getTarget_id() + "";
                Log.d("HomeChoicenessFragment", idGlide);

                intent.putExtra("keyGlide", idGlide);

                startActivity(intent);
            }
        });

        // 开启banner
        banner.start();

    }

    /**
     * 主内容 网络请求与解析
     */
    private void isResolve() {

        /* 使用Volley */
        // 1.创建请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        // 2.网络请求(网址, 网络数据获取成功时的回调, 网络数据获取失败时的回调)
        StringRequest stringRequest = new StringRequest(StaticConstant.HOME_CHOICE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                /* 使用Gson */
                Gson gson = new Gson();
                HomeChoicenessData data = gson.fromJson(response, HomeChoicenessData.class);

                /* 适配器 */
                HomeChoicenessAdapter adapter = new HomeChoicenessAdapter(getContext());
                adapter.setData(data);
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
