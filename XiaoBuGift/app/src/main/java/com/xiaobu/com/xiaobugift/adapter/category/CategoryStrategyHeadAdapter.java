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
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyHeadData;

/**
 * Created by xiaoBu on 16/11/28.
 * 分类Fragment--攻略Tab--头部rv适配器
 */

public class CategoryStrategyHeadAdapter extends RecyclerView.Adapter<CategoryStrategyHeadAdapter.MyHeaderViewHolder> {

    private Context mContext;
    private CategoryStrategyHeadData data;

    public CategoryStrategyHeadAdapter(Context context) {
        mContext = context;
    }

    public void setData(CategoryStrategyHeadData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyHeaderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 加载行布局
        View mViewHead = LayoutInflater.from(mContext).inflate(R.layout.item_categoty_head_hor, parent, false);

        MyHeaderViewHolder holder = new MyHeaderViewHolder(mViewHead);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHeaderViewHolder holder, int position) {

        holder.tvCategoryHeadAuthor.setText(data.getData().getColumns().get(position).getAuthor());
        holder.tvCategoryHeadTitle.setText(data.getData().getColumns().get(position).getTitle());

        Picasso.with(mContext).load(data.getData().getColumns().get(position).getCover_image_url()).into(holder.ivCategoryHeadCoverImageUrl);

    }

    @Override
    public int getItemCount() {
        return data != null ? data.getData().getColumns().size() : 0;
    }

    /**
     * 内部类
     */
    class MyHeaderViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivCategoryHeadCoverImageUrl;
        private TextView tvCategoryHeadTitle, tvCategoryHeadAuthor;

        public MyHeaderViewHolder(View itemView) {
            super(itemView);

            ivCategoryHeadCoverImageUrl = (ImageView) itemView.findViewById(R.id.iv_category_head_cover_image_url);
            tvCategoryHeadTitle = (TextView) itemView.findViewById(R.id.tv_category_head_title);
            tvCategoryHeadAuthor = (TextView) itemView.findViewById(R.id.tv_category_head_author);

        }
    }
}
