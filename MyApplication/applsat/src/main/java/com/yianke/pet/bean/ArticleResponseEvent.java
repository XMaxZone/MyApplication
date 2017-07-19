package com.yianke.pet.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8 0008.
 */

public class ArticleResponseEvent {


    /**
     * code : 10000
     * data : [{"articleImage":"http://www.lanrenzhijia.com/demos/37/3714/demo/images/1.jpg","articleName":"英国留学申请解答 ","author":"永登人","content":" 英国一直针对985、211和双非背景的同学有不同的要求，这也为同学们的申请拉开了梯度。申请前一定要好好研究好自己的背景条件，根据背景条件去选择学校。英国好就好在可以一次算多所学校，同学们可以视自身情况来选择，冲刺的、核心的、保底的，这样一定可以保证有 Offer 来敲门。 ","createTime":1496668571000,"description":"足够优秀的背景条件 ","id":8,"modifyTime":1496668573000,"navigation":4,"releaseDate":1496668655000,"status":0,"userId":0,"userName":0}]
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
         * articleImage : http://www.lanrenzhijia.com/demos/37/3714/demo/images/1.jpg
         * articleName : 英国留学申请解答
         * author : 永登人
         * content :  英国一直针对985、211和双非背景的同学有不同的要求，这也为同学们的申请拉开了梯度。申请前一定要好好研究好自己的背景条件，根据背景条件去选择学校。英国好就好在可以一次算多所学校，同学们可以视自身情况来选择，冲刺的、核心的、保底的，这样一定可以保证有 Offer 来敲门。
         * createTime : 1496668571000
         * description : 足够优秀的背景条件
         * id : 8
         * modifyTime : 1496668573000
         * navigation : 4
         * releaseDate : 1496668655000
         * status : 0
         * userId : 0
         * userName : 0
         */

        private String articleImage;
        private String articleName;
        private String author;
        private String content;
        private long createTime;
        private String description;
        private int id;
        private long modifyTime;
        private int navigation;
        private long releaseDate;
        private int status;
        private int userId;
        private int userName;

        public String getArticleImage() {
            return articleImage;
        }

        public void setArticleImage(String articleImage) {
            this.articleImage = articleImage;
        }

        public String getArticleName() {
            return articleName;
        }

        public void setArticleName(String articleName) {
            this.articleName = articleName;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
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

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getNavigation() {
            return navigation;
        }

        public void setNavigation(int navigation) {
            this.navigation = navigation;
        }

        public long getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(long releaseDate) {
            this.releaseDate = releaseDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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
