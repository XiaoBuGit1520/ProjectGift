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

// 注释注释注释
// 啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
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

            case TYPE_CATEGORY_BOTTOM_UP:

                // 定义我们的缓存类对象并强转holder
                MyBottomUpViewHolder holderUp = (MyBottomUpViewHolder) holder;

                if (data.getData().getChannel_groups().get(position).getId() == 5) {

                    holderUp.tvCgBottomUp.setText(data.getData().getChannel_groups().get(position).getName());
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(0).getChannels().get(position).getCover_image_url()).into(holderUp.ivCgBottomUp);
                }

                break;

            case TYPE_CATEGORY_BOTTOM_MIDDLE:

                MyBottomMidViewHolder holderMid = (MyBottomMidViewHolder) holder;

                if (data.getData().getChannel_groups().get(position).getId() == 1) {

                    holderMid.tvCgBottomMid.setText(data.getData().getChannel_groups().get(1).getName());
                    Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(position).getCover_image_url()).into(holderMid.ivCgBottomMid);

                }

                break;

            case TYPE_CATEGORY_BOTTOM_DOWN:

                MyBottomDownViewHolder holderDown = (MyBottomDownViewHolder) holder;


                holderDown.tvCgBottomDown.setText(data.getData().getChannel_groups().get(2).getName());
                Picasso.with(mContext).load(data.getData().getChannel_groups().get(2).getChannels().get(position).getCover_image_url()).into(holderDown.ivCgBottomDown);

                break;
        }

    }

    @Override
    public int getItemCount() {
        //return data != null ? data.getData().getChannel_groups().size() : 0;
        return 3;
    }

    /**
     * 内部类--缓存类
     * 行布局上
     */
    class MyBottomUpViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCgBottomUp;
        private ImageView ivCgBottomUp;

        public MyBottomUpViewHolder(View itemView) {
            super(itemView);
            tvCgBottomUp = (TextView) itemView.findViewById(R.id.tv_category_bottom_up);
            ivCgBottomUp = (ImageView) itemView.findViewById(R.id.iv_category_bottom_up);
        }
    }

    /**
     * 内部类--缓存类
     * 行布局中
     */
    class MyBottomMidViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCgBottomMid;
        private ImageView ivCgBottomMid;

        public MyBottomMidViewHolder(View itemView) {
            super(itemView);
            tvCgBottomMid = (TextView) itemView.findViewById(R.id.tv_category_bottom_mid);
            ivCgBottomMid = (ImageView) itemView.findViewById(R.id.iv_category_bottom_mid);
        }
    }

    /**
     * 内部类--缓存类
     * 行布局下
     */
    class MyBottomDownViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCgBottomDown;
        private ImageView ivCgBottomDown;

        public MyBottomDownViewHolder(View itemView) {
            super(itemView);
            tvCgBottomDown = (TextView) itemView.findViewById(R.id.tv_category_bottom_down);
            ivCgBottomDown = (ImageView) itemView.findViewById(R.id.iv_category_bottom_down);
        }
    }
}
