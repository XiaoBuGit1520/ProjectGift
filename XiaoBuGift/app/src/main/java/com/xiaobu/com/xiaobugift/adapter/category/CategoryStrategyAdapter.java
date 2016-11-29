package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomData;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyHeadData;

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

    /* 设置不同行布局View的个数 */
    private int mHeaderCount = 1;//上方View的个数
    private int mBottomCount = 1;//下方View的个数

    /* 总内容长度 */
//    public int getContentItemCount() {
//
//        return dataHead != null && dataBottom != null ? (dataHead.getData().getColumns().size() + dataBottom.getData().getChannel_groups().size()) : 0;
//
//    }

    /**
     * getItemViewType()
     * 获取每一行的类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        //int dataItemCount = getContentItemCount();

//        if (mHeaderCount != 0 && position < mHeaderCount) {
//
//            return TYPE_CATEGORY_HEADER;
//
//        } else
//            return TYPE_CATEGORY_BOTTOM;

        if (position == 0) {
            return TYPE_CATEGORY_HEADER;
        } else if (position == 1) {
            return TYPE_CATEGORY_BOTTOM;
        } else
            return 0;
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

                View viewHead = LayoutInflater.from(mContext).inflate(R.layout.item_category_rv_head, parent, false);

                holder = new CgHeaderViewHolder(viewHead);

                break;

            case TYPE_CATEGORY_BOTTOM:

                View viewBottom = LayoutInflater.from(mContext).inflate(R.layout.item_category_rv_bottom, parent, false);

                holder = new CgBottomViewHolder(viewBottom);

                break;
        }
        return holder;
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 定义我们的缓存类对象
        CgHeaderViewHolder holderHead = null;
        CgBottomViewHolder holderBottom = null;

        int type = getItemViewType(position);

        switch (type) {

            case TYPE_CATEGORY_HEADER:

                // 初始化适配器
                CategoryStrategyHeadAdapter adapterHead = new CategoryStrategyHeadAdapter(mContext);
                // 强转holder
                holderHead = (CgHeaderViewHolder) holder;
                // 设置(发送)数据到二级适配器
                adapterHead.setData(dataHead);
                // 绑定适配器
                holderHead.mRecyclerViewHead.setAdapter(adapterHead);

                // 设置rv manager(3 * 横向)
                GridLayoutManager managerHead = new GridLayoutManager(mContext, 3, LinearLayoutManager.HORIZONTAL, false);
                holderHead.mRecyclerViewHead.setLayoutManager(managerHead);

                break;

            case TYPE_CATEGORY_BOTTOM:

                // 初始化适配器
                CategoryStrategyBottomAdapter adapterBottom = new CategoryStrategyBottomAdapter(mContext);
                // 强转holder
                holderBottom = (CgBottomViewHolder) holder;
                // 设置(发送)数据到二级适配器
                adapterBottom.setData(dataBottom);
                // 绑定适配器
                holderBottom.mRecyclerViewBottom.setAdapter(adapterBottom);

                // 设置rv manager(每行2个Item)
                GridLayoutManager managerBottom = new GridLayoutManager(mContext, 2);
                holderBottom.mRecyclerViewBottom.setLayoutManager(managerBottom);

                break;
        }


    }

    /**
     *
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

    class CgBottomViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mRecyclerViewBottom;

        public CgBottomViewHolder(View itemView) {
            super(itemView);

            mRecyclerViewBottom = (RecyclerView) itemView.findViewById(R.id.rv_category_bottom);
        }
    }
}
