package com.xiaobu.com.xiaobugift.activity.category;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryStrategyBottomNextAdapter;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomData;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomNextData;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 2016/12/8.
 */

public class CategoryStrategyBottomNextActivity extends BaseActivity {

    private ListView mListView;
    private String mId;

    @Override
    public int setLayout() {
        return R.layout.activity_category_strategy_bottom_next;
    }

    @Override
    public void initView() {

        mListView = (ListView) findViewById(R.id.lv_category_strategy_bottom_next);
    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        Log.d("idAty", mId);


        isResolve();
    }

    private void isResolve() {

        String url = "http://api.liwushuo.com/v2/channels/" + mId + "/items_v2?order_by=now&limit=20&offset=0";
        Log.d("CategoryStrategyBottomN", url);

        NetHelper.MyRequest(url, CategoryStrategyBottomNextData.class, new NetListener<CategoryStrategyBottomNextData>() {
            @Override
            public void successListener(CategoryStrategyBottomNextData response) {

                CategoryStrategyBottomNextAdapter adapter = new CategoryStrategyBottomNextAdapter(getBaseContext());
                adapter.setData(response);
                mListView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
