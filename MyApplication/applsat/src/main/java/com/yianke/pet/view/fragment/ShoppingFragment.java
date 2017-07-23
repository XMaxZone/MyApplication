package com.yianke.pet.view.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.squareup.picasso.Picasso;
import com.yianke.pet.Common.Listview;
import com.yianke.pet.Common.MyGridview;
import com.yianke.pet.R;
import com.yianke.pet.adapter.PintuanAdapter;
import com.yianke.pet.adapter.shop.Myshop_adapter;
import com.yianke.pet.adapter.shop.ShopAdapter;
import com.yianke.pet.bean.Shop_bean;
import com.yianke.pet.model.shop.Pintuan;
import com.yianke.pet.model.shop.ShopModel;
import com.yianke.pet.model.shop.Shop_cart;
import com.yianke.pet.utils.BaseHandler;
import com.zhy.autolayout.utils.AutoUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

import static com.yianke.pet.Common.Constants.FIND_SHOP_INDEX_URL;

/**
 * 作者：${赵若位} on 2017/6/3 23:06
 * 邮箱：1070138445@qq.com
 * 功能：
 */

public class ShoppingFragment extends BaseFragment
{

    @BindView(R.id.shop_main)
    Listview mShopMain;
    //轮播指示器
    ImageView mIndic1;
    ImageView mIndic2;
    ImageView mIndic3;
    ImageView mIndic4;
    ImageView mIndic5;


    private Unbinder mUnbinder;
    private MyGridview mygridview;
    private Myshop_adapter myshop_adapter;

    private View header;

    private ShopAdapter mAdapter;
    private List<ShopModel> mList;
    private Shop_bean shop_bean;
    private List<Shop_bean.DataBean> dataBeanList;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case 1:
                    initHeader();
                    mShopMain.addHeaderView(header);
                    mAdapter = new ShopAdapter(getActivity(), mList);
                    myshop_adapter = new Myshop_adapter(getActivity(),dataBeanList);
                    mygridview.setAdapter(myshop_adapter);
                    mShopMain.setAdapter(mAdapter);
                    mygridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String mydata = dataBeanList.get(position).getId();
                            Log.e("TAG","我是准备传递的数据"+mydata);
                            Intent intent = new Intent(getContext(),Shop_cart.class);
                            intent.putExtra("mydata",mydata);
                            startActivity(intent);
                        }
                    });
//                    initFooter();
                    break;
            }
            return false;
        }
    });

    private int[] images =
            {
                    R.drawable.banner_shop1,
                    R.drawable.banner_shop2,
                    R.drawable.banner_shop3,
                    R.drawable.banner_shop4,
                    R.drawable.banner_shop5
            };
    private List<ImageView> mViewList;
    private boolean isStart = false;
    private ViewPager mHeaderBanner;
    private BaseHandler<ShoppingFragment> mHandler = new BaseHandler<ShoppingFragment>(this)
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            resetIndic();
            switch (msg.what)
            {
                case 0:
                    mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    mHeaderBanner.setCurrentItem(0);
                    break;
                case 1:
                    mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    mHeaderBanner.setCurrentItem(1);
                    break;
                case 2:
                    mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    mHeaderBanner.setCurrentItem(2);
                    break;
                case 3:
                    mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    mHeaderBanner.setCurrentItem(3);
                    break;
                case 4:
                    mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_ff);
                    mHeaderBanner.setCurrentItem(4);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public int getResource()
    {
        return R.layout.fragment_shopping;
    }

    @Override
    public void init(View view)
    {
        mUnbinder = ButterKnife.bind(this, view);
        mygridview = (MyGridview)view.findViewById(R.id.mygridview);
        getdata();


    }

    private void getdata() {
        String url = FIND_SHOP_INDEX_URL+"?"+"data={}";
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
                        processdata(response);
                    }
                });
    }

    private void processdata(String response) {
        shop_bean = JSONparse(response);
        dataBeanList = shop_bean.getData();
        if (response!=null){
            handler.sendEmptyMessage(1);
        }
    }

    private Shop_bean JSONparse(String response) {
        return JSON.parseObject(response,Shop_bean.class);
    }

    private void initFooter()
    {
        View footer = LayoutInflater.from(getActivity()).inflate(R.layout.item_shopping_footer, null);
        AutoUtils.autoSize(footer);
        mShopMain.addFooterView(footer);
    }

    /**
     * 初始化顶部
     */
    private void initHeader()
    {
        List<Pintuan> mList = new ArrayList<>();
        mList.add(new Pintuan(R.drawable.pintuan_one, dataBeanList.get(0).getProductName(), 39.9, 99));
        mList.add(new Pintuan(R.drawable.pintuan_two, dataBeanList.get(1).getProductName(), 29, 62));
        mList.add(new Pintuan(R.drawable.pintuan_three,dataBeanList.get(2).getProductName(), 25, 40));
        mList.add(new Pintuan(R.drawable.pintuan_four,dataBeanList.get(3).getProductName(), 9.9, 35));
        mList.add(new Pintuan(R.drawable.pintuan_five, dataBeanList.get(4).getProductName(), 19.9, 39));
//        mList.add(new Pintuan(R.drawable.pintuan_six, dataBeanList.get(5).getProductName(), 59, 125));
//        mList.add(new Pintuan(R.drawable.pintuan_seven, dataBeanList.get(6).getProductName(), 15.9, 35));
//        mList.add(new Pintuan(R.drawable.pintuan_eight, dataBeanList.get(7).getProductName(), 219, 438));
//        mList.add(new Pintuan(R.drawable.pintuan_nine, dataBeanList.get(8).getProductName(), 6.9, 19));

        header = LayoutInflater.from(getActivity()).inflate(R.layout.header_shopping, null);
        RecyclerView mHeaderMain = (RecyclerView) header.findViewById(R.id.header_recycler);
        mHeaderBanner = (ViewPager) header.findViewById(R.id.header_banner);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mHeaderMain.setLayoutManager(manager);
        PintuanAdapter pintuanAdapter = new PintuanAdapter(mList, getActivity());
        mHeaderMain.setAdapter(pintuanAdapter);
        pintuanAdapter.setOnItemclickListener(new PintuanAdapter.OnItemclickListener() {
            @Override
            public void onItemClick(int position) {
                String mydata = dataBeanList.get(position).getId();
                Log.e("TAG","我是准备传递的数据"+mydata);
                Intent intent = new Intent(getContext(),Shop_cart.class);
                intent.putExtra("mydata",mydata);
                startActivity(intent);
            }
        });

//        mHeaderMain.setNestedScrollingEnabled(false);

        mIndic1 = (ImageView) header.findViewById(R.id.indic1);
        mIndic2 = (ImageView) header.findViewById(R.id.indic2);
        mIndic3 = (ImageView) header.findViewById(R.id.indic3);
        mIndic4 = (ImageView) header.findViewById(R.id.indic4);
        mIndic5 = (ImageView) header.findViewById(R.id.indic5);

        mViewList = new ArrayList<>();
        for (int i = 0; i < images.length; i++)
        {

            ImageView mView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(images[i]).resize(621, 237).centerCrop().into(mView);
            mViewList.add(mView);
        }
        mHeaderBanner.setAdapter(new BannerAdapter());

        mHeaderBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
        isStart = true;
        startBanner();
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

    //重置指示器背景
    private void resetIndic()
    {
        mIndic1.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic2.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic3.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic4.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
        mIndic5.setBackgroundResource(R.drawable.shape_msg_tuijian_circle_f4);
    }

    @Override
    public void loadingDatas()
    {

    }

    @Override
    public void startdestroy()
    {
        mUnbinder.unbind();
        mAdapter = null;
        mList = null;
    }


    //顶部轮播适配器
    private class BannerAdapter extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return mViewList == null ? 0 : mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            container.removeView((View) object);
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
