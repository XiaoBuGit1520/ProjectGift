package com.xiaobu.com.xiaobugift.adapter.category;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xiaobu.com.xiaobugift.R;
import com.xiaobu.com.xiaobugift.activity.category.CategoryStrategyBottomNextActivity;
import com.xiaobu.com.xiaobugift.bean.category.CategoryStrategyBottomData;

/**
 * Created by xiaoBu on 16/12/8.
 */

public class CategoryStrategyGvAdapterMid extends BaseAdapter {

    private Context mContext;
    private CategoryStrategyBottomData data;

    public CategoryStrategyGvAdapterMid(Context context) {
        mContext = context;
    }

    public void setData(CategoryStrategyBottomData data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? 6 : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().getChannel_groups().get(1).getChannels().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderMid holderMid = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_category_strategy_bottom_middle, parent, false);
            holderMid = new ViewHolderMid(convertView);
            convertView.setTag(holderMid);

        } else {

            holderMid = (ViewHolderMid) convertView.getTag();

        }

        Picasso.with(mContext).load(data.getData().getChannel_groups().get(1).getChannels().get(position).getCover_image_url()).into(holderMid.ivMid);

        /*** 获取并发送对应图片的Id ***/
        final String id = data.getData().getChannel_groups().get(1).getChannels().get(position).getId() + "";
        //Log.d("id", id);

        holderMid.ivMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CategoryStrategyBottomNextActivity.class);
                intent.putExtra("id", id);
                mContext.startActivity(intent);
                Log.d("id", id);
            }
        });
        return convertView;


    }

    /**
     * 中部缓存类
     */
    private class ViewHolderMid {

        private ImageView ivMid;

        private ViewHolderMid(View view) {

            ivMid = (ImageView) view.findViewById(R.id.iv_category_strategy_bottom_mid);

        }
    }
}
