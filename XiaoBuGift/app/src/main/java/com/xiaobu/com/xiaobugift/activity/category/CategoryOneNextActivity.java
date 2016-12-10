package com.xiaobu.com.xiaobugift.activity.category;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryOneRightNextAdapter;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneData;
import com.xiaobu.com.xiaobugift.bean.category.CategoryOneNextData;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 2016/12/9.
 */

public class CategoryOneNextActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private String mId;

    @Override
    public int setLayout() {
        return R.layout.activity_category_one_next;
    }

    @Override
    public void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_category_one_next);

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        Log.d("CategoryOneNextActivity", mId);

        isResolve();

    }

    private void isResolve() {

        String url = "http://api.liwushuo.com/v2/item_subcategories/" + mId + "/items?limit=20&offset=0";

        NetHelper.MyRequest(url, CategoryOneNextData.class, new NetListener<CategoryOneNextData>() {
            @Override
            public void successListener(CategoryOneNextData response) {

                CategoryOneRightNextAdapter adapter = new CategoryOneRightNextAdapter(getBaseContext());
                adapter.setData(response);
                mRecyclerView.setAdapter(adapter);
                GridLayoutManager manager = new GridLayoutManager(getBaseContext(), 2);
                mRecyclerView.setLayoutManager(manager);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
