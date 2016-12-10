package com.xiaobu.com.xiaobugift.adapter.gift;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.gift.GiftUseData;

/**
 * Created by xiaobu on 2016/11/27.
 * 榜单Fragment 适配器(复用 + 头尾布局)
 */

public class GiftUseAdapterUpdate extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private GiftUseData data;
    // item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_FOOTER = 2;

    private int mHeaderCount = 1;//头部View的个数
    private int mBottomCount = 1;//尾部View的个数

    private GiftClick mGiftClick;//声明接口对象

    // 接口对象set方法
    public void setGiftClick(GiftClick giftClick) {
        mGiftClick = giftClick;
    }

    private Context mContext;

    public GiftUseAdapterUpdate(Context context) {
        mContext = context;
    }

    //内容长度
    public int getContentItemCount() {
        return data != null ? data.getData().getItems().size() : 0;
    }

    public void setData(GiftUseData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    //判断当前item是否是HeadView
    public boolean isHeadView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    //判断当前item是否是BottomView
    public boolean isBottomView(int position) {
        return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
    }

    /**
     * 判断当前Item类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int dataItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position < mHeaderCount) {
            return ITEM_TYPE_HEADER;//头部View
        } else if (mBottomCount != 0 && position >= (mHeaderCount + dataItemCount)) {
            return ITEM_TYPE_FOOTER;//底部View
        } else {
            return ITEM_TYPE_NORMAL;//中间View
        }
    }

    /**
     * onCreateViewHolder()
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gift_use_head, parent, false));
        } else if (viewType == mHeaderCount) {
            return new NormalViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gift_use, parent, false));
        } else if (viewType == ITEM_TYPE_FOOTER) {
            return new FooterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_gift_use_foot, parent, false));
        }
        return null;
    }

    /**
     * onBindViewHolder()
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof HeaderViewHolder) {

            Picasso.with(mContext).load(data.getData().getCover_image()).into(((HeaderViewHolder) holder).ivCoverImage);

        } else if (holder instanceof NormalViewHolder) {

            ((NormalViewHolder) holder).tvName.setText(data.getData().getItems().get(position - mHeaderCount).getName());
            ((NormalViewHolder) holder).tvPrice.setText(" ¥ " + data.getData().getItems().get(position - mHeaderCount).getPrice());
            ((NormalViewHolder) holder).tvShortDescription.setText(data.getData().getItems().get(position - mHeaderCount).getShort_description());

            Picasso.with(mContext).load(data.getData().getItems().get(position - mHeaderCount).getCover_image_url()).into(((NormalViewHolder) holder).ivCoverImageUrl);

        } else if (holder instanceof FooterViewHolder) {

        }

        /* 设置监听 */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGiftClick.myGiftListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBottomCount + getContentItemCount() + mBottomCount;
    }

    /**
     * 头部ViewHolder
     */
    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivCoverImage;

        private HeaderViewHolder(View itemView) {
            super(itemView);
            ivCoverImage = (ImageView) itemView.findViewById(R.id.iv_gift_use_head_cover_image);

        }
    }

    /**
     * 中部ViewHolder
     */
    private class NormalViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvShortDescription, tvPrice;
        private ImageView ivCoverImageUrl;

        private NormalViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_gift_use_name);
            tvShortDescription = (TextView) itemView.findViewById(R.id.tv_gift_use_short_description);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_gift_use_price);
            ivCoverImageUrl = (ImageView) itemView.findViewById(R.id.iv_gift_use_cover_image_url);
        }
    }

    /**
     * 尾部ViewHolder
     */
    private class FooterViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivGiftUseFooter;

        private FooterViewHolder(View itemView) {
            super(itemView);

            ivGiftUseFooter = (ImageView) itemView.findViewById(R.id.iv_gift_use_footer);

        }
    }


}
