package com.yianke.pet.Common;

import okhttp3.MediaType;

/**
 * Title:常量工具类
 * Created by huc on 2017/7/19.
 */

public abstract class Constants {

    /** 服务器ip 端口号 **/
    public static  final String IP_PORT = "http://119.28.20.68:8080";

    /** 网络请求参数数据类型 **/
    public static final MediaType REQUEST_PARAMERS_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    /** 文章详情web view URL **/
    public static final String  ARTICLE_DETAIL_WEBVIEW_URL = IP_PORT + "/goodlifeadmin/webview/article/index.html?id=";

    /** 获取文章列表
     *
     * **/
    public static final String ARTICLE_FIND_LIST_URL = IP_PORT + "/GoodlifeApi/api/v1/article/get";

    /** 获取文章详情  **/
    public static final String ARTICLE_DETAIL_URL = IP_PORT + "/GoodlifeApi/api/v1/article/get";

    /** 获取顶部Banner广告
     *
     **/
    public static final String FIND_TOP_BANNER_URL = IP_PORT + "/GoodlifeApi/api/v1/banner/get";

    /** 发表帖子评论接口
     * data={"fromUserId":"1","toUserId":"2","postsId":"8","postsUser":"3","content":"hello"}
     **/
    public static final  String ADD_POSTING_URL = IP_PORT + "/GoodlifeApi/api/v1/posts/addCommont";

    /**
     * 获取论坛帖子列表
     * data={"navigationId":"8"}
     */
    public static final String FIND_POST_LIST_URL = IP_PORT + "/GoodlifeApi/api/v1/posts/findList";

    /**
     * 获取论坛帖子详情
     * data={"navigationId":"8","id":"2"}
     */
    public static final String FIND_POST_DETAIL_URL = IP_PORT + "/GoodlifeApi/api/v1/posts/findList";

    /**
     * 帖子点赞
     * data={"fromUserId":"1","toUserId":"2","postsId":"8","createUserId":"3"}
     */
    public static final String ADD_POST_GOOD_URL = IP_PORT + "/GoodlifeApi/api/v1/posts/like";

    /**
     * 发表帖子评论接口
     * data={"fromUserId":"1","toUserId":"2","postsId":"8","postsUser":"3","content":"hello"}
     */
    public static final String ADD_POST_COMMONT_URL = IP_PORT + "/GoodlifeApi/api/v1/posts/addCommont";

    /**
     * 删除帖子接口
     * data={"id","2"}
     */
    public static final String DELETE_POST_URL = IP_PORT + "/GoodlifeApi/api/v1/posts/delete";

    /**
     * 导航菜单
     * 菜单状态 1:资讯导航 2:论坛导航 3:商城导航
     * data={"state":"1"}
     */
    public static final String FIND_NAVIGATION_URL = IP_PORT + "/GoodlifeApi/api/v1/navigation/get";

    /**
     * 获取商城首页
     * data={}
     */
    public static final String  FIND_SHOP_INDEX_URL = IP_PORT + "/GoodlifeApi/api/v1/product/index";

    /**
     * 删除订单
     * data={"id":"1"}
     */
    public static final String DELETE_SHOP_PRODUCT_ORDER_URL = IP_PORT + "/GoodlifeApi/api/v1/order/delete";

    /**
     *
     */



}
