package com.xiaobu.com.xiaobugift.adapter.gift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.gift.GiftNextCommentData;

/**
 * Created by xiaoBu on 16/12/7.
 */

public class GiftNextCommentAdapter extends BaseAdapter {

    private Context mContext;
    private GiftNextCommentData data;

    public GiftNextCommentAdapter(Context context) {
        mContext = context;
    }

    public void setData(GiftNextCommentData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getComments().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getComments().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_gift_next_comment, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvUserNickName.setText(data.getData().getComments().get(position).getUser().getNickname());
        holder.tvTime.setText(data.getData().getComments().get(position).getCreated_at() + "");
        holder.tvContent.setText(data.getData().getComments().get(position).getContent());

        Picasso.with(mContext).load(data.getData().getComments().get(position).getUser().getAvatar_url()).into(holder.ivUserHead);
        return convertView;
    }

    class ViewHolder {

        private ImageView ivUserHead;
        private TextView tvUserNickName, tvTime, tvContent;

        public ViewHolder(View view) {

            ivUserHead = (ImageView) view.findViewById(R.id.iv_gift_next_comment_user_avatar_url);
            tvUserNickName = (TextView) view.findViewById(R.id.tv_gift_next_comment_user_nickname);
            tvTime = (TextView) view.findViewById(R.id.tv_gift_next_comment_created_at);
            tvContent = (TextView) view.findViewById(R.id.tv_gift_next_comment_content);
        }
    }
}
