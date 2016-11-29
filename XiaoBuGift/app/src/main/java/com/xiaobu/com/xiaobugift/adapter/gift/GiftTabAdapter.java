package com.xiaobu.com.xiaobugift.adapter.gift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xiaobu.com.xiaobugift.bean.gift.GiftTabData;
import com.xiaobu.com.xiaobugift.fragment.gift.GiftUseFragment;

import java.util.List;

/**
 * Created by dllo on 16/11/25.
 */

public class GiftTabAdapter extends FragmentStatePagerAdapter {


    private static List<GiftTabData.DataBean.RanksBean> giftTabData;

    public GiftTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setGiftTabData(List<GiftTabData.DataBean.RanksBean> giftTabData) {
        GiftTabAdapter.giftTabData = giftTabData;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return GiftUseFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return giftTabData != null ? giftTabData.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return giftTabData.get(position).getName();
    }

    public static String getMessage(int position) {

        return giftTabData.get(position).getId() + "";
    }
}
