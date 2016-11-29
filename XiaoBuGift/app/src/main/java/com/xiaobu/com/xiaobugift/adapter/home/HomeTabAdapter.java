package com.xiaobu.com.xiaobugift.adapter.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xiaobu.com.xiaobugift.bean.home.HomeTabData;
import com.xiaobu.com.xiaobugift.fragment.home.HomeChoicenessFragment;
import com.xiaobu.com.xiaobugift.fragment.home.HomeUseFragment;

import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */

public class HomeTabAdapter extends FragmentStatePagerAdapter {

    private static List<HomeTabData.DataBean.ChannelsBean> homeTabData;

    public HomeTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setHomeTabData(List<HomeTabData.DataBean.ChannelsBean> homeTabData) {
        this.homeTabData = homeTabData;
        notifyDataSetChanged();
    }

    /**
     * 根据不同的position获取到不同的Fragment
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {

        if (position == 0) {

            return new HomeChoicenessFragment();

        }

        return HomeUseFragment.newInstance(position);

    }

    @Override
    public int getCount() {
        return homeTabData != null ? homeTabData.size() : 0;
    }

    /**
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return homeTabData.get(position).getName();
    }

    /**
     * @param position
     * @return
     */
    public static String getMessage(int position) {

        // Log.d("HomeTabAdapter", "aaa");
        return homeTabData.get(position).getId() + "";
    }


}
