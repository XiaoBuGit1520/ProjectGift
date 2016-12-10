package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyHeadNextData;

/**
 * Created by xiaoBu on 16/12/8.
 */

public class CategoryStrategyHeadAdapterNext extends BaseAdapter {

    private Context mContext;
    private CategoryStrategyHeadNextData data;

    public CategoryStrategyHeadAdapterNext(Context context) {
        mContext = context;
    }

    public void setData(CategoryStrategyHeadNextData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getPosts().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getPosts().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_strategy_head_next, parent, false);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(data.getData().getPosts().get(position).getTitle());
        holder.tvNickName.setText(data.getData().getPosts().get(position).getAuthor().getNickname());
        holder.tvLikesCount.setText(data.getData().getPosts().get(position).getLikes_count() + "");
        holder.tvTime.setText(data.getData().getPosts().get(position).getCreated_at() + "");

        Picasso.with(mContext).load(data.getData().getPosts().get(position).getCover_image_url()).into(holder.mImageView);
        return convertView;
    }

    class MyViewHolder {

        private ImageView mImageView;
        private TextView tvTitle, tvNickName, tvLikesCount, tvTime;

        public MyViewHolder(View view) {

            mImageView = (ImageView) view.findViewById(R.id.iv_category_strategy_head_next);
            tvTitle = (TextView) view.findViewById(R.id.tv_category_strategy_head_next_title);
            tvNickName = (TextView) view.findViewById(R.id.tv_category_strategy_head_next_author_nick_name);
            tvLikesCount = (TextView) view.findViewById(R.id.tv_category_strategy_head_next_likes_count);
            tvTime = (TextView) view.findViewById(R.id.tv_category_strategy_head_next_created_at);

        }
    }
}
