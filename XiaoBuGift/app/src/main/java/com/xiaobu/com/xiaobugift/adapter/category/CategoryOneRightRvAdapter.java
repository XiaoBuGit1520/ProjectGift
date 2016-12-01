package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneData;

/**
 * Created by xiaoBu on 16/11/30.
 * 分类Fragment--单品Tab--右侧内容rv适配器
 */

public class CategoryOneRightRvAdapter extends RecyclerView.Adapter<CategoryOneRightRvAdapter.MyViewHolder> {

    private Context mContext;
    private CategoryOneData dataContent;
    private int pos;

    public CategoryOneRightRvAdapter(Context context) {
        mContext = context;
    }

    public void setDataContent(CategoryOneData dataContent) {
        this.dataContent = dataContent;
        notifyDataSetChanged();
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category_list_right_content, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvIconName.setText(dataContent.getData().getCategories().get(pos).getSubcategories().get(position).getName());
        Picasso.with(mContext).load(dataContent.getData().getCategories().get(pos).getSubcategories().get(position).getIcon_url()).into(holder.ivIcon);

    }

    @Override
    public int getItemCount() {
        return dataContent != null ? dataContent.getData().getCategories().get(pos).getSubcategories().size() : 0;
    }

    /**
     * 内部类
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivIcon;
        private TextView tvIconName;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivIcon = (ImageView) itemView.findViewById(R.id.iv_category_one_content_icon_url);
            tvIconName = (TextView) itemView.findViewById(R.id.tv_category_one_content_name);
        }
    }
}
