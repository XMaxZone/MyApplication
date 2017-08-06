package com.yianke.pet.view.child;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;
import com.yianke.pet.R;
import com.yianke.pet.adapter.msg.MsgChildAdapter;
import com.yianke.pet.adapter.msg.ZazhiAdapter;
import com.yianke.pet.bean.ArticleResponseEvent;
import com.yianke.pet.model.msg.MsgChildModel;
import com.yianke.pet.model.msg.ZazhiModel;
import com.yianke.pet.utils.BaseHandler;
import com.yianke.pet.utils.Constances;
import com.yianke.pet.view.fragment.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

/**
 * 作者：赵若位
 * 时间：2017/6/19 19:34
 * 功能：资讯---杂志页面
 */

public class ZazhiFragment extends BaseFragment
{
  /*  @BindView(R.id.zhazi_recycler)
    RecyclerView mZhaziRecycler;
    @BindView(R.id.zazhi_viewPager)
    ViewPager mZazhiViewPager;
    @BindView(R.id.inidc1)
    ImageView mInidc1;
    @BindView(R.id.inidc2)
    ImageView mInidc2;
    @BindView(R.id.inidc3)
    ImageView mInidc3;
    @BindView(R.id.inidc4)
    ImageView mInidc4;
    @BindView(R.id.inidc5)
    ImageView mInidc5;
    @BindView(R.id.titles)
    TextView mTitles;
    Unbinder unbinder;

    private List<ZazhiModel> mList;
    private ZazhiAdapter mAdapter;


    /*//*************************轮播滚动******************************//*/
    private int[] images =
            {
                    R.drawable.banner_zazhi1,
                    R.drawable.banner_zazhi2,
                    R.drawable.banner_zazhi3,
                    R.drawable.banner_zazhi4,
                    R.drawable.banner_zazhi5
            };
    private String[] titles =
            {
                    "封面故事--《家·猫·果实》",
                    "专题巨献--《帝苑猫说》",
                    "封面故事--《戏痞士与惊魂鸟》",
                    "活着--《生存游戏》",
                    "专题巨献--《猎场》"
            };
    private List<View> mViewList;
    private boolean isBanner = false;
    private BaseHandler<ZazhiFragment> mHandler = new BaseHandler<ZazhiFragment>(this)
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            mZazhiViewPager.setCurrentItem(msg.what % images.length);
        }
    };

    /*//*******************************************************//*/


    @Override
    public int getResource()
    {
        return R.layout.fragment_zhazi;
    }

    @Override
    public void init(View view)
    {
        unbinder = ButterKnife.bind(this, view);
        mList = new ArrayList<>();

        mList.add(new ZazhiModel(R.drawable.zazhi1, "第12期", "May.2017"));
        mList.add(new ZazhiModel(R.drawable.zazhi2, "第11期", "Apr.2017"));
        mList.add(new ZazhiModel(R.drawable.zazhi3, "第10期", "Mar.2017"));
        mList.add(new ZazhiModel(R.drawable.zazhi4, "第9期", "Feb.2017"));
        mList.add(new ZazhiModel(R.drawable.zazhi5, "第8期", "Jan.2017"));
        mList.add(new ZazhiModel(R.drawable.zazhi6, "第7期", "Dec.2016"));
        mList.add(new ZazhiModel(R.drawable.zazhi7, "第6期", "Nov.2016"));
        mList.add(new ZazhiModel(R.drawable.zazhi8, "第5期", "Oct.2016"));
        mList.add(new ZazhiModel(R.drawable.zazhi9, "第4期", "Sep.2016"));
        mList.add(new ZazhiModel(R.drawable.zazhi10, "第3期", "Aug.2016"));
        mList.add(new ZazhiModel(R.drawable.zazhi11, "第2期", "Jul.2016"));
        mList.add(new ZazhiModel(R.drawable.zazhi12, "第1期", "Jun.2016"));

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mZhaziRecycler.setNestedScrollingEnabled(false);
        mZhaziRecycler.setLayoutManager(manager);
        mZhaziRecycler.setAdapter(mAdapter = new ZazhiAdapter(mList, getActivity()));

    }


    @Override
    public void loadingDatas()
    {
        mViewList = new ArrayList<>();
        for (int i = 0; i < images.length; i++)
        {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.header_msg_zazhi, null);
            ImageView simple = (ImageView) view.findViewById(R.id.item_images);
            TextView title = (TextView) view.findViewById(R.id.item_titles);
            Picasso.with(getActivity()).load(images[i]).resize(414,233).centerCrop().into(simple);
            title.setText(titles[i]);
            mViewList.add(view);
        }

        mZazhiViewPager.setAdapter(new ZazhiBanner());
        mZazhiViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                resetIndic();
                switch (position)
                {
                    case 0:
                        mInidc1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 1:
                        mInidc2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 2:
                        mInidc3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 3:
                        mInidc4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 4:
                        mInidc5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
        isBanner = true;
        startBanner();
    }

    private void resetIndic()
    {
        mInidc1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mInidc5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
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
                while (isBanner)
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

    @Override
    public void onResume()
    {
        super.onResume();
        isBanner = true;
    }

    @Override
    public void onPause()
    {
        super.onPause();
        isBanner = false;
    }

    @Override
    public void startdestroy()
    {
        unbinder.unbind();
    }


    private class ZazhiBanner extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return images.length;
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
            container.addView(mViewList.get(position));

            return mViewList.get(position);
        }
    }*/


@BindView(R.id.guanfang_lists)
ListView mGuanList;
        private Unbinder mUnbinder;

        private ArticleResponseEvent all_daohang_bean;
        private List<ArticleResponseEvent.DataBean> dataBeanList;
        private List<MsgChildModel> mList;
        private MsgChildAdapter mAdapter;
        private Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        mList = new ArrayList<>();
                        mList.add(new MsgChildModel(dataBeanList.get(0).getDescription(),false,false,dataBeanList.get(1).getAuthor(),499,dataBeanList.get(0).getArticleImage()));
                        mList.add(new MsgChildModel(dataBeanList.get(1).getDescription(),false,false,dataBeanList.get(1).getAuthor(),15000,dataBeanList.get(1).getArticleImage()));
//                    mList.add(new MsgChildModel("这家最美宠物店，连鹿晗都要亲自做饭给店里员工吃！",false,false,"有宠小记者",49900,R.drawable.guanfang3));
//                    mList.add(new MsgChildModel("【有宠推新品】“有宠蛋蛋”便携铲屎神器！",false,false,"有宠小记者",18000,R.drawable.guanfang4));
//                    mList.add(new MsgChildModel("搞事情！有宠宠物生活会馆进驻广州禺万达~",true,false,"有宠小记者",17000,R.drawable.guanfang5));
//                    mList.add(new MsgChildModel("有宠生而不凡 缔造互联网+宠物新模式",false,false,"有宠小记者",6419,R.drawable.guanfang6));
//                    mList.add(new MsgChildModel("带上你的爱宠，来一场说走就走的免费泡泡浴吧！",false,false,"有宠小记者",46000,R.drawable.guanfang7));
//                    mList.add(new MsgChildModel("有宠代表中国赴德出席2017FMBB比利时牧羊犬世界锦...",true,false,"刀斥",21000,R.drawable.guanfang8));
//                    mList.add(new MsgChildModel("《有宠YOURPET》杂志封面背后的故事",false,false,"有宠小记者",7819,R.drawable.guanfang9));
//                    mList.add(new MsgChildModel("温暖母亲节，虫虫现身担任拥抱大使~",false,false,"有宠小记者",4259,R.drawable.guanfang10));
//                    mList.add(new MsgChildModel("高雄街头掀起虫虫旋风，大人小孩都疯狂！",true,false,"有宠小记者",5259,R.drawable.guanfang11));
//                    mList.add(new MsgChildModel("有宠福利，逃脱游戏登场",true,false,"有宠小记者",5800,R.drawable.guanfang12));

                        mGuanList.setAdapter(mAdapter = new MsgChildAdapter(mList, getActivity()));
                        break;
                }
                return false;
            }
        });

        @Override
        public int getResource()
        {
            return R.layout.fragment_guanfang;
        }

        @Override
        public void init(View view)
        {
            mUnbinder = ButterKnife.bind(this, view);
            getdata();

        }

        private void getdata() {
            String url = Constances.guanf;
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
            all_daohang_bean = JSONparse(response);
            dataBeanList = all_daohang_bean.getData();
            if (response!=null){
                handler.sendEmptyMessage(1);
            }
        }

        private ArticleResponseEvent JSONparse(String response) {
            return JSON.parseObject(response,ArticleResponseEvent.class);
        }

        @Override
        public void loadingDatas()
        {

        }

        @Override
        public void startdestroy()
        {
            mUnbinder.unbind();
        }
}
