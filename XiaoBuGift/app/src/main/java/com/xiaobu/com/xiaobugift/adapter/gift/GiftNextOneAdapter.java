package com.xiaobu.com.xiaobugift.adapter.gift;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.gift.GiftNextOneBodyData;

/**
 * Created by xiaoBu on 2016/12/5.
 * 榜单Fragment--二级页面--单品Tab--三布局rv适配器
 */

public class GiftNextOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private GiftNextOneBodyData dataBody;

    private Context mContext;

    private static int mPos;//定义静态pos

    public GiftNextOneAdapter(Context context) {
        mContext = context;
    }

    public void setDataBody(GiftNextOneBodyData dataBody) {
        this.dataBody = dataBody;
        notifyDataSetChanged();
    }

    // item类型
    //public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_MIDDLE = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;

    //private int mHeaderCount = 1;//头部View的个数(占用item的数量)
    private int mMiddleCount = 1;//中间View的个数(占用item的数量)
    //private int mBottomCount = 20;//尾部View的个数

    // 尾部内容长度(占用item数量)
    public int getBottomItemCount() {
        return dataBody != null ? dataBody.getData().getRecommend_items().size() : 0;
    }

    // 判断当前item是否是MiddleView
    public boolean isMiddleView(int position) {
        return mMiddleCount != 0 && position < mMiddleCount;
    }

    // 判断当前item是否是BottomView
    public boolean isBottomView(int position) {
        return getBottomItemCount() != 0 && position >= mMiddleCount;
    }

    /**
     * getItemViewType()--int
     * 判断当前Item类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_MIDDLE;
        } else
            return ITEM_TYPE_BOTTOM;
    }

    /**
     * onCreateViewHolder()--RecyclerView.ViewHolder
     * 创建缓存类的方法 主要作用就是绑定视图
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 定义一个ViewHolder
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {

//            case ITEM_TYPE_HEADER:
//
//                View viewHeader = LayoutInflater.from(mContext).inflate(R.layout.item_gift_next_one_rv_head, parent, false);
//
//                holder = new HeaderViewHolder(viewHeader);
//
//                break;

            case ITEM_TYPE_MIDDLE:

                View viewMiddle = LayoutInflater.from(mContext).inflate(R.layout.item_gift_next_one_rv_middle, parent, false);

                holder = new MiddleViewHolder(viewMiddle);

                break;

            case ITEM_TYPE_BOTTOM:

                View viewBottom = LayoutInflater.from(mContext).inflate(R.layout.item_gift_next_one_rv_bottom, parent, false);

                holder = new BottomViewHolder(viewBottom);

                break;

        }
        return holder;

    }

    /**
     * onBindViewHolder()--void
     * 绑定缓存类的方法 主要作用就是绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int type = getItemViewType(position);

        switch (type) {

            case ITEM_TYPE_MIDDLE:

                // 强转Holder
                MiddleViewHolder holderMid = (MiddleViewHolder) holder;
                // 初始化适配器
                GiftNextOneHorAdapter adapter = new GiftNextOneHorAdapter(mContext);
                // 设置数据
                adapter.setData(dataBody);
                // 绑定适配器
                holderMid.mRecyclerView.setAdapter(adapter);
                // 设置Manager
                GridLayoutManager manager = new GridLayoutManager(mContext, 1, LinearLayoutManager.HORIZONTAL, false);
                holderMid.mRecyclerView.setLayoutManager(manager);

                break;

            case ITEM_TYPE_BOTTOM:

                //int pos = GiftNextOneHorAdapter.sendPos();

                BottomViewHolder holderBottom = (BottomViewHolder) holder;

                holderBottom.tvBottomName.setText(dataBody.getData().getRecommend_items().get(position).getName());
                holderBottom.tvBottomPrice.setText(dataBody.getData().getRecommend_items().get(position).getPrice());
                Picasso.with(mContext).load(dataBody.getData().getRecommend_items().get(position).getCover_image_url()).into(holderBottom.ivBottomCoverImageUrl);

                /* 获取到position信息 */
                mPos = getItemViewType(position);

                break;
        }

    }

    /**
     * 静态方法 发送pos到GiftNextOneFragment
     *
     * @return
     */
    public static int sendPos() {
        return mPos;
    }

    /**
     * getItemCount()--int
     * 获取数据的总数量
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return dataBody.getData().getRecommend_items().size();

    }

    /**
     * 中部ViewHolder
     */
    private class MiddleViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mRecyclerView;

        private MiddleViewHolder(View itemView) {
            super(itemView);

            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.rv_gift_next_one_mid);

        }
    }

    /**
     * 尾部ViewHolder
     */
    private class BottomViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivBottomCoverImageUrl;
        private TextView tvBottomName, tvBottomPrice;

        private BottomViewHolder(View itemView) {
            super(itemView);

            ivBottomCoverImageUrl = (ImageView) itemView.findViewById(R.id.iv_gift_next_one_bottom_cover_image_url);
            tvBottomName = (TextView) itemView.findViewById(R.id.tv_gift_next_one_bottom_name);
            tvBottomPrice = (TextView) itemView.findViewById(R.id.tv_gift_next_one_bottom_price);

        }
    }
}
