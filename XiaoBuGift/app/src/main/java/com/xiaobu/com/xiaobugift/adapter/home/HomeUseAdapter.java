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
 * Created by dllo on 16/11/23.
 */

public class HomeUseAdapter extends BaseAdapter {

    private List<HomeUseData.DataBean.ItemsBean> data;
    private Context context;

    public HomeUseAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<HomeUseData.DataBean.ItemsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : null;
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

        holder.tvAuthorNickname.setText(data.get(position).getAuthor().getNickname());
        holder.tvAuthorIntroduction.setText(data.get(position).getAuthor().getIntroduction());
        holder.tvTitle.setText(data.get(position).getTitle());
        holder.tvIntroduction.setText(data.get(position).getIntroduction());
        holder.tvColumnTitle.setText(data.get(position).getColumn().getTitle());

        Picasso.with(context).load(data.get(position).getAuthor().getAvatar_url()).into(holder.ivAuthorAvatarUrl);
        Picasso.with(context).load(data.get(position).getCover_image_url()).into(holder.ivCoverImageUrl);
        return convertView;
    }

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
