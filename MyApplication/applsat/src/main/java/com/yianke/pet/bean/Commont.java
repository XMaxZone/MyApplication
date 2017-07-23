package com.yianke.pet.bean;

import java.util.Date;

/**
 * @Author huc 评论表
 * @JDK 1.7
 * @since 2017/6/9
 */
public class Commont {

    private long id;
    private long fromUserId;
    private long toUserId;
    private String content;
    private long postsId;
    private long postsUser;
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getPostsId() {
        return postsId;
    }

    public void setPostsId(long postsId) {
        this.postsId = postsId;
    }

    public long getPostsUser() {
        return postsUser;
    }

    public void setPostsUser(long postsUser) {
        this.postsUser = postsUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Commont{");
        sb.append("id=").append(id);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", toUserId=").append(toUserId);
        sb.append(", content='").append(content).append('\'');
        sb.append(", postsId=").append(postsId);
        sb.append(", postsUser=").append(postsUser);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
