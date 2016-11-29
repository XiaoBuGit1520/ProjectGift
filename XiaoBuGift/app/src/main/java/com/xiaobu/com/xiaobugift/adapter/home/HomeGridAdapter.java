package com.xiaobu.com.xiaobugift.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.home.HomeGridData;

/**
 * Created by xiaoBu on 16/11/25.
 * 精选---头布局---六宫格---适配器
 */
public class HomeGridAdapter extends BaseAdapter {

    private HomeGridData data;
    private Context context;

    public HomeGridAdapter(Context context) {
        this.context = context;
    }

    public void setData(HomeGridData data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getSecondary_banners().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getSecondary_banners().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GridViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_choiceness_head_grid, parent, false);

            holder = new GridViewHolder(convertView);

            convertView.setTag(holder);

        } else {

            holder = (GridViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(data.getData().getSecondary_banners().get(position).getImage_url()).into(holder.ivHomeChoiceHeadGrid);

        return convertView;
    }

    /**
     * GridViewHolder内部类
     */
    class GridViewHolder {

        private ImageView ivHomeChoiceHeadGrid;

        public GridViewHolder(View view) {
            ivHomeChoiceHeadGrid = (ImageView) view.findViewById(R.id.iv_home_choice_head_grid);
        }
    }
}
