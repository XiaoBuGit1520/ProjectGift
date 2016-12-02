package com.xiaobu.com.xiaobugift.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.home.HomeGridDataNext;

/**
 * Created by xiaoBu on 16/12/2.
 */

public class HomeGridAdapterNext extends BaseAdapter {

    private HomeGridDataNext data;
    private Context mContext;

    public HomeGridAdapterNext(Context context) {
        mContext = context;
    }

    public void setData(HomeGridDataNext data) {
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
        GridViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_home_grid_next, parent, false);

            holder = new GridViewHolder(convertView);

            convertView.setTag(holder);

        } else {

            holder = (GridViewHolder) convertView.getTag();

        }

        holder.tvAuthorNickname.setText(data.getData().getPosts().get(position).getAuthor().getNickname());//小C
        holder.tvAuthorIntroduction.setText(data.getData().getPosts().get(position).getAuthor().getIntroduction());//礼物界的老司机
        holder.tvTitle.setText(data.getData().getPosts().get(position).getTitle());//送这些礼物给射手座男生...
        holder.tvIntroduction.setText(data.getData().getPosts().get(position).getIntroduction());//作为星座界的二傻护法...
        holder.tvColumnTitle.setText(data.getData().getPosts().get(position).getColumn().getTitle());//不打烊的礼物店

        Picasso.with(mContext).load(data.getData().getPosts().get(position).getCover_image_url()).into(holder.ivCoverImageUrl);//主图片
        Picasso.with(mContext).load(data.getData().getPosts().get(position).getAuthor().getAvatar_url()).into(holder.ivAuthorAvatarUrl);//作者头像;

        return convertView;
    }

    /**
     * 缓存类
     */
    private class GridViewHolder {

        private TextView tvAuthorNickname, tvAuthorIntroduction, tvTitle, tvIntroduction, tvColumnTitle;
        private ImageView ivAuthorAvatarUrl, ivCoverImageUrl;

        private GridViewHolder(View view) {

            tvAuthorNickname = (TextView) view.findViewById(R.id.tv_home_grid_author_nickname);
            tvAuthorIntroduction = (TextView) view.findViewById(R.id.tv_home_grid_author_introduction);
            tvTitle = (TextView) view.findViewById(R.id.tv_home_grid_title);
            tvIntroduction = (TextView) view.findViewById(R.id.tv_home_grid_introduction);
            tvColumnTitle = (TextView) view.findViewById(R.id.tv_home_grid_column_title);

            ivAuthorAvatarUrl = (ImageView) view.findViewById(R.id.iv_home_grid_author_avatar_url);
            ivCoverImageUrl = (ImageView) view.findViewById(R.id.iv_home_grid_cover_image_url);
        }
    }


}
