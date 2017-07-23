package com.yianke.pet.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */

public class Zhixun_bean {


    /**
     * code : 10000
     * data : [{"banndrUrl":"http://www.lanrenzhijia.com/demos/37/3714/demo/images/1.jpg","bannerName":"闲静似娇花照水，行动如弱柳扶风。","id":1,"status":0,"typeId":"1","userId":0,"userName":0},{"banndrUrl":"http://www.lanrenzhijia.com/demos/37/3714/demo/images/2.jpg","bannerName":"态生两靥之愁，娇袭一身之病。","id":2,"status":0,"typeId":"1","userId":0,"userName":0},{"banndrUrl":"http://www.lanrenzhijia.com/demos/37/3714/demo/images/3.jpg","bannerName":"泪光点点，娇喘微微。","id":3,"status":0,"typeId":"1","userId":0,"userName":0},{"banndrUrl":"http://www.lanrenzhijia.com/demos/37/3714/demo/images/4.jpg","bannerName":"闲静似娇花照水，行动如弱柳扶风。","id":4,"status":0,"typeId":"1","userId":0,"userName":0},{"banndrUrl":"http://www.lanrenzhijia.com/demos/37/3714/demo/images/5.jpg","bannerName":"心较比干多一窍，病如西子胜三分。","id":5,"status":0,"typeId":"1","userId":0,"userName":0}]
     * status : true
     * statusCn : 请求成功
     */

    private String code;
    private String status;
    private String statusCn;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
         * banndrUrl : http://www.lanrenzhijia.com/demos/37/3714/demo/images/1.jpg
         * bannerName : 闲静似娇花照水，行动如弱柳扶风。
         * id : 1
         * status : 0
         * typeId : 1
         * userId : 0
         * userName : 0
         */

        private String banndrUrl;
        private String bannerName;
        private int id;
        private int status;
        private String typeId;
        private int userId;
        private int userName;

        public String getBanndrUrl() {
            return banndrUrl;
        }

        public void setBanndrUrl(String banndrUrl) {
            this.banndrUrl = banndrUrl;
        }

        public String getBannerName() {
            return bannerName;
        }

        public void setBannerName(String bannerName) {
            this.bannerName = bannerName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getUserName() {
            return userName;
        }

        public void setUserName(int userName) {
            this.userName = userName;
        }
    }
}
