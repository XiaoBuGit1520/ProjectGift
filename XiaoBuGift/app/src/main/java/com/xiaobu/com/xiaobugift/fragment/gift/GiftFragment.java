package com.xiaobu.com.xiaobugift.fragment.gift;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftTabAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.gift.GiftTabData;
import com.xiaobu.com.xiaobugift.constant.StaticConstant;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

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

        isResolve();//解析Tab标题

    }

    /**
     * 拉取网络数据并解析
     * (Tab标题)
     */
    private void isResolve() {

        NetHelper.MyRequest(StaticConstant.GIFT_TAB_URL, GiftTabData.class, new NetListener<GiftTabData>() {
            @Override
            public void successListener(GiftTabData response) {

                /* 适配器 */
                GiftTabAdapter adapter = new GiftTabAdapter(getChildFragmentManager());
                adapter.setData(response);
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                // TabLayout设置字体颜色
                tabLayout.setTabTextColors(Color.argb(255, 50, 30, 30), Color.argb(255, 255, 45, 71));
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }
}
