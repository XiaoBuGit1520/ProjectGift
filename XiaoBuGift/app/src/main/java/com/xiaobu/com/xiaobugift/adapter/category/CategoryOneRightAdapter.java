package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneData;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by xiaoBu on 16/11/30.
 * 分类Fragment--单品Tab--适配器(右)
 */

public class CategoryOneRightAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private CategoryOneData data;
    private Context mContext;
    private CategoryOneRightRvAdapter mAdapter;

    public CategoryOneRightAdapter(Context context) {
        mContext = context;
    }

    public void setData(CategoryOneData data) {
        this.data = data;
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

    /**
     * 内容View
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ContentViewHolder holderContent = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_list_right, parent, false);
            holderContent = new ContentViewHolder(convertView);
            convertView.setTag(holderContent);

        } else {

            holderContent = (ContentViewHolder) convertView.getTag();
        }

        // 初始化适配器
        mAdapter = new CategoryOneRightRvAdapter(mContext);
        // 设置(发送)数据到二级适配器
        mAdapter.setDataContent(data);
        mAdapter.setPos(position);
        // 绑定适配器
        holderContent.rvContent.setAdapter(mAdapter);
        // 设置rv manager (每行*3)
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        holderContent.rvContent.setLayoutManager(manager);

        return convertView;
    }

    /**
     * 继承接口自动复写方法 相当于自动加载不同行布局
     * 标题View
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {

        TitleViewHolder holderTitle = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_list_right, parent, false);
            holderTitle = new TitleViewHolder(convertView);
            convertView.setTag(holderTitle);

        } else {

            holderTitle = (TitleViewHolder) convertView.getTag();

        }

        holderTitle.tvTitle.setText(data.getData().getCategories().get(position).getName());

        return convertView;
    }

    /**
     * 继承接口自动复写方法
     *
     * @param position
     * @return
     */
    @Override
    public long getHeaderId(int position) {
        return position;
    }

    /**
     * 右侧标题缓存类
     */
    class TitleViewHolder {

        private TextView tvTitle;

        public TitleViewHolder(View view) {

            tvTitle = (TextView) view.findViewById(R.id.tv_category_one_title_right);
        }
    }

    /**
     * 右侧内容缓存类
     */
    class ContentViewHolder {

        private RecyclerView rvContent;

        public ContentViewHolder(View view) {

            rvContent = (RecyclerView) view.findViewById(R.id.rv_category_one_right);

        }
    }
}
