package com.xiaobu.com.xiaobugift.fragment.category;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryOneLeftAdapter;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryOneRightAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneData;
import com.xiaobu.com.xiaobugift.constant.StaticConstant;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by xiaobu on 2016/11/27.
 * 分类Fragment--单品Tab
 */

public class CategoryOneFragment extends BaseFragment {

    private ListView mLvLeft;
    //compile 'se.emilsjolander:stickylistheaders:2.7.0'
    private StickyListHeadersListView mLvRight;
    private int selectIndex = 0;

    @Override
    public int setLayout() {
        return R.layout.fragment_category_one;
    }

    @Override
    public void initView(View view) {

        mLvLeft = (ListView) view.findViewById(R.id.lv_category_one_left);
        mLvRight = (StickyListHeadersListView) view.findViewById(R.id.lv_category_one_right);

    }

    @Override
    public void initData() {

        isResolve();//解析
    }

    /**
     * 解析部分(全部)
     */
    private void isResolve() {

        NetHelper.MyRequest(StaticConstant.CATEGORY_ONE_URL, CategoryOneData.class, new NetListener<CategoryOneData>() {
            @Override
            public void successListener(CategoryOneData response) {

                final CategoryOneLeftAdapter adapterL = new CategoryOneLeftAdapter(getContext());
                final CategoryOneRightAdapter adapterR = new CategoryOneRightAdapter(getContext());

                adapterR.setData(response);
                adapterL.setData(response);

                mLvLeft.setAdapter(adapterL);//左
                mLvRight.setAdapter(adapterR);//右

                /* ListView联动部分 */
                // 左
                mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        adapterL.setSelect(position);//刷新数据

                        //当点击某个item的时候让这个item自动滑动到listview的首位(下面item够多，如果点击的是最后一个就不能到达顶部了)
                        mLvLeft.smoothScrollToPositionFromTop(position, 0);//暂时不好使
                        adapterR.setIndex(position);//暂时不好使,适配器内方法没有用上

                        mLvRight.setSelection(position);

                    }
                });

                // 右
                mLvRight.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {

                        // scrollState: 滚动状态 实测似乎只有0,1,2三个值
                    }

                    /**
                     * onScroll()--正在滚动
                     * firstVisibleItem第一个Item的位置
                     * visibleItemCount 可见的Item的数量
                     * totalItemCount item的总数
                     */
                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                        mLvLeft.smoothScrollToPositionFromTop(firstVisibleItem, 0);
                        adapterL.setIndex(firstVisibleItem);
                        mLvLeft.setSelection(firstVisibleItem);//适配器中自定义方法
                        adapterL.notifyDataSetChanged();//一定要加

                    }
                });

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
