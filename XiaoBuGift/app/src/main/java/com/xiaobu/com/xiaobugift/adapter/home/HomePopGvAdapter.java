package com.xiaobu.com.xiaobugift.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.home.HomeTabData;

/**
 * Created by xiaoBu on 2016/12/9.
 * 首页Fragment--PopUpWindow--Gv适配器
 */

public class HomePopGvAdapter extends BaseAdapter {

    private Context mContext;
    private HomeTabData data;

    public HomePopGvAdapter(Context context) {
        mContext = context;
    }

    public void setData(HomeTabData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getChannels().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getChannels().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_pop, parent, false);

            holder = new MyViewHolder(convertView);

            convertView.setTag(holder);
        } else {

            holder = (MyViewHolder) convertView.getTag();
        }

        holder.mTextView.setText(data.getData().getChannels().get(position).getName());

        return convertView;
    }

    private class MyViewHolder {

        private TextView mTextView;

        private MyViewHolder(View view) {

            mTextView = (TextView) view.findViewById(R.id.tv_pop);
        }
    }
}
