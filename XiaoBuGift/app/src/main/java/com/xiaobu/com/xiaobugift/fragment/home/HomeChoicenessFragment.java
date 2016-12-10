package com.xiaobu.com.xiaobugift.fragment.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.home.HomeGlideActivity;
import com.xiaobu.com.xiaobugift.activity.home.HomeGridActivity;
import com.xiaobu.com.xiaobugift.activity.home.HomeChoiceWebActivity;
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
 * 首页--精选Tab--全部数据
 */

public class HomeChoicenessFragment extends BaseFragment {

    private ListView listView;
    private GridView gridView;
    private View headView;//头布局
    private Banner banner;//轮播图

    private HomeGlideData mHomeGlideData;//定义轮播图实体类
    private HomeGridData mHomeGridData;//定义六宫格实体类
    private HomeChoicenessData mHomeChoicenessData;//定义主数据实体类
    private ArrayList<String> pics;

    @Override
    public int setLayout() {
        return R.layout.fragment_homechoiceness;
    }

    @Override
    public void initView(View view) {

        listView = (ListView) view.findViewById(R.id.lv_home_choice);

        // 注入头布局
        headView = LayoutInflater.from(getContext()).inflate(R.layout.item_home_choiceness_head_all, null);
        // 使用headView绑定banner组件
        banner = (Banner) headView.findViewById(R.id.banner_home_choice);
        // ListView加入头布局
        listView.addHeaderView(headView);
        // 注意 需要用headView进行绑定
        gridView = (GridView) headView.findViewById(R.id.gv_home_choice);

    }

    @Override
    public void initData() {

        // 轮播图的解析方法
        isResolve();
        // 轮播图的banner
        isGlideResolve();
        // 六宫格
        isGridViewResolve();

    }

    /**
     * 六宫格 拉取网络数据并解析
     * (Volley二次封装)
     */
    private void isGridViewResolve() {

        mHomeGridData = new HomeGridData();//初始化

        // 参数:url, 实体类.class, new NetListener<实体类>() {...
        NetHelper.MyRequest(StaticConstant.HOME_CHOICE_GRID, HomeGridData.class, new NetListener<HomeGridData>() {
            @Override
            public void successListener(HomeGridData response) {
                /* 适配器 */
                HomeGridAdapter adapter = new HomeGridAdapter(getContext());
                // response替代之前的data
                adapter.setData(response);
                gridView.setAdapter(adapter);

                mHomeGridData = response;//将解析后的数据赋值给...
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

        /* GridView点击事件 */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(), HomeGridActivity.class);

                String idGrid = mHomeGridData.getData().getSecondary_banners().get(position).getTarget_url();//六宫格id

                intent.putExtra("keyGrid", idGrid);

                startActivity(intent);
            }
        });

    }

    /**
     * 轮播图 拉取网络数据并解析
     * (Volley二次封装)
     */
    private void isGlideResolve() {

        pics = new ArrayList<>();
        mHomeGlideData = new HomeGlideData();//初始化即将被赋值的数据

        NetHelper.MyRequest(StaticConstant.HOME_CHOICE_GLIDE, HomeGlideData.class, new NetListener<HomeGlideData>() {
            @Override
            public void successListener(HomeGlideData response) {

                for (int i = 0; i < response.getData().getBanners().size(); i++) {

                    pics.add(response.getData().getBanners().get(i).getImage_url());
                    // 获取到解析后的数据
                    mHomeGlideData = response;
                }

                // 写在别的地方可能会导致空指针异常
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

        /* banner设置监听 */
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {

                /* 传值id到新的Activity */
                Intent intent = new Intent(getContext(), HomeGlideActivity.class);

                // 位置不匹配:position-1
                String idGlide = mHomeGlideData.getData().getBanners().get(position - 1).getTarget_id() + "";
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
     * (Volley二次封装)
     */
    private void isResolve() {

        NetHelper.MyRequest(StaticConstant.HOME_CHOICE_URL, HomeChoicenessData.class, new NetListener<HomeChoicenessData>() {
            @Override
            public void successListener(HomeChoicenessData response) {
                HomeChoicenessAdapter adapter = new HomeChoicenessAdapter(getContext());
                adapter.setData(response);
                listView.setAdapter(adapter);

                mHomeChoicenessData = response;//将解析后的数据赋值

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
        /* ListView点击事件 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String idChoice = mHomeChoicenessData.getData().getItems().get(position - 1).getId() + "";
                Intent intent = new Intent(getContext(), HomeChoiceWebActivity.class);
                intent.putExtra("keyChoice", idChoice);
                startActivity(intent);

            }
        });
    }
}
