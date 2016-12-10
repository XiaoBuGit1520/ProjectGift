package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.category.CategoryOneNextActivity;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneData;

/**
 * Created by xiaoBu on 2016/12/9.
 * 重制版 换用Gv解决Rv与Lv滑动冲突的问题
 */

public class CategoryOneRightGvAdapter extends BaseAdapter {

    private Context mContext;
    private CategoryOneData data;
    private int pos;//定义位置信息
    private int selectIndex;

    public CategoryOneRightGvAdapter(Context context) {
        mContext = context;
    }

    public void setData(CategoryOneData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
        notifyDataSetChanged();
    }

    // 位置信息set方法,用于接收从上一级适配器传来的位置信息
    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getCategories().get(pos).getSubcategories().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getCategories().get(pos).getSubcategories().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_list_right_content, parent, false);

            holder = new MyViewHolder(convertView);

            convertView.setTag(holder);

        } else {

            holder = (MyViewHolder) convertView.getTag();
        }

        holder.tvIconName.setText(data.getData().getCategories().get(pos).getSubcategories().get(position).getName());
        Picasso.with(mContext).load(data.getData().getCategories().get(pos).getSubcategories().get(position).getIcon_url()).into(holder.ivIcon);

        /*** 点击图标跳转并传值 ***/
        final String id = data.getData().getCategories().get(pos).getSubcategories().get(position).getId() + "";
        //Log.d("id", id);

        holder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, CategoryOneNextActivity.class);
                intent.putExtra("id", id);
                mContext.startActivity(intent);
                Log.d("id", id);

            }
        });


        return convertView;
    }

    /**
     * 缓存类
     */
    class MyViewHolder {

        private ImageView ivIcon;
        private TextView tvIconName;

        public MyViewHolder(View view) {

            ivIcon = (ImageView) view.findViewById(R.id.iv_category_one_content_icon_url);
            tvIconName = (TextView) view.findViewById(R.id.tv_category_one_content_name);

        }
    }
}
