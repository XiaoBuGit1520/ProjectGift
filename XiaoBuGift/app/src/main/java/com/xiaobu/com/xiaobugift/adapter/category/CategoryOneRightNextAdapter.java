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
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneNextData;

/**
 * Created by xiaoBu on 2016/12/9.
 * 使用的item_gift_use的行布局
 */

public class CategoryOneRightNextAdapter extends RecyclerView.Adapter<CategoryOneRightNextAdapter.MyViewHolder> {

    private Context mContext;
    private CategoryOneNextData data;

    public CategoryOneRightNextAdapter(Context context) {
        mContext = context;
    }

    public void setData(CategoryOneNextData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 加载行布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gift_use, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvName.setText(data.getData().getItems().get(position).getName());
        holder.tvShortDescription.setText(data.getData().getItems().get(position).getShort_description());
        holder.tvPrice.setText("¥ " + data.getData().getItems().get(position).getPrice());

        Picasso.with(mContext).load(data.getData().getItems().get(position).getCover_image_url()).into(holder.ivCoverImageUrl);

    }

    @Override
    public int getItemCount() {
        return data != null ? data.getData().getItems().size() : 0;
    }

    /**
     * 缓存类
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvShortDescription, tvPrice;
        private ImageView ivCoverImageUrl;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_gift_use_name);
            tvShortDescription = (TextView) itemView.findViewById(R.id.tv_gift_use_short_description);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_gift_use_price);
            ivCoverImageUrl = (ImageView) itemView.findViewById(R.id.iv_gift_use_cover_image_url);
        }
    }
}
