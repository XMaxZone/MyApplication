package com.yianke.pet.view.child;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.picasso.Picasso;
import com.yianke.pet.Common.Constants;
import com.yianke.pet.R;
import com.yianke.pet.adapter.home.JXAdapter;
import com.yianke.pet.bean.Posts;
import com.yianke.pet.bean.Talk_bean;
import com.yianke.pet.bean.Zhixun_bean;
import com.yianke.pet.model.home.JXModel;
import com.yianke.pet.utils.BaseHandler;
import com.yianke.pet.utils.Constances;
import com.yianke.pet.view.fragment.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

/**
 * 作者：${赵若位} on 2017/6/6 10:20
 * 邮箱：1070138445@qq.com
 * 功能：
 */

public class JXFragment extends BaseFragment
{
    @BindView(R.id.jx_main)
    ListView mJxMain;
    Unbinder mUnbinder;

    private JXAdapter mAdapter;
    private List<JXModel> mJxList;

    private ViewPager mJxBanner;
    private ImageView mJxOne;
    private ImageView mJxTwo;
    private ImageView mJxThree;
    private ImageView mJxFour;
    private ImageView mJxFive;
    private Talk_bean talk_bean;
    private List<Talk_bean.DataBean> dataBeanList;

    private List<String> myimages= new ArrayList<String>();

    private Zhixun_bean zhixun_bean;
    private List<Zhixun_bean.DataBean> advdataBeen;
    private List<String> imagesdata;
    private List<String> tittles;


    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mAdapter = new JXAdapter(getActivity(),mJxList,dataBeanList);
                    mJxMain.setAdapter(mAdapter);
                    break;
                case 2:

                    ImageView mView;
                    for (int i = 0; i < myimages.size(); i++)
                    {
                        mView = new ImageView(getActivity());
                        Picasso.with(getActivity()).load(myimages.get(i)).resize(621, 238).into(mView);
                        mList.add(mView);
                    }

                    mJxBanner.setAdapter(new BannerAdapter());
                    isStart = true;
                    startBanner();
                    //******************************轮播窗口*************************************//
//                  String[] images =
//                            {
//
////                    myimages.get(0)
//
//                                    //
//                   /* R.drawable.jx_header_1,
//                    R.drawable.jx_header_2,
//                    R.drawable.jx_header_3,
//                    R.drawable.jx_header_4,
//                    R.drawable.jx_header_5,*/
//                            };
                    break;
            }
            return false;
        }
    });






    Map map = new HashMap();
    JSONObject jsonObject = (JSONObject) new JSONObject().put("id","2");

    //private String[] images = null;
//   String resurl = new HttpClient().HttpPostRequest(Constants.FIND_TOP_BANNER_URL,jsonObject);




    /**
     * 网络请求成功的回调方法
     * @param result
     */
    public void success(String result){
        System.out.print(result);
    }

    /**
     * 网络请求失败的回调方法
     * @param resurt
     */
    public void failure(String resurt){

    }



    private List<ImageView> mList;
    private BaseHandler<JXFragment> mHandler = new BaseHandler<JXFragment>(this)
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            resetDic();
            switch (msg.what % myimages.size())
            {
                case 0:
                    mJxOne.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(0);
                    break;
                case 1:
                    mJxTwo.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(1);
                    break;
                case 2:
                    mJxThree.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(2);
                    break;
                case 3:
                    mJxFour.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(3);
                    break;
                case 4:
                    mJxFive.setBackgroundResource(R.drawable.shape_jx_circle_white);
                    mJxBanner.setCurrentItem(4);
                    break;
                default:
                    break;
            }
        }
    };
    private boolean isStart = false;
    //*******************************************************************//


    @Override
    public int getResource()
    {
        return R.layout.fragment_jx;
    }

    @Override
    public void init(View view)
    {
        ButterKnife.bind(this, view);

    }

    private void getdata() {
        String url = Constances.luntan;

        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                            processdata(response);
                    }
                });
    }

    private void processdata(String response) {
        talk_bean = JSONparse(response);
        dataBeanList = talk_bean.getData();
        if (response!=null){
            handler.sendEmptyMessage(1);
        }

    }

    private Talk_bean JSONparse(String response) {
        return JSON.parseObject(response,Talk_bean.class);
    }

    @Override
    public void loadingDatas()
    {
        mJxList = new ArrayList<>();
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        mJxList.add(new JXModel());
        getdata();

        View header = LayoutInflater.from(getActivity()).inflate(R.layout.header_jx, null);
        mJxMain.addHeaderView(header);

        mJxBanner = (ViewPager) header.findViewById(R.id.header_banner);
        mJxOne = (ImageView) header.findViewById(R.id.dic_1);
        mJxTwo = (ImageView) header.findViewById(R.id.dic_2);
        mJxThree = (ImageView) header.findViewById(R.id.dic_3);
        mJxFour = (ImageView) header.findViewById(R.id.dic_4);
        mJxFive = (ImageView) header.findViewById(R.id.dic_5);

        mList = new ArrayList<>();
        GetHttpdata(Constants.FIND_TOP_BANNER_URL + "?data={\"typeId\":\"2\"}");
//        Log.e("TAG","----------------------------------"+images.length);
//        ImageView mView;
//        for (int i = 0; i < images.length; i++)
//        {
//            mView = new ImageView(getActivity());
//            Picasso.with(getActivity()).load(images[i]).resize(621, 238).into(mView);
//            mList.add(mView);
//        }
//
//        mJxBanner.setAdapter(new BannerAdapter());
//        isStart = true;
//        startBanner();
        //data={"navigationId":"8"}
        getPotsList(Constants.FIND_POST_LIST_URL+"?data={\"navigationId\":\"8\"}");

    }



    public String getPotsList(String url){
        final String result = "";
        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG",e.getMessage());

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        String succeend = response.replaceAll("succeend", "");
                        JXModel jxModel = JSON.parseObject(succeend, JXModel.class);
                        List<Posts> data = jxModel.getData();
                        for (Posts p: data) {

                            Log.e("TAG",p.getPostsName());
                        }

                    }
                });



        return "";
    }





    public String[] GetHttpdata(String url ){
        final String[] result = null;

        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG","error"+e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        response = response.replaceAll("succeend","");

                        Log.e("TAG","succeend"+response);
                        Zhixun_bean zhixun_bean = JSON.parseObject(response, Zhixun_bean.class);

                        List<Zhixun_bean.DataBean> data = zhixun_bean.getData();
                        Log.e("TAG","account"+data.size());
                        for (int i=0;i<data.size();i++) {
                           // images[i] = data.get(i).getBanndrUrl();

                            myimages.add(data.get(i).getBanndrUrl());

                        }
                        handler.sendEmptyMessage(2);
                    }
                });
        return result;
    }




    @Override
    public void startdestroy()
    {
        mUnbinder.unbind();
        mAdapter = null;
        mList = null;
        mHandler = null;
    }


    /**
     * 重置指示器
     */
    private void resetDic()
    {
        mJxOne.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxTwo.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxThree.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxFour.setBackgroundResource(R.drawable.shape_jx_circle_c);
        mJxFive.setBackgroundResource(R.drawable.shape_jx_circle_c);
    }

    private void startBanner()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                super.run();
                int position = 0;
                while (isStart)
                {
                    mHandler.sendEmptyMessage(position++);
                    try
                    {
                        Thread.sleep(5000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    /**
     * 图片Banner滚动播放器
     */
    private class BannerAdapter extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return myimages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            container.addView(mList.get(position));
            return mList.get(position);
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        isStart = false;
    }


    @Override
    public void onResume()
    {
        super.onResume();
        isStart = true;
    }
}

