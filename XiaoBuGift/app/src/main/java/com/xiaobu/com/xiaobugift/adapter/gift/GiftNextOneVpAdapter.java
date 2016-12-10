package com.xiaobu.com.xiaobugift.adapter.gift;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.gift.GiftNextOneHeadData;

/**
 * Created by xiaoBu on 16/12/5.
 * 榜单--二级界面--单品--上方vp适配器
 */

public class GiftNextOneVpAdapter extends PagerAdapter {

    //private String[] url;
    //private ArrayList<View> data;
    private Context mContext;
    private GiftNextOneHeadData data;

    public GiftNextOneVpAdapter(Context context) {
        mContext = context;
    }

    public void setData(GiftNextOneHeadData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    /**
     * 获取视图的数量
     *
     * @return
     */
    @Override
    public int getCount() {
        return data != null ? data.getData().getImage_urls().size() : 0;
    }

    /**
     * 判断视图与对象的关系
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 添加页卡
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        View view = data.get(position);//获取与position相对应的视图
//        container.addView(view);//把视图加入到组中
//        return view;//返回视图,让其显示出来
        //ImageView ivVp = new ImageView(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_gift_next_vp, container, false);
        ImageView mImageView = (ImageView) view.findViewById(R.id.iv_gift_next_vp);
        //Picasso.with(mContext).load(url[position]).into(ivVp);
        Picasso.with(mContext).load(data.getData().getImage_urls().get(position)).into(mImageView);
        container.addView(view);
        return view;
    }

    /**
     * 删除页卡
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        View view = data.get(position);
//        container.removeView(view);
        container.removeView((View) object);
    }
}
