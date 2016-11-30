package com.xiaobu.com.xiaobugift.fragment.category;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryOneLeftAdapter;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryOneRightAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneData;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by xiaobu on 2016/11/27.
 * 分类Fragment--单品Tab
 */

public class CategoryOneFragment extends BaseFragment {

    private ListView mLvLeft;
    private StickyListHeadersListView mLvRight;
    private ArrayList<String> headList, bodyList;

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

        headList = new ArrayList<>();
        bodyList = new ArrayList<>();

        String url = "http://api.liwushuo.com/v2/item_categories/tree";

        /**
         *
         */
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                CategoryOneData data = gson.fromJson(response, CategoryOneData.class);

                CategoryOneLeftAdapter adapterL = new CategoryOneLeftAdapter(getContext());
                CategoryOneRightAdapter adapterR = new CategoryOneRightAdapter(getContext());

                adapterR.setData(data);
                adapterL.setData(data);

                mLvLeft.setAdapter(adapterL);
                mLvRight.setAdapter(adapterR);

                /* 监听 */
                mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        mLvRight.setSelection(position);
                    }
                });

                mLvRight.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {

                    }

                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                        mLvLeft.smoothScrollToPositionFromTop(firstVisibleItem, 0);
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }


}
