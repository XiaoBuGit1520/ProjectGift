package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.category.CategoryStrategyHeadNextActivity;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomData;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyHeadData;
import com.xiaobu.com.xiaobugift.customize.MyGridView;

/**
 * Created by xiaoBu on 16/11/28.
 * 分类Fragment 攻略Tab 包裹rv适配器
 */

public class CategoryStrategyAdapter extends RecyclerView.Adapter {

    public static final int TYPE_CATEGORY_HEADER = 0;
    public static final int TYPE_CATEGORY_BOTTOM = 1;

    private Context mContext;

    private CategoryStrategyHeadData dataHead;
    private CategoryStrategyBottomData dataBottom;

    public CategoryStrategyAdapter(Context context) {
        mContext = context;
    }

    // 头布局设置数据
    public void setDataHead(CategoryStrategyHeadData dataHead) {
        this.dataHead = dataHead;
        notifyDataSetChanged();
    }

    // 尾布局设置数据
    public void setDataBottom(CategoryStrategyBottomData dataBottom) {
        this.dataBottom = dataBottom;
        notifyDataSetChanged();
    }

    /**
     * getItemViewType()
     * 获取每一行的类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_CATEGORY_HEADER;
        } else if (position == 1) {
            return TYPE_CATEGORY_BOTTOM;
        } else {
            return 0;
        }

    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 定义一个ViewHolder
        RecyclerView.ViewHolder holder = null;

        // 根据不同的类型注入不同的行视图
        switch (viewType) {

            case TYPE_CATEGORY_HEADER:

                View viewHead = LayoutInflater.from(mContext).inflate(R.layout.item_category_strategy_head_rv, parent, false);

                holder = new CgHeaderViewHolder(viewHead);

                break;

            case TYPE_CATEGORY_BOTTOM:

                View viewBottom = LayoutInflater.from(mContext).inflate(R.layout.item_category_strategy_bottom_gv, parent, false);

                holder = new CgGvViewHolder(viewBottom);

                break;
        }
        return holder;
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        // 定义我们的缓存类对象
        CgHeaderViewHolder holderHead = null;
        CgGvViewHolder holderGv = null;

        int type = getItemViewType(position);

        switch (type) {

            case TYPE_CATEGORY_HEADER:

                holderHead = (CgHeaderViewHolder) holder;//强转holder

                // 初始化适配器
                CategoryStrategyHeadAdapter adapterHead = new CategoryStrategyHeadAdapter(mContext);
                // 设置(发送)数据到二级适配器
                adapterHead.setData(dataHead);
                // 绑定适配器
                holderHead.mRecyclerViewHead.setAdapter(adapterHead);

                // 设置rv manager(3 * 横向)
                GridLayoutManager managerHead = new GridLayoutManager(mContext, 3, LinearLayoutManager.HORIZONTAL, false);
                holderHead.mRecyclerViewHead.setLayoutManager(managerHead);

                /* 下一级适配器rv点击事件 */
                adapterHead.setCategoryStrategyClick(new CategoryStrategyClick() {
                    @Override
                    public void myCategoryStrategyListener(int pos) {

                        String id = dataHead.getData().getColumns().get(pos).getId() + "";
                        Intent intent = new Intent(mContext, CategoryStrategyHeadNextActivity.class);
                        intent.putExtra("id", id);
                        mContext.startActivity(intent);
                    }
                });

                break;

            case TYPE_CATEGORY_BOTTOM:

                holderGv = (CgGvViewHolder) holder;//强转holder

                // 初始化适配器
                CategoryStrategyGvAdapterUp adapterUp = new CategoryStrategyGvAdapterUp(mContext);
                CategoryStrategyGvAdapterMid adapterMid = new CategoryStrategyGvAdapterMid(mContext);
                CategoryStrategyGvAdapterDown adapterDown = new CategoryStrategyGvAdapterDown(mContext);
                // 设置(发送)数据到二级适配器
                adapterUp.setData(dataBottom);
                adapterMid.setData(dataBottom);
                adapterDown.setData(dataBottom);
                // 绑定适配器
                holderGv.mGridViewUp.setAdapter(adapterUp);
                holderGv.mGridViewMid.setAdapter(adapterMid);
                holderGv.mGridViewDown.setAdapter(adapterDown);

                break;
        }

    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return 2;
    }

    class CgHeaderViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mRecyclerViewHead;

        public CgHeaderViewHolder(View itemView) {
            super(itemView);

            mRecyclerViewHead = (RecyclerView) itemView.findViewById(R.id.rv_category_head);
        }
    }

    class CgGvViewHolder extends RecyclerView.ViewHolder {

        private MyGridView mGridViewUp, mGridViewMid, mGridViewDown;

        public CgGvViewHolder(View itemView) {
            super(itemView);

            mGridViewUp = (MyGridView) itemView.findViewById(R.id.gv_cg_strategy_up);
            mGridViewMid = (MyGridView) itemView.findViewById(R.id.gv_cg_strategy_mid);
            mGridViewDown = (MyGridView) itemView.findViewById(R.id.gv_cg_strategy_down);

        }
    }
}
