package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneData;

/**
 * Created by xiaoBu on 16/11/30.
 * 分类Fragment--单品Tab--lv适配器(左)
 */

public class CategoryOneLeftAdapter extends BaseAdapter {

    private CategoryOneData data;
    private Context mContext;
    private int mSelect;//

    public CategoryOneLeftAdapter(Context context) {
        mContext = context;
    }

    public void setData(CategoryOneData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    //
    public void setSelect(int select) {
        mSelect = select;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getCategories().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getCategories().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TabViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_list_left, parent, false);
            holder = new TabViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (TabViewHolder) convertView.getTag();
        }


        holder.tvLeft.setText(data.getData().getCategories().get(position).getName());

        if (position == mSelect) {
            holder.tvLeft.setTextColor(Color.RED);
            holder.tvLeftLine.setBackgroundColor(Color.RED);
            convertView.setBackgroundResource(R.color.white);
        } else {
            holder.tvLeft.setTextColor(Color.rgb(51, 51, 51));//#333333
            holder.tvLeftLine.setBackgroundResource(R.color.listLeft);//从colors.xml中取值需要用Resource
            convertView.setBackgroundResource(R.color.listLeft);//从colors.xml中取值需要用Resource
        }

        return convertView;
    }

    //
    public void  setIndex(int index) {
        mSelect = index;
    }

    /**
     * 内部类(缓存类)
     */
    private class TabViewHolder {

        private TextView tvLeft;
        private TextView tvLeftLine;

        private TabViewHolder(View view) {
            tvLeft = (TextView) view.findViewById(R.id.tv_category_one_left);
            tvLeftLine = (TextView) view.findViewById(R.id.tv_category_one_left_line_ver);
        }
    }
}
