package com.xiaobu.com.xiaobugift.fragment.category;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TableLayout;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryTabAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by xiaoBu on 16/11/22.
 * 分类Fragment 框架(Tab+ViewPager)
 */

public class CategoryFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> data;

    @Override
    public int setLayout() {
        return R.layout.fragment_category;
    }

    @Override
    public void initView(View view) {

        tabLayout = (TabLayout) view.findViewById(R.id.tab_category);
        viewPager = (ViewPager) view.findViewById(R.id.vp_category);

    }

    @Override
    public void initData() {

        data = new ArrayList<>();

        data.add(new CategoryStrategyFragment());
        data.add(new CategoryOneFragment());

        // 初始化适配器
        CategoryTabAdapter adapter = new CategoryTabAdapter(getChildFragmentManager(), data);
        // 绑定适配器
        viewPager.setAdapter(adapter);
        // TabLayout与ViewPager绑定
        tabLayout.setupWithViewPager(viewPager);
        // TabLayout设置字体颜色
        tabLayout.setTabTextColors(Color.argb(255, 50, 30, 30), Color.argb(255, 255, 45, 71));
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


    }
}
