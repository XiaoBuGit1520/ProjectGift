package com.xiaobu.com.xiaobugift.activity.category;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.category.CategoryStrategyHeadAdapterNext;
import com.xiaobu.com.xiaobugift.base.BaseActivity;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyHeadNextData;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/12/8.
 */

public class CategoryStrategyHeadNextActivity extends BaseActivity {

    private ListView mListView;
    private String mId;
    private View headView;
    private ImageView ivCoverImageUrl;
    private TextView tvLikesCount;
    private TextView tvTitle;


    @Override
    public int setLayout() {
        return R.layout.activity_category_strategy_head_next;
    }

    @Override
    public void initView() {

        mListView = (ListView) findViewById(R.id.lv_category_strategy_head_next);

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        Log.d("CategoryStrategyHeadNex", mId);

        isResolve();
    }

    private void isResolve() {

        String url = "http://api.liwushuo.com/v2/columns/" + mId + "?limit=20&offset=0";

        NetHelper.MyRequest(url, CategoryStrategyHeadNextData.class, new NetListener<CategoryStrategyHeadNextData>() {
            @Override
            public void successListener(CategoryStrategyHeadNextData response) {

                CategoryStrategyHeadAdapterNext adapterNext = new CategoryStrategyHeadAdapterNext(getBaseContext());
                adapterNext.setData(response);
                mListView.setAdapter(adapterNext);

                /*** ListView头布局 ***/
                // 注入头布局
                headView = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_category_strategy_head_next_list_head, null);
                // ListView加入头布局
                mListView.addHeaderView(headView);
                // 使用用headView绑定头布局内的组件
                ivCoverImageUrl = (ImageView) headView.findViewById(R.id.iv_category_strategy_head_head_next);
                tvLikesCount = (TextView) headView.findViewById(R.id.tv_category_strategy_head_head_next_likes_count);
                tvTitle = (TextView) headView.findViewById(R.id.tv_category_strategy_head_head_next_title);
                // 头布局拉取数据
                Picasso.with(getBaseContext()).load(response.getData().getCover_image_url()).into(ivCoverImageUrl);
                tvLikesCount.setText(response.getData().getLikes_count() + "人喜欢");
                tvTitle.setText(response.getData().getTitle());

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
