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
import com.xiaobu.com.xiaobugift.bean.home.HomeGlideDataTwo;

/**
 * Created by xiaoBu on 16/12/1.
 * 轮播图--二级页面--适配器
 */

public class HomeGlideAdapterTwo extends BaseAdapter {

    private HomeGlideDataTwo data;
    private Context mContext;

    public HomeGlideAdapterTwo(Context context) {
        mContext = context;
    }

    public void setData(HomeGlideDataTwo data) {
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

        GlideViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_home_glide_two, parent, false);

            holder = new GlideViewHolder(convertView);

            convertView.setTag(holder);

        } else {

            holder = (GlideViewHolder) convertView.getTag();

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
    class GlideViewHolder {

        private TextView tvAuthorNickname, tvAuthorIntroduction, tvTitle, tvIntroduction, tvColumnTitle;
        private ImageView ivAuthorAvatarUrl, ivCoverImageUrl;

        public GlideViewHolder(View view) {

            tvAuthorNickname = (TextView) view.findViewById(R.id.tv_home_glide_author_nickname);
            tvAuthorIntroduction = (TextView) view.findViewById(R.id.tv_home_glide_author_introduction);
            tvTitle = (TextView) view.findViewById(R.id.tv_home_glide_title);
            tvIntroduction = (TextView) view.findViewById(R.id.tv_home_glide_introduction);
            tvColumnTitle = (TextView) view.findViewById(R.id.tv_home_glide_column_title);

            ivAuthorAvatarUrl = (ImageView) view.findViewById(R.id.iv_home_glide_author_avatar_url);
            ivCoverImageUrl = (ImageView) view.findViewById(R.id.iv_home_glide_cover_image_url);
        }
    }
}
