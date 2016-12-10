package com.xiaobu.com.xiaobugift.bean.gift;

import java.util.List;

/**
 * Created by xiaoBu on 16/12/7.
 */

public class GiftNextCommentData {

    // http://api.liwushuo.com/v2/items/1076312/comments?limit=20&offset=0
    /**
     * code : 200
     * data : {"comments":[{"content":"好可爱","created_at":1480637675,"id":521632,"images":[],"item_id":1076312,"reply_to_id":null,"show":true,"status":1,"user":{"avatar_url":"http://img01.liwushuo.com/avatar/150210/858f719bd_a.png-w180","can_mobile_login":false,"guest_uuid":null,"id":1304841,"nickname":"Lao茯苓","role":0}}],"paging":{"next_url":"http://api.liwushuo.com/v2/items/1076312/comments?limit=20&offset=20"}}
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
         * comments : [{"content":"好可爱","created_at":1480637675,"id":521632,"images":[],"item_id":1076312,"reply_to_id":null,"show":true,"status":1,"user":{"avatar_url":"http://img01.liwushuo.com/avatar/150210/858f719bd_a.png-w180","can_mobile_login":false,"guest_uuid":null,"id":1304841,"nickname":"Lao茯苓","role":0}}]
         * paging : {"next_url":"http://api.liwushuo.com/v2/items/1076312/comments?limit=20&offset=20"}
         */

        private PagingBean paging;
        private List<CommentsBean> comments;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class PagingBean {
            /**
             * next_url : http://api.liwushuo.com/v2/items/1076312/comments?limit=20&offset=20
             */

            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class CommentsBean {
            /**
             * content : 好可爱
             * created_at : 1480637675
             * id : 521632
             * images : []
             * item_id : 1076312
             * reply_to_id : null
             * show : true
             * status : 1
             * user : {"avatar_url":"http://img01.liwushuo.com/avatar/150210/858f719bd_a.png-w180","can_mobile_login":false,"guest_uuid":null,"id":1304841,"nickname":"Lao茯苓","role":0}
             */

            private String content;
            private int created_at;
            private int id;
            private int item_id;
            private Object reply_to_id;
            private boolean show;
            private int status;
            private UserBean user;
            private List<?> images;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getItem_id() {
                return item_id;
            }

            public void setItem_id(int item_id) {
                this.item_id = item_id;
            }

            public Object getReply_to_id() {
                return reply_to_id;
            }

            public void setReply_to_id(Object reply_to_id) {
                this.reply_to_id = reply_to_id;
            }

            public boolean isShow() {
                return show;
            }

            public void setShow(boolean show) {
                this.show = show;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public List<?> getImages() {
                return images;
            }

            public void setImages(List<?> images) {
                this.images = images;
            }

            public static class UserBean {
                /**
                 * avatar_url : http://img01.liwushuo.com/avatar/150210/858f719bd_a.png-w180
                 * can_mobile_login : false
                 * guest_uuid : null
                 * id : 1304841
                 * nickname : Lao茯苓
                 * role : 0
                 */

                private String avatar_url;
                private boolean can_mobile_login;
                private Object guest_uuid;
                private int id;
                private String nickname;
                private int role;

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public boolean isCan_mobile_login() {
                    return can_mobile_login;
                }

                public void setCan_mobile_login(boolean can_mobile_login) {
                    this.can_mobile_login = can_mobile_login;
                }

                public Object getGuest_uuid() {
                    return guest_uuid;
                }

                public void setGuest_uuid(Object guest_uuid) {
                    this.guest_uuid = guest_uuid;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getRole() {
                    return role;
                }

                public void setRole(int role) {
                    this.role = role;
                }
            }
        }
    }
}
