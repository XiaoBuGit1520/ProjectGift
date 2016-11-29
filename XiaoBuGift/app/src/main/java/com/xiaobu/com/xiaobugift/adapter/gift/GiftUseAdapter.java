package com.xiaobu.com.xiaobugift.adapter.gift;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.gift.GiftUseData;

/**
 * Created by xiaoBu on 16/11/25.
 */

public class GiftUseAdapter extends RecyclerView.Adapter {

    private Context context;
    private GiftUseData data;
    private View viewHead;

    // 定义不同行布局
    public static final int TYPE_HEAD = 0;
    public static final int TYPE_NORMAL = 1;

    public GiftUseAdapter(Context context) {
        this.context = context;
    }

    public void setData(GiftUseData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    /**
     * getItemViewType()---获取每一行的类型
     * 手动复写方法
     *
     * @param position
     * @return 返回实体类类型
     */
    @Override
    public int getItemViewType(int position) {
        //if (headView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEAD;
        return TYPE_NORMAL;

    }

    /**
     * onCreateViewHolder()
     * getView()分支1
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 定义一个ViewHolder
        RecyclerView.ViewHolder holder = null;

        // 根据不同的类型注入不同的行视图
        switch (viewType) {

            case TYPE_HEAD:

                viewHead = LayoutInflater.from(context).inflate(R.layout.item_gift_use_head, parent, false);
                // 这个地方写差劈了onBindViewHolder()内holder会报类型强制转换异常
                holder = new GiftViewHolderHead(viewHead);

                break;

            case TYPE_NORMAL:

                View viewNormal = LayoutInflater.from(context).inflate(R.layout.item_gift_use, parent, false);
                // 这个地方写差劈了onBindViewHolder()holder会报类型强制转换异常
                holder = new GiftViewHolder(viewNormal);

                break;

        }
        return holder;
    }

    /**
     * onBindViewHolder()
     * getView()分支2
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // 判断不同行布局究竟加载什么样的数据
        int type = getItemViewType(position);

        switch (type) {

            case TYPE_HEAD:

                // 定义我们自己的缓存类对象 然后强转holder(多态)
                GiftViewHolderHead holderHead = (GiftViewHolderHead) holder;

                Picasso.with(context).load(data.getData().getCover_image()).into(holderHead.ivCoverImage);

                break;

            case TYPE_NORMAL:

                // 定义我们自己的缓存类对象 然后强转holder(多态)
                GiftViewHolder holderContent = (GiftViewHolder) holder;

                holderContent.tvName.setText(data.getData().getItems().get(position).getName());
                holderContent.tvShortDescription.setText(data.getData().getItems().get(position).getShort_description());
                holderContent.tvPrice.setText("¥ " + data.getData().getItems().get(position).getPrice());

                Picasso.with(context).load(data.getData().getItems().get(position).getCover_image_url()).into(holderContent.ivCoverImageUrl);

                break;

        }
    }

    /**
     * onAttachedToRecyclerView()
     * 手动复写方法
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            // 强转
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            // 输入Look... //span跨度
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    Log.d("GiftUseAdapter", "aaa");
                    //return getItemViewType(position) == TYPE_HEAD ? gridLayoutManager.getSpanCount() : 1;
                    return 0;
                }
            });
        }
    }

    /**
     * 相当于getCount()
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return data != null ? data.getData().getItems().size() : 0;
    }

    /**
     * @param holder
     * @return
     */
    public int getRealPosition(RecyclerView.ViewHolder holder) {

        int position = holder.getLayoutPosition();

        return viewHead == null ? position : position - 1;
    }


    /**
     * GiftViewHolderHead 内部类
     * 头布局
     */
    class GiftViewHolderHead extends RecyclerView.ViewHolder {

        private ImageView ivCoverImage;

        GiftViewHolderHead(View itemView) {
            super(itemView);

            ivCoverImage = (ImageView) itemView.findViewById(R.id.iv_gift_use_head_cover_image);
        }
    }

    /**
     * GiftViewHolder 内部类
     */
    class GiftViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvShortDescription, tvPrice;
        private ImageView ivCoverImageUrl;

        GiftViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_gift_use_name);
            tvShortDescription = (TextView) itemView.findViewById(R.id.tv_gift_use_short_description);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_gift_use_price);
            ivCoverImageUrl = (ImageView) itemView.findViewById(R.id.iv_gift_use_cover_image_url);

        }
    }


}
