package com.xiaobu.com.xiaobugift.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.HomeChoiceWebActivity;
import com.xiaobu.com.xiaobugift.activity.HomeUseWebActivity;
import com.xiaobu.com.xiaobugift.adapter.home.HomeTabAdapter;
import com.xiaobu.com.xiaobugift.adapter.home.HomeUseAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.home.HomeUseData;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/11/23.
 * 首页---复用的Fragment模板
 */
public class HomeUseFragment extends BaseFragment {

    private ListView mListView;
    private HomeUseAdapter adapter;
    private String path;
    private HomeUseData mHomeUseData;//定义复用的实体类

    @Override
    public int setLayout() {
        return R.layout.fragment_homeuse;
    }

    @Override
    public void initView(View view) {

        mListView = (ListView) view.findViewById(R.id.lv_home_use);
    }

    @Override
    public void initData() {

        isBundle();//接收传值
        isResolve();//解析
    }


    /**
     * newInstance() Fragment复用方法
     * 传值操作
     *
     * @param position
     * @return
     */
    public static HomeUseFragment newInstance(int position) {

        Bundle args = new Bundle();

        args.putInt("key", position);

        String message = HomeTabAdapter.getMessage(position);
        args.putString("key", message);

        HomeUseFragment fragment = new HomeUseFragment();
        fragment.setArguments(args);
        return fragment;

    }

    /**
     * 接收传值(Bundle)
     */
    private void isBundle() {

        Bundle bundle = getArguments();
        String msg = bundle.get("key").toString();
        // 网址拼接
        path = "http://api.liwushuo.com/v2/channels/" + msg + "/items_v2?gender=1&limit=20&offset=0&generation=2";
    }

    /**
     * 请求网络数据并解析--首页复用的数据
     * (Volley + Gson)
     */
    private void isResolve() {

        mHomeUseData = new HomeUseData();

        NetHelper.MyRequest(path, HomeUseData.class, new NetListener<HomeUseData>() {
            @Override
            public void successListener(HomeUseData response) {
                /* 适配器 */
                // 初始化适配器
                adapter = new HomeUseAdapter(getContext());
                // 给适配器(BaseAdapter)加入解析后的数据
                adapter.setData(response);
                // 绑定适配器
                mListView.setAdapter(adapter);

                mHomeUseData = response;
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
        /* ListView监听事件 */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String idUseHomeTabNext = mHomeUseData.getData().getItems().get(position).getId() + "";
                Intent intent = new Intent(getContext(), HomeUseWebActivity.class);
                intent.putExtra("KeyHomeUse", idUseHomeTabNext);
                startActivity(intent);

            }
        });
    }


}



