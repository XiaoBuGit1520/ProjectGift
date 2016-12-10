package com.xiaobu.com.xiaobugift.fragment.gift;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.adapter.gift.GiftNextCommentAdapter;
import com.xiaobu.com.xiaobugift.base.BaseFragment;
import com.xiaobu.com.xiaobugift.bean.gift.GiftNextCommentData;
import com.xiaobu.com.xiaobugift.utils.volley.NetHelper;
import com.xiaobu.com.xiaobugift.utils.volley.NetListener;

/**
 * Created by xiaoBu on 16/12/3.
 */

public class GiftNextCommentFragment extends BaseFragment {

    private ListView mListView;
    private MyIdBR myIdBR;
    private String mId;
    //private LocalBroadcastManager mLocalBroadcastManager;

    @Override
    public int setLayout() {
        return R.layout.fragment_gift_next_comment;
    }

    @Override
    public void initView(View view) {

        mListView = (ListView) view.findViewById(R.id.lv_gift_next_comment);
    }

    @Override
    public void initData() {

        isBRRegister();//动态注册广播

    }

    /**
     * 解除注册广播
     */
    @Override
    public void onDestroy() {
        // 解除注册
        super.onDestroy();
        getContext().unregisterReceiver(myIdBR);
        //mLocalBroadcastManager.unregisterReceiver(myIdBR);

    }

    /**
     * 动态注册广播
     */
    private void isBRRegister() {
        //mLocalBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        myIdBR = new MyIdBR();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getContext().getPackageName() + ".MyBR");
        getContext().registerReceiver(myIdBR, intentFilter);
        //mLocalBroadcastManager.registerReceiver(myIdBR, intentFilter);

    }

    /**
     * 广播内部类
     */
    class MyIdBR extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // 获取广播中发送的内容
            mId = intent.getStringExtra("idComment");
            Log.d("mId", mId);

            isResolve();//解析评论数据

        }
    }

    /**
     * 拉取网络数据并解析
     */
    private void isResolve() {

        String mUrl = "http://api.liwushuo.com/v2/items/" + mId + "/comments?limit=20&offset=0";
        Log.d("GiftNextCommentFragment", mId);
        Log.d("GiftNextCommentFragment", mUrl);
        NetHelper.MyRequest(mUrl, GiftNextCommentData.class, new NetListener<GiftNextCommentData>() {
            @Override
            public void successListener(GiftNextCommentData response) {
                GiftNextCommentAdapter adapter = new GiftNextCommentAdapter(getContext());
                adapter.setData(response);
                mListView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
    }
}
