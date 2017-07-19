package com.yianke.pet.view.child;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.picasso.Picasso;
import com.yianke.pet.R;
import com.yianke.pet.adapter.msg.MsgChildAdapter;
import com.yianke.pet.bean.All_daohang_bean;
import com.yianke.pet.model.msg.MsgChildModel;
import com.yianke.pet.utils.BaseHandler;
import com.yianke.pet.utils.Constances;
import com.yianke.pet.view.activity.AgreeDetialActivity;
import com.yianke.pet.view.activity.Zinxun_web;
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
 * 时间：2017-6-19 14：03
 * 功能：资讯页面-推荐
 */

public class TuiJianFragment extends BaseFragment
{



    @BindView(R.id.tuijian_lists)
    ListView mTuijianLists;
    Unbinder unbinder;


    private MsgChildAdapter mAdapter;
    private List<MsgChildModel> mList;
    private All_daohang_bean all_daohang_bean;
    private List<All_daohang_bean.DataBean> dataBeanList;

    //****************************Banner***************************//
    private List<View> mViewList;
    private View mView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case 1:
                    mList = new ArrayList<>();
                    mList.add(new MsgChildModel(dataBeanList.get(0).getDescription(), true, true, dataBeanList.get(0).getAuthor(), 22000, R.drawable.tuijian1));
                    mList.add(new MsgChildModel(dataBeanList.get(1).getDescription(), false, false, dataBeanList.get(1).getAuthor(), 1199, R.drawable.tuijian2));
                    mList.add(new MsgChildModel(dataBeanList.get(2).getDescription(), false, false, dataBeanList.get(2).getAuthor(), 2298, R.drawable.tuijian3));
                    mList.add(new MsgChildModel(dataBeanList.get(3).getDescription(), false, false, dataBeanList.get(3).getAuthor(), 1839, R.drawable.tuijian4));
                    mList.add(new MsgChildModel(dataBeanList.get(4).getDescription(), true, false, dataBeanList.get(4).getAuthor(), 7599, R.drawable.tuijian5));
                    mList.add(new MsgChildModel(dataBeanList.get(5).getDescription(), false, false, dataBeanList.get(5).getAuthor(), 32000, R.drawable.tuijian6));
                    mList.add(new MsgChildModel(dataBeanList.get(6).getDescription(), false, false, dataBeanList.get(6).getAuthor(), 9678, R.drawable.tuijian7));
                    mList.add(new MsgChildModel(dataBeanList.get(7).getDescription(), false, false, dataBeanList.get(7).getAuthor(), 11000, R.drawable.tuijian8));
                    mList.add(new MsgChildModel(dataBeanList.get(8).getDescription(), false, false, dataBeanList.get(8).getAuthor(), 9119, R.drawable.tuijian9));
                    mList.add(new MsgChildModel(dataBeanList.get(9).getDescription(), false, false, dataBeanList.get(9).getAuthor(), 3259, R.drawable.tuijian10));
                    mList.add(new MsgChildModel(dataBeanList.get(10).getDescription(), false, false, dataBeanList.get(10).getAuthor(), 13000, R.drawable.tuijian11));
                    mList.add(new MsgChildModel(dataBeanList.get(11).getDescription(), false, false, dataBeanList.get(11).getAuthor(), 5959, R.drawable.tuijian12));
//                    mList.add(new MsgChildModel(dataBeanList.get(11).getDescription(), false, false, "云宁", 7879, R.drawable.tuijian13));
//                    mList.add(new MsgChildModel(dataBeanList.get(13).getDescription(), false, false, "苗仔", 16000, R.drawable.tuijian14));
//                    mList.add(new MsgChildModel(dataBeanList.get(14).getDescription(), false, false, "苗仔", 18000, R.drawable.tuijian15));
//                    mList.add(new MsgChildModel(dataBeanList.get(15).getDescription(), false, false, "蒂娜", 12000, R.drawable.tuijian16));
//                    mList.add(new MsgChildModel(dataBeanList.get(16).getDescription(), false, false, "云宁", 12000, R.drawable.tuijian17));
//                    mList.add(new MsgChildModel(dataBeanList.get(17).getDescription(), true, true, "欢喜", 87000, R.drawable.tuijian18));
                    mTuijianLists.setAdapter(mAdapter = new MsgChildAdapter(mList, getActivity()));
                    mTuijianLists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            Intent intent = new Intent(getContext(), Zinxun_web.class);
                            Intent intent = new Intent(getContext(), AgreeDetialActivity.class);
                            intent.putExtra("id",dataBeanList.get(position).getId());
                            intent.putExtra("navigation",dataBeanList.get(position).getNavigation());
                            startActivity(intent);
                        }
                    });
                    break;
            }
            return false;
        }
    });


    private int[] images =//banner图片
            {
                    R.drawable.banner_tuijian1,
                    R.drawable.banner_tuijian2,
                    R.drawable.banner_tuijian3,
                    R.drawable.banner_tuijian4,
                    R.drawable.banner_tuijian5
            };
    private String[] titles =
            {
                    "有宠福利购第八期来了，这次是个大手笔",
                    "世界献血日，宠物用血为何这么难",
                    "有宠福布斯：探秘名画中的狗，哪些狗是画家...",
                    "宠事儿：宅男网红养成记",
                    "名撕其实：你走过狗屎运吗？"
            };

    //指示器
    private ImageView mIndic1;
    private ImageView mIndic2;
    private ImageView mIndic3;
    private ImageView mIndic4;
    private ImageView mIndic5;
    private ViewPager mBanner;

    private BaseHandler<TuiJianFragment> mHandler = new BaseHandler<TuiJianFragment>(this)
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            mBanner.setCurrentItem(msg.what % images.length);
            Log.e("info", "+++++++++++++轮播开启！！！！++++++++++++++++>");
        }
    };
    private boolean isBanner = false;//是否开启轮播图片
    //*******************************************************//


    @Override
    public int getResource()
    {
        return R.layout.fragment_tuijian;
    }

    @Override
    public void init(View view)
    {
        ButterKnife.bind(this, view);
        getdata();
    }

    private void getdata() {
        String url = Constances.zhixun_main;
        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG","错误"+e);
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

    private All_daohang_bean JSONparse(String response) {
        return JSON.parseObject(response,All_daohang_bean.class);
    }

    @Override
    public void loadingDatas()
    {
        //加载ListView顶部banner以及搜索框
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.header_msg_tuijian, null);
        mTuijianLists.addHeaderView(header);
        mViewList = new ArrayList<>();

        mIndic1 = (ImageView) header.findViewById(R.id.indic1);
        mIndic2 = (ImageView) header.findViewById(R.id.indic2);
        mIndic3 = (ImageView) header.findViewById(R.id.indic3);
        mIndic4 = (ImageView) header.findViewById(R.id.indic4);
        mIndic5 = (ImageView) header.findViewById(R.id.indic5);


        //banner装配数据
        for (int i = 0; i < 5; i++)
        {
            mView = LayoutInflater.from(getActivity()).inflate(R.layout.item_msg_tuijian_banner, null);
            ImageView mBannerImage = (ImageView) mView.findViewById(R.id.banner_image);
            TextView mBannerTitle = (TextView) mView.findViewById(R.id.banner_titles);

            Picasso.with(getActivity()).load(images[i]).resize(400,205).into(mBannerImage);
            mBannerTitle.setText(titles[i]);
            mViewList.add(mView);
        }

        mBanner = (ViewPager) header.findViewById(R.id.banner_ViewPager);
        mBanner.setAdapter(new HeaderViewPager());

        mBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
                        mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 1:
                        mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 2:
                        mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 3:
                        mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                        break;
                    case 4:
                        mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
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

    //开启图片轮播
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
                        Thread.sleep(3000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    //banner适配器
    private class HeaderViewPager extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return 5;
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
    }


    @Override
    public void startdestroy()
    {
        unbinder.unbind();
    }


    private void resetIndic()
    {
        mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
    }


}
