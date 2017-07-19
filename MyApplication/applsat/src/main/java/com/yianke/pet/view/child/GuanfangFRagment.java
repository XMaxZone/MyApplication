package com.yianke.pet.view.child;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.yianke.pet.R;
import com.yianke.pet.adapter.msg.MsgChildAdapter;
import com.yianke.pet.bean.ArticleResponseEvent;
import com.yianke.pet.model.msg.MsgChildModel;
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
 * 功能：
 */

public class GuanfangFRagment extends BaseFragment
{
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
                    mList.add(new MsgChildModel(dataBeanList.get(0).getDescription(),false,false,dataBeanList.get(1).getAuthor(),499,R.drawable.guanfang1));
                    mList.add(new MsgChildModel(dataBeanList.get(1).getDescription(),false,false,dataBeanList.get(1).getAuthor(),15000,R.drawable.guanfang2));
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
