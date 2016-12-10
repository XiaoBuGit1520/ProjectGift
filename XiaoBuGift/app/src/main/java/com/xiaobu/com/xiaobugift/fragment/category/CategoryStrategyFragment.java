package com.xiaobu.com.xiaobugift.fragment.category;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryStrategyAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomData;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyHeadData;
import com.xiaobu.com.xiaobugift.constant.StaticConstant;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaobu on 2016/11/27.
 * 榜单Fragment--攻略Tab--All
 */

public class CategoryStrategyFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private CategoryStrategyAdapter mAdapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_category_strategy;
    }

    @Override
    public void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_category_strategy);

    }

    @Override
    public void initData() {
        // 注意要写在这里
        mAdapter = new CategoryStrategyAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        isResolveHead();//头部横向rv
        isResolveBottom();//底部纵向gv

    }

    /**
     * 头部横向rv数据解析
     */
    private void isResolveHead() {

        NetHelper.MyRequest(StaticConstant.CATEGORY_STRATEGY_HEAD, CategoryStrategyHeadData.class, new NetListener<CategoryStrategyHeadData>() {
            @Override
            public void successListener(CategoryStrategyHeadData response) {
                /* 适配器上 */
                mAdapter.setDataHead(response);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }

    /**
     * 尾部三布局数据解析
     */
    private void isResolveBottom() {

        NetHelper.MyRequest(StaticConstant.CATEGORY_STRATEGY_BOTTOM, CategoryStrategyBottomData.class, new NetListener<CategoryStrategyBottomData>() {
            @Override
            public void successListener(CategoryStrategyBottomData response) {
                /* 适配器下 */
                mAdapter.setDataBottom(response);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
