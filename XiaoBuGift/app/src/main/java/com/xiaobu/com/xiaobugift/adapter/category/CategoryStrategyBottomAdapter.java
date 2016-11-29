package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomData;

/**
 * Created by xiaou on 2016/11/28.
 * 分类Fragment--攻略Tab--尾部rv适配器
 */

public class CategoryStrategyBottomAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private CategoryStrategyBottomData data;

    public static final int TYPE_CATEGORY_BOTTOM_UP = 0;
    public static final int TYPE_CATEGORY_BOTTOM_MIDDLE = 1;
    public static final int TYPE_CATEGORY_BOTTOM_DOWN = 2;

    public CategoryStrategyBottomAdapter(Context context) {
        mContext = context;
    }

    public void setData(CategoryStrategyBottomData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_CATEGORY_BOTTOM_UP;
        } else if (position == 1) {
            return TYPE_CATEGORY_BOTTOM_MIDDLE;
        } else if (position == 2) {
            return TYPE_CATEGORY_BOTTOM_DOWN;
        } else
            return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 定义一个ViewHolder
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {

            case TYPE_CATEGORY_BOTTOM_UP:
                View viewUp = LayoutInflater.from(mContext).inflate(R.layout.item_category_bottom_up, parent, false);
                holder = new MyBottomUpViewHolder(viewUp);
                break;
            case TYPE_CATEGORY_BOTTOM_MIDDLE:
                View viewMid = LayoutInflater.from(mContext).inflate(R.layout.item_category_bottom_middle, parent, false);
                holder = new MyBottomMidViewHolder(viewMid);
                break;
            case TYPE_CATEGORY_BOTTOM_DOWN:
                View viewDown = LayoutInflater.from(mContext).inflate(R.layout.item_category_bottom_down, parent, false);
                holder = new MyBottomDownViewHolder(viewDown);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int type = getItemViewType(position);

        switch (type) {

            // 品类
            case TYPE_CATEGORY_BOTTOM_UP:

                // 定义我们的缓存类对象并强转holder
                MyBottomUpViewHolder holderUp = (MyBottomUpViewHolder) holder;

                if (data.getData().getChannel_groups().get(position).getId() == 5) {

                    holderUp.tvCgBottomUp.setText(data.getData().getChannel_groups().get(position).getName());
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(0).getChannels().get(0).getCover_image_url()).into(holderUp.ivCgBottomUpOne);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(0).getChannels().get(1).getCover_image_url()).into(holderUp.ivCgBottomUpTwo);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(0).getChannels().get(2).getCover_image_url()).into(holderUp.ivCgBottomUpThree);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(0).getChannels().get(3).getCover_image_url()).into(holderUp.ivCgBottomUpFour);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(0).getChannels().get(4).getCover_image_url()).into(holderUp.ivCgBottomUpFive);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(0).getChannels().get(5).getCover_image_url()).into(holderUp.ivCgBottomUpSix);
                }

                break;

            // 生活
            case TYPE_CATEGORY_BOTTOM_MIDDLE:

                MyBottomMidViewHolder holderMid = (MyBottomMidViewHolder) holder;

                if (data.getData().getChannel_groups().get(position).getId() == 1) {

                    holderMid.tvCgBottomMid.setText(data.getData().getChannel_groups().get(position).getName());
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(0).getCover_image_url()).into(holderMid.ivCgBottomMidOne);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(1).getCover_image_url()).into(holderMid.ivCgBottomMidTwo);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(2).getCover_image_url()).into(holderMid.ivCgBottomMidThree);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(3).getCover_image_url()).into(holderMid.ivCgBottomMidFour);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(4).getCover_image_url()).into(holderMid.ivCgBottomMidFive);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(5).getCover_image_url()).into(holderMid.ivCgBottomMidSix);
                }

                break;

            // 对象
            case TYPE_CATEGORY_BOTTOM_DOWN:

                MyBottomDownViewHolder holderDown = (MyBottomDownViewHolder) holder;

                if (data.getData().getChannel_groups().get(position).getId() == 2) {

                    holderDown.tvCgBottomDown.setText(data.getData().getChannel_groups().get(position).getName());
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(2).getChannels().get(0).getCover_image_url()).into(holderDown.ivCgBottomDownOne);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(2).getChannels().get(1).getCover_image_url()).into(holderDown.ivCgBottomDownTwo);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(2).getChannels().get(2).getCover_image_url()).into(holderDown.ivCgBottomDownThree);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(2).getChannels().get(3).getCover_image_url()).into(holderDown.ivCgBottomDownFour);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(2).getChannels().get(4).getCover_image_url()).into(holderDown.ivCgBottomDownFive);
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(2).getChannels().get(5).getCover_image_url()).into(holderDown.ivCgBottomDownSix);
                }

                break;
        }

    }

    @Override
    public int getItemCount() {
        return data != null ? data.getData().getChannel_groups().size() : 0;
    }

    /**
     * 内部类--缓存类
     * 行布局上
     */
    class MyBottomUpViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCgBottomUp;
        private ImageView ivCgBottomUpOne, ivCgBottomUpTwo, ivCgBottomUpThree, ivCgBottomUpFour, ivCgBottomUpFive, ivCgBottomUpSix;

        public MyBottomUpViewHolder(View itemView) {
            super(itemView);
            tvCgBottomUp = (TextView) itemView.findViewById(R.id.tv_category_bottom_up);
            ivCgBottomUpOne = (ImageView) itemView.findViewById(R.id.iv_category_bottom_up_one);
            ivCgBottomUpTwo = (ImageView) itemView.findViewById(R.id.iv_category_bottom_up_two);
            ivCgBottomUpThree = (ImageView) itemView.findViewById(R.id.iv_category_bottom_up_three);
            ivCgBottomUpFour = (ImageView) itemView.findViewById(R.id.iv_category_bottom_up_four);
            ivCgBottomUpFive = (ImageView) itemView.findViewById(R.id.iv_category_bottom_up_five);
            ivCgBottomUpSix = (ImageView) itemView.findViewById(R.id.iv_category_bottom_six);
        }
    }

    /**
     * 内部类--缓存类
     * 行布局中
     */
    class MyBottomMidViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCgBottomMid;
        private ImageView ivCgBottomMidOne, ivCgBottomMidTwo, ivCgBottomMidThree, ivCgBottomMidFour, ivCgBottomMidFive, ivCgBottomMidSix;

        public MyBottomMidViewHolder(View itemView) {
            super(itemView);
            tvCgBottomMid = (TextView) itemView.findViewById(R.id.tv_category_bottom_mid);
            ivCgBottomMidOne = (ImageView) itemView.findViewById(R.id.iv_category_bottom_mid_one);
            ivCgBottomMidTwo = (ImageView) itemView.findViewById(R.id.iv_category_bottom_mid_two);
            ivCgBottomMidThree = (ImageView) itemView.findViewById(R.id.iv_category_bottom_mid_three);
            ivCgBottomMidFour = (ImageView) itemView.findViewById(R.id.iv_category_bottom_mid_four);
            ivCgBottomMidFive = (ImageView) itemView.findViewById(R.id.iv_category_bottom_mid_five);
            ivCgBottomMidSix = (ImageView) itemView.findViewById(R.id.iv_category_bottom_mid_six);
        }
    }

    /**
     * 内部类--缓存类
     * 行布局下
     */
    class MyBottomDownViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCgBottomDown;
        private ImageView ivCgBottomDownOne, ivCgBottomDownTwo, ivCgBottomDownThree, ivCgBottomDownFour, ivCgBottomDownFive, ivCgBottomDownSix;

        public MyBottomDownViewHolder(View itemView) {
            super(itemView);
            tvCgBottomDown = (TextView) itemView.findViewById(R.id.tv_category_bottom_down);
            ivCgBottomDownOne = (ImageView) itemView.findViewById(R.id.iv_category_bottom_down_one);
            ivCgBottomDownTwo = (ImageView) itemView.findViewById(R.id.iv_category_bottom_down_two);
            ivCgBottomDownThree = (ImageView) itemView.findViewById(R.id.iv_category_bottom_down_three);
            ivCgBottomDownFour = (ImageView) itemView.findViewById(R.id.iv_category_bottom_down_four);
            ivCgBottomDownFive = (ImageView) itemView.findViewById(R.id.iv_category_bottom_down_five);
            ivCgBottomDownSix = (ImageView) itemView.findViewById(R.id.iv_category_bottom_down_six);
        }
    }
}
