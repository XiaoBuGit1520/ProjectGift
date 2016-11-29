package com.xiaobu.com.xiaobugift.adapter.category;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by xiaou on 2016/11/27.
 * 分类Fragment--Tab/ViewPager--适配器
 */

public class CategoryTabAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> data;
    private String[] title = {"攻略", "单品"};

    public CategoryTabAdapter(FragmentManager fm, ArrayList<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data != null ? data.get(position) : null;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    /**
     * getPageTitle()
     * CharSequence:字符序列
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
