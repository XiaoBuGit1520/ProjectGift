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
import com.xiaobu.com.xiaobugift.bean.home.HomeChoicenessData;

/**
 * Created by dllo on 16/11/24.
 */

public class HomeChoicenessAdapter extends BaseAdapter {

    private Context context;
    private HomeChoicenessData data;

    public HomeChoicenessAdapter(Context context) {
        this.context = context;
    }

    public void setData(HomeChoicenessData data) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_choiceness, parent, false);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        if (data.getData().getItems().get(position).getId() != 1046846) {

            holder.tvTitle.setText(data.getData().getItems().get(position).getTitle());
            holder.tvIntroduction.setText(data.getData().getItems().get(position).getIntroduction());
            holder.tvAuthorNickname.setText(data.getData().getItems().get(position).getAuthor().getNickname());
            holder.tvAuthorIntroduction.setText(data.getData().getItems().get(position).getAuthor().getIntroduction());
            //holder.tvColumnTitle.setText(data.getData().getItems().get(position).getColumn().getTitle());
            holder.tvLove.setText(data.getData().getItems().get(position).getLikes_count() + "");

            Picasso.with(context).load(data.getData().getItems().get(position).getCover_image_url()).into(holder.ivCoverImageUrl);
            Picasso.with(context).load(data.getData().getItems().get(position).getAuthor().getAvatar_url()).into(holder.ivAuthorAvatarUrl);
        }
        return convertView;
    }

    class ViewHolder {

        private TextView tvAuthorNickname, tvAuthorIntroduction, tvTitle, tvIntroduction, tvColumnTitle;
        private ImageView ivAuthorAvatarUrl, ivCoverImageUrl;
        private TextView tvLove;

        public ViewHolder(View view) {

            tvAuthorIntroduction = (TextView) view.findViewById(R.id.tv_home_choice_author_introduction);
            tvAuthorNickname = (TextView) view.findViewById(R.id.tv_home_choice_author_nickname);
            tvTitle = (TextView) view.findViewById(R.id.tv_home_choice_title);
            tvIntroduction = (TextView) view.findViewById(R.id.tv_home_choice_introduction);
            tvColumnTitle = (TextView) view.findViewById(R.id.tv_home_choice_column_title);

            ivAuthorAvatarUrl = (ImageView) view.findViewById(R.id.iv_home_choice_author_avatar_url);
            ivCoverImageUrl = (ImageView) view.findViewById(R.id.iv_home_choice_cover_image_url);

            tvLove = (TextView) view.findViewById(R.id.home_choice_love);
        }
    }
}
