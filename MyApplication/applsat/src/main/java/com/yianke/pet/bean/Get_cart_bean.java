package com.yianke.pet.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class Get_cart_bean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : 1498234105000
         * geared : 322
         * id : 1
         * index : 3231`
         * label : 32
         * navigation : 32
         * number : 31
         * picture : 32
         * price : 32
         * productDis : 3232
         * productId : 2
         * productName : 3232
         * shopName : 3131
         * state : 3
         * status : 0
         * stock : 32
         * userId : 3
         * userName : 32
         */

        private long createTime;
        private String geared;
        private String id;
        private String index;
        private String label;
        private String navigation;
        private String number;
        private String picture;
        private String price;
        private String productDis;
        private String productId;
        private String productName;
        private String shopName;
        private String state;
        private int status;
        private String stock;
        private int userId;
        private String userName;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getGeared() {
            return geared;
        }

        public void setGeared(String geared) {
            this.geared = geared;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getNavigation() {
            return navigation;
        }

        public void setNavigation(String navigation) {
            this.navigation = navigation;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getProductDis() {
            return productDis;
        }

        public void setProductDis(String productDis) {
            this.productDis = productDis;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
