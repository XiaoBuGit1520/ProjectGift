package com.xiaobu.com.xiaobugift.utils;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by xiaobu on 2016/11/24.
 */

// 注意:此处导入 com.youth.banner.loader.ImageLoader;
public class GlideImageLoader extends ImageLoader {

    // https://github.com/youth5201314/banner   轮播图的官方GitHub

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context).load(path).into(imageView);
    }
}
