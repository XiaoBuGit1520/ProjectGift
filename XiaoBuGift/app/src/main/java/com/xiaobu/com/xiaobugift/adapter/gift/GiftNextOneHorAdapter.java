package com.xiaobu.com.xiaobugift.adapter.gift;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.gift.GiftNextOneBodyData;

/**
 * Created by xiaoBu on 16/12/6.
 */

public class GiftNextOneHorAdapter extends RecyclerView.Adapter<GiftNextOneHorAdapter.MyHorViewHolder> {

    private Context mContext;
    private GiftNextOneBodyData data;
    private static int mPos;

    public GiftNextOneHorAdapter(Context context) {
        mContext = context;
    }

    public void setData(GiftNextOneBodyData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyHorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 加载行布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gift_next_one_rv_middle_hor, parent, false);

        MyHorViewHolder holder = new MyHorViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHorViewHolder holder, int position) {

        Picasso.with(mContext).load(data.getData().getRecommend_posts().get(position).getCover_image_url()).into(holder.ivHorCoverImageUrl);

        //mPos = getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.getData().getRecommend_posts().size() : 0;
    }

//    public static int sendPos() {
//        return mPos;
//    }

    /**
     * 缓存类
     */
    class MyHorViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivHorCoverImageUrl;

        private MyHorViewHolder(View itemView) {
            super(itemView);
            ivHorCoverImageUrl = (ImageView) itemView.findViewById(R.id.iv_gift_next_one_mid_hor);
        }
    }
}
