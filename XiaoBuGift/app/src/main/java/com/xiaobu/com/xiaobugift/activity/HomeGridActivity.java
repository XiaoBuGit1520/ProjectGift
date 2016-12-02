package com.xiaobu.com.xiaobugift.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.home.HomeGridAdapterNext;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.bean.home.HomeGridDataNext;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/12/2.
 * 首页--精选--六宫格GridView--二级界面
 */

public class HomeGridActivity extends BaseActivity {

    private ListView mListView;

    @Override
    public int setLayout() {
        return R.layout.activity_homegrid;
    }

    @Override
    public void initView() {

        mListView = (ListView) findViewById(R.id.lv_home_grid_next);

    }

    @Override
    public void initData() {

        isGridNextResolve();

    }

    /**
     * 六宫格二级界面解析
     */
    private void isGridNextResolve() {

        Intent intent = getIntent();
        String idGrid = intent.getStringExtra("keyGrid");
        Log.d("HomeGridActivity", idGrid);
        idGrid = idGrid.substring(idGrid.length() - 3, idGrid.length());

        String url = "http://api.liwushuo.com/v2/collections/" + idGrid + "/posts?limit=20&offset=0";

        NetHelper.MyRequest(url, HomeGridDataNext.class, new NetListener<HomeGridDataNext>() {
            @Override
            public void successListener(HomeGridDataNext response) {
                HomeGridAdapterNext adapter = new HomeGridAdapterNext(getBaseContext());
                adapter.setData(response);
                mListView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
