package com.yianke.pet.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by huc on 2017/7/23.
 */

public class Posts {


    private long id;
    private long navigationId;
    private String postsName;
    private String postsContent;
    private String priority;
    private long createUser;
    private String label;
    private String postsImg;
    private Date createTime;
    private String state;
    private int goods;
    private List<Commont> commontList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(long navigationId) {
        this.navigationId = navigationId;
    }

    public String getPostsName() {
        return postsName;
    }

    public void setPostsName(String postsName) {
        this.postsName = postsName;
    }

    public String getPostsContent() {
        return postsContent;
    }

    public void setPostsContent(String postsContent) {
        this.postsContent = postsContent;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(long createUser) {
        this.createUser = createUser;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPostsImg() {
        return postsImg;
    }

    public void setPostsImg(String postsImg) {
        this.postsImg = postsImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", navigationId=" + navigationId +
                ", postsName='" + postsName + '\'' +
                ", postsContent='" + postsContent + '\'' +
                ", priority='" + priority + '\'' +
                ", createUser=" + createUser +
                ", label='" + label + '\'' +
                ", postsImg='" + postsImg + '\'' +
                ", createTime=" + createTime +
                ", state='" + state + '\'' +
                ", goods=" + goods +
                '}';
    }
    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }
}
