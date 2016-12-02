package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
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
    private int mSelect = 0;

    public CategoryOneLeftAdapter(Context context) {
        mContext = context;
    }

    public void setData(CategoryOneData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void changeSelected(int position) {
        if (position != mSelect) {
            mSelect = position;
            notifyDataSetChanged();
        }
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

        /* 判断选中item的颜色 */
        if (mSelect == position) {
            convertView.setBackgroundResource(R.color.white);
        } else {
            convertView.setBackgroundResource(R.color.listLeft);
        }

        holder.tvLeft.setText(data.getData().getCategories().get(position).getName());

        return convertView;
    }

    /**
     * 内部类(缓存类)
     */
    class TabViewHolder {

        private TextView tvLeft;

        public TabViewHolder(View view) {
            tvLeft = (TextView) view.findViewById(R.id.tv_category_one_left);
        }
    }
}
