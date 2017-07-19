package com.yianke.pet.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9 0009.
 */

public class Talk_bean {


    /**
     * data : [{"createTime":1497024000000,"createUser":1,"goods":10,"id":1,"label":"1","navigationId":8,"postsContent":"测试论坛content","postsImg":"https://img.alicdn.com/imgextra/i1/1806106061448253383/TB2DuY9wAqvpuFjSZFhXXaOgXXa_!!0-saturn_solar.jpg_240x240.jpg","postsName":"测试论坛title","priority":"1","state":"Y"},{"createTime":1497024000000,"createUser":1,"goods":0,"id":2,"label":"1","navigationId":8,"postsContent":"测试论坛content","postsImg":"https://img.alicdn.com/imgextra/i1/1806106061448253383/TB2DuY9wAqvpuFjSZFhXXaOgXXa_!!0-saturn_solar.jpg_240x240.jpg","postsName":"测试论坛title","priority":"1","state":"Y"},{"createTime":1497024000000,"createUser":1,"goods":0,"id":3,"label":"1","navigationId":8,"postsContent":"测试论坛content","postsImg":"https://img.alicdn.com/imgextra/i1/1806106061448253383/TB2DuY9wAqvpuFjSZFhXXaOgXXa_!!0-saturn_solar.jpg_240x240.jpg","postsName":"测试论坛title","priority":"1","state":"Y"},{"createTime":1497024000000,"createUser":1,"goods":0,"id":4,"label":"1","navigationId":8,"postsContent":"测试论坛content","postsImg":"https://img.alicdn.com/imgextra/i1/1806106061448253383/TB2DuY9wAqvpuFjSZFhXXaOgXXa_!!0-saturn_solar.jpg_240x240.jpg","postsName":"测试论坛title","priority":"1","state":"Y"},{"createTime":1497024000000,"createUser":1,"goods":0,"id":5,"label":"1","navigationId":8,"postsContent":"测试论坛content","postsImg":"https://img.alicdn.com/imgextra/i1/1806106061448253383/TB2DuY9wAqvpuFjSZFhXXaOgXXa_!!0-saturn_solar.jpg_240x240.jpg","postsName":"测试论坛title","priority":"1","state":"Y"},{"createTime":1497024000000,"createUser":1,"goods":0,"id":6,"label":"1","navigationId":8,"postsContent":"测试论坛content","postsImg":"https://img.alicdn.com/imgextra/i1/1806106061448253383/TB2DuY9wAqvpuFjSZFhXXaOgXXa_!!0-saturn_solar.jpg_240x240.jpg","postsName":"测试论坛title","priority":"1","state":"Y"}]
     * msgCode : 10000
     * status : true
     * statusCn : 请求成功
     */

    private String msgCode;
    private String status;
    private String statusCn;
    private List<DataBean> data;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCn() {
        return statusCn;
    }

    public void setStatusCn(String statusCn) {
        this.statusCn = statusCn;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : 1497024000000
         * createUser : 1
         * goods : 10
         * id : 1
         * label : 1
         * navigationId : 8
         * postsContent : 测试论坛content
         * postsImg : https://img.alicdn.com/imgextra/i1/1806106061448253383/TB2DuY9wAqvpuFjSZFhXXaOgXXa_!!0-saturn_solar.jpg_240x240.jpg
         * postsName : 测试论坛title
         * priority : 1
         * state : Y
         */

        private long createTime;
        private int createUser;
        private int goods;
        private int id;
        private String label;
        private int navigationId;
        private String postsContent;
        private String postsImg;
        private String postsName;
        private String priority;
        private String state;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public int getGoods() {
            return goods;
        }

        public void setGoods(int goods) {
            this.goods = goods;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getNavigationId() {
            return navigationId;
        }

        public void setNavigationId(int navigationId) {
            this.navigationId = navigationId;
        }

        public String getPostsContent() {
            return postsContent;
        }

        public void setPostsContent(String postsContent) {
            this.postsContent = postsContent;
        }

        public String getPostsImg() {
            return postsImg;
        }

        public void setPostsImg(String postsImg) {
            this.postsImg = postsImg;
        }

        public String getPostsName() {
            return postsName;
        }

        public void setPostsName(String postsName) {
            this.postsName = postsName;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
