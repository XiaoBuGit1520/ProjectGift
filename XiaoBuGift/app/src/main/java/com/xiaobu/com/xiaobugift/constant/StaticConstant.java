package com.xiaobu.com.xiaobugift.constant;

/**
 * Created by xiaoBu on 16/11/23.
 * 静态常量(url接口合集)
 */
// IllegalStateException非法语句异常
public class StaticConstant {

    // 首页Fragment Tab标题
    public static final String HOME_TAB_URL = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2";
    // 首页Fragment 精选 主内容
    public static final String HOME_CHOICE_URL = "http://api.liwushuo.com/v2/channels/101/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0";
    // 首页Fragment 精选 轮播图
    public static final String HOME_CHOICE_GLIDE = "http://api.liwushuo.com/v2/banners";
    // 首页Fragment 精选 六宫格
    public static final String HOME_CHOICE_GRID = "http://api.liwushuo.com/v2/secondary_banners?gender=1&generation=2";
    // 榜单Fragment Tab标题
    public static final String GIFT_TAB_URL = "http://api.liwushuo.com/v2/ranks_v2/ranks";
    // 分类Fragment 攻略Tab 上方横向rv
    public static final String CATEGORY_STRATEGY_HEAD = "http://api.liwushuo.com/v2/columns";
    // 分类Fragment 攻略Tab 下方纵向rv
    public static final String CATEGORY_STRATEGY_BOTTOM = "http://api.liwushuo.com/v2/channel_groups/all";
    // 分类Fragment 单品Tab ListView联动
    public static final String CATEGORY_ONE_URL = "http://api.liwushuo.com/v2/item_categories/tree";
}
