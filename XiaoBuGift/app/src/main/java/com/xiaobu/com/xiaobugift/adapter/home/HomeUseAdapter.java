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
import com.xiaobu.com.xiaobugift.bean.home.HomeUseData;

import java.util.List;

/**
 * Created by xiaoBu on 16/11/23.
 * 首页--除精选Tab外其余Tab共用的Adapter
 */

public class HomeUseAdapter extends BaseAdapter {

    //private List<HomeUseData.DataBean.ItemsBean> data;
    private HomeUseData data;
    private Context context;

    public HomeUseAdapter(Context context) {
        this.context = context;
    }

    public void setData(HomeUseData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getItems().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getItems().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_use, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvAuthorNickname.setText(data.getData().getItems().get(position).getAuthor().getNickname());//作者昵称
        holder.tvAuthorIntroduction.setText(data.getData().getItems().get(position).getAuthor().getIntroduction());//作者介绍
        holder.tvTitle.setText(data.getData().getItems().get(position).getTitle());//标题(大字体内容)
        holder.tvIntroduction.setText(data.getData().getItems().get(position).getIntroduction());//标题下方的介绍
        holder.tvColumnTitle.setText(data.getData().getItems().get(position).getColumn().getTitle());//eg:栏目 一个

        Picasso.with(context).load(data.getData().getItems().get(position).getAuthor().getAvatar_url()).into(holder.ivAuthorAvatarUrl);//作者头像
        Picasso.with(context).load(data.getData().getItems().get(position).getCover_image_url()).into(holder.ivCoverImageUrl);//大图片
        return convertView;
    }

    /**
     * 缓存类
     */
    class ViewHolder {

        private TextView tvAuthorNickname, tvAuthorIntroduction, tvTitle, tvIntroduction, tvColumnTitle;
        private ImageView ivAuthorAvatarUrl, ivCoverImageUrl;

        public ViewHolder(View view) {

            tvAuthorNickname = (TextView) view.findViewById(R.id.tv_home_use_author_nickname);
            tvAuthorIntroduction = (TextView) view.findViewById(R.id.tv_home_use_author_introduction);
            tvTitle = (TextView) view.findViewById(R.id.tv_home_use_title);
            tvIntroduction = (TextView) view.findViewById(R.id.tv_home_use_introduction);
            tvColumnTitle = (TextView) view.findViewById(R.id.tv_home_use_column_title);

            ivAuthorAvatarUrl = (ImageView) view.findViewById(R.id.iv_home_use_author_avatar_url);
            ivCoverImageUrl = (ImageView) view.findViewById(R.id.iv_home_use_cover_image_url);
        }
    }


}
