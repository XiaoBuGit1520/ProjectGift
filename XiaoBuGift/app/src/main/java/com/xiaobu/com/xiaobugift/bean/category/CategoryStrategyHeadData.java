package com.xiaobu.com.xiaobugift.bean.category;

import java.util.List;

/**
 * Created by xiaoBu on 16/11/28.
 * 分类Fragment 攻略Tab 上方横向rv数据
 */

public class CategoryStrategyHeadData {

    // http://api.liwushuo.com/v2/columns

    /**
     * code : 200
     * data : {"columns":[{"author":"小C","banner_image_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501381,"description":"如果青春不会散场，时光可以珍藏。如果你的每一个米粒大小念想，都能找到与之匹配的美物安放...这样的店你会不会来？","id":5,"order":0,"post_published_at":1480302000,"status":0,"subtitle":"","title":"不打烊的礼物店","updated_at":1480315829},{"author":"三两","banner_image_url":"http://img02.liwushuo.com/image/160905/0i5yxvfy3.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/0i5yxvfy3.jpg?imageView2/2/w/300/q/85/format/webp","category":"爱读书","cover_image_url":"http://img01.liwushuo.com/image/160905/wk7lg4nme.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/wk7lg4nme.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472802190,"description":"多的是，三言两语道不尽之事。三两成群，独言不如众议。二三而成亖，亖亦为四，勤阅必有进步。","id":97,"order":0,"post_published_at":1479805200,"status":0,"subtitle":"","title":"亖言","updated_at":1480304790},{"author":"凹凸曼","banner_image_url":"http://img03.liwushuo.com/image/160708/or81k6fea.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160708/or81k6fea.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img03.liwushuo.com/image/160720/xdt9kjriy.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160720/xdt9kjriy.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467970933,"description":"会买不一定\u201c惠\u201d买，每日10款超低价，举双手奉上。\u2014\u2014from亚马逊良心出品","id":90,"order":0,"post_published_at":1480291200,"status":0,"subtitle":"","title":"省钱大总攻","updated_at":1480304775},{"author":"Miss. talk ","banner_image_url":"http://img03.liwushuo.com/image/160712/3c1fj1dq6.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160712/3c1fj1dq6.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462771521,"description":"同一件事，你怎么想，他怎么看，平行生活里的你我他，也许正经历同样的情绪，分享着类似的槽点，不管你是围观的吃瓜群众，还是森森被困扰的当事人甲，在shall we talk里，和Miss. talk一起聚众吐槽吧~  ","id":24,"order":0,"post_published_at":1480248000,"status":0,"subtitle":"","title":"Shall we talk","updated_at":1480168713},{"author":"W-unique","banner_image_url":"http://img02.liwushuo.com/image/160712/3n3gr96yq.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160712/3n3gr96yq.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img03.liwushuo.com/image/160713/k1h8vhcq2.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/k1h8vhcq2.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1468304391,"description":"网罗世界各地新奇的美食、美食吃法、在吃文化上的稀奇古怪好玩的一档视频类美食栏目。","id":91,"order":0,"post_published_at":1480291200,"status":0,"subtitle":"","title":"Taste新奇体验馆","updated_at":1480068646},{"author":"Dr.Bag","banner_image_url":"http://img03.liwushuo.com/image/161103/q1hgyfj7h.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/161103/q1hgyfj7h.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img02.liwushuo.com/image/161108/aw8q54ale.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/161108/aw8q54ale.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1478153753,"description":"最会挑鞋子包包的老司机，带你2分钟Get最IN流行款","id":119,"order":0,"post_published_at":1480150800,"status":0,"subtitle":"","title":"鞋包研究所","updated_at":1480068621},{"author":"小礼君","banner_image_url":"http://img02.liwushuo.com/image/160905/f5g5ouwkz.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/f5g5ouwkz.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160905/xqyvy9n1z.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/xqyvy9n1z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473045022,"description":"动心的太多，走心的1个足矣","id":106,"order":0,"post_published_at":1480237200,"status":0,"subtitle":"","title":"一个","updated_at":1480067456},{"author":"上上签","banner_image_url":"http://img02.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1480302000,"status":0,"subtitle":"","title":"日复一签","updated_at":1480065590},{"author":"小礼君","banner_image_url":"http://img02.liwushuo.com/image/160901/hnxa6azdx.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160901/hnxa6azdx.jpg?imageView2/2/w/300/q/85/format/webp","category":"活动","cover_image_url":"http://img02.liwushuo.com/image/160901/6uqx378s8.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160901/6uqx378s8.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472708659,"description":"你我的互动让生活更生动","id":95,"order":0,"post_published_at":1480154400,"status":0,"subtitle":"","title":"热门活动","updated_at":1480064252},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160620/kekw305c2.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160620/kekw305c2.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img02.liwushuo.com/image/160713/xqjatns48.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/xqjatns48.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1465721723,"description":"给不了你梦想，那就给你一个梦境。","id":43,"order":0,"post_published_at":1480129200,"status":0,"subtitle":"","title":"跟我去巡店","updated_at":1480063980},{"author":"美物娘","banner_image_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1480291200,"status":0,"subtitle":"","title":"美物收割机","updated_at":1480063165}],"paging":{"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * columns : [{"author":"小C","banner_image_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160713/y2arp77qx.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501381,"description":"如果青春不会散场，时光可以珍藏。如果你的每一个米粒大小念想，都能找到与之匹配的美物安放...这样的店你会不会来？","id":5,"order":0,"post_published_at":1480302000,"status":0,"subtitle":"","title":"不打烊的礼物店","updated_at":1480315829},{"author":"三两","banner_image_url":"http://img02.liwushuo.com/image/160905/0i5yxvfy3.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/0i5yxvfy3.jpg?imageView2/2/w/300/q/85/format/webp","category":"爱读书","cover_image_url":"http://img01.liwushuo.com/image/160905/wk7lg4nme.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/wk7lg4nme.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472802190,"description":"多的是，三言两语道不尽之事。三两成群，独言不如众议。二三而成亖，亖亦为四，勤阅必有进步。","id":97,"order":0,"post_published_at":1479805200,"status":0,"subtitle":"","title":"亖言","updated_at":1480304790},{"author":"凹凸曼","banner_image_url":"http://img03.liwushuo.com/image/160708/or81k6fea.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160708/or81k6fea.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img03.liwushuo.com/image/160720/xdt9kjriy.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160720/xdt9kjriy.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1467970933,"description":"会买不一定\u201c惠\u201d买，每日10款超低价，举双手奉上。\u2014\u2014from亚马逊良心出品","id":90,"order":0,"post_published_at":1480291200,"status":0,"subtitle":"","title":"省钱大总攻","updated_at":1480304775},{"author":"Miss. talk ","banner_image_url":"http://img03.liwushuo.com/image/160712/3c1fj1dq6.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160712/3c1fj1dq6.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/74m5db26q.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462771521,"description":"同一件事，你怎么想，他怎么看，平行生活里的你我他，也许正经历同样的情绪，分享着类似的槽点，不管你是围观的吃瓜群众，还是森森被困扰的当事人甲，在shall we talk里，和Miss. talk一起聚众吐槽吧~  ","id":24,"order":0,"post_published_at":1480248000,"status":0,"subtitle":"","title":"Shall we talk","updated_at":1480168713},{"author":"W-unique","banner_image_url":"http://img02.liwushuo.com/image/160712/3n3gr96yq.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160712/3n3gr96yq.jpg?imageView2/2/w/300/q/85/format/webp","category":"美食","cover_image_url":"http://img03.liwushuo.com/image/160713/k1h8vhcq2.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160713/k1h8vhcq2.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1468304391,"description":"网罗世界各地新奇的美食、美食吃法、在吃文化上的稀奇古怪好玩的一档视频类美食栏目。","id":91,"order":0,"post_published_at":1480291200,"status":0,"subtitle":"","title":"Taste新奇体验馆","updated_at":1480068646},{"author":"Dr.Bag","banner_image_url":"http://img03.liwushuo.com/image/161103/q1hgyfj7h.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/161103/q1hgyfj7h.jpg?imageView2/2/w/300/q/85/format/webp","category":"鞋包","cover_image_url":"http://img02.liwushuo.com/image/161108/aw8q54ale.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/161108/aw8q54ale.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1478153753,"description":"最会挑鞋子包包的老司机，带你2分钟Get最IN流行款","id":119,"order":0,"post_published_at":1480150800,"status":0,"subtitle":"","title":"鞋包研究所","updated_at":1480068621},{"author":"小礼君","banner_image_url":"http://img02.liwushuo.com/image/160905/f5g5ouwkz.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160905/f5g5ouwkz.jpg?imageView2/2/w/300/q/85/format/webp","category":"礼物","cover_image_url":"http://img01.liwushuo.com/image/160905/xqyvy9n1z.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160905/xqyvy9n1z.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1473045022,"description":"动心的太多，走心的1个足矣","id":106,"order":0,"post_published_at":1480237200,"status":0,"subtitle":"","title":"一个","updated_at":1480067456},{"author":"上上签","banner_image_url":"http://img02.liwushuo.com/image/160902/9u68tzum1.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160902/9u68tzum1.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160902/gsscbi494.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472785741,"description":"把对你的爱，写进365首诗里、歌里拥入365天的心里、梦里。","id":96,"order":0,"post_published_at":1480302000,"status":0,"subtitle":"","title":"日复一签","updated_at":1480065590},{"author":"小礼君","banner_image_url":"http://img02.liwushuo.com/image/160901/hnxa6azdx.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160901/hnxa6azdx.jpg?imageView2/2/w/300/q/85/format/webp","category":"活动","cover_image_url":"http://img02.liwushuo.com/image/160901/6uqx378s8.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160901/6uqx378s8.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1472708659,"description":"你我的互动让生活更生动","id":95,"order":0,"post_published_at":1480154400,"status":0,"subtitle":"","title":"热门活动","updated_at":1480064252},{"author":"小礼君","banner_image_url":"http://img01.liwushuo.com/image/160620/kekw305c2.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160620/kekw305c2.jpg?imageView2/2/w/300/q/85/format/webp","category":"涨姿势","cover_image_url":"http://img02.liwushuo.com/image/160713/xqjatns48.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/xqjatns48.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1465721723,"description":"给不了你梦想，那就给你一个梦境。","id":43,"order":0,"post_published_at":1480129200,"status":0,"subtitle":"","title":"跟我去巡店","updated_at":1480063980},{"author":"美物娘","banner_image_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160608/8nluue8yx.jpg?imageView2/2/w/300/q/85/format/webp","category":"美物","cover_image_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160713/zlsbvl5it.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1462501829,"description":"贪念时间所有美好的东西，唯一不吝啬的，就是与你分享。","id":19,"order":0,"post_published_at":1480291200,"status":0,"subtitle":"","title":"美物收割机","updated_at":1480063165}]
         * paging : {"next_url":"http://api.liwushuo.com/v2/columns?limit=11&offset=11"}
         */

        private PagingBean paging;
        private List<ColumnsBean> columns;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<ColumnsBean> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnsBean> columns) {
            this.columns = columns;
        }

        public static class PagingBean {
            /**
             * next_url : http://api.liwushuo.com/v2/columns?limit=11&offset=11
             */

            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ColumnsBean {
            /**
             * author : 小C
             * banner_image_url : http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg-w300
             * banner_webp_url : http://img02.liwushuo.com/image/160608/kd1dy4pi3.jpg?imageView2/2/w/300/q/85/format/webp
             * category : 礼物
             * cover_image_url : http://img01.liwushuo.com/image/160713/y2arp77qx.jpg-w720
             * cover_webp_url : http://img01.liwushuo.com/image/160713/y2arp77qx.jpg?imageView2/2/w/720/q/85/format/webp
             * created_at : 1462501381
             * description : 如果青春不会散场，时光可以珍藏。如果你的每一个米粒大小念想，都能找到与之匹配的美物安放...这样的店你会不会来？
             * id : 5
             * order : 0
             * post_published_at : 1480302000
             * status : 0
             * subtitle :
             * title : 不打烊的礼物店
             * updated_at : 1480315829
             */

            private String author;
            private String banner_image_url;
            private String banner_webp_url;
            private String category;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private String description;
            private int id;
            private int order;
            private int post_published_at;
            private int status;
            private String subtitle;
            private String title;
            private int updated_at;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getBanner_webp_url() {
                return banner_webp_url;
            }

            public void setBanner_webp_url(String banner_webp_url) {
                this.banner_webp_url = banner_webp_url;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getCover_webp_url() {
                return cover_webp_url;
            }

            public void setCover_webp_url(String cover_webp_url) {
                this.cover_webp_url = cover_webp_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getPost_published_at() {
                return post_published_at;
            }

            public void setPost_published_at(int post_published_at) {
                this.post_published_at = post_published_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
