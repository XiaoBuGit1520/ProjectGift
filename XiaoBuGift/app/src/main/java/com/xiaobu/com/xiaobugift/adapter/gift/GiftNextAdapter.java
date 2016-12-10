package com.xiaobu.com.xiaobugift.adapter.gift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by xiaoBu on 16/12/3.
 * 榜单Fragment--二级界面--Tab+vp适配器
 */

public class GiftNextAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> data;
    private String[] title = {"单品", "详情", "评论"};

    public GiftNextAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(ArrayList<Fragment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
