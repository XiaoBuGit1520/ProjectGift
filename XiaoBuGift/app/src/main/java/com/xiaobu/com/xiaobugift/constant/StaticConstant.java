package com.xiaobu.com.xiaobugift.constant;

/**
 * Created by dllo on 16/11/23.
 */

public class StaticConstant {

    // 首页Fragment TabLayout标题
    public static final String HOME_TAB_URL = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2";
    // 首页Fragment 精选 主内容
    public static final String HOME_CHOICE_URL = "http://api.liwushuo.com/v2/channels/101/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0";
    // 首页Fragment 精选 轮播图
    public static final String HOME_CHOICE_GLIDE = "http://api.liwushuo.com/v2/banners";
    // 首页Fragment 精选 六宫格
    public static final String HOME_CHOICE_GRID = "http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=2";
}
