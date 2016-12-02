package com.xiaobu.com.xiaobugift.adapter.gift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xiaobu.com.xiaobugift.bean.gift.GiftTabData;
import com.xiaobu.com.xiaobugift.fragment.gift.GiftUseFragment;

/**
 * Created by xiaoBu on 16/11/25.
 * 榜单Fragment--Tab标题--适配器
 */

public class GiftTabAdapter extends FragmentStatePagerAdapter {


    //private static List<GiftTabData.DataBean.RanksBean> giftTabData;
    private static GiftTabData data;

    public GiftTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(GiftTabData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return GiftUseFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getRanks().size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.getData().getRanks().get(position).getName();
    }

    public static String getMessage(int position) {

        return data.getData().getRanks().get(position).getId() + "";
    }
}
