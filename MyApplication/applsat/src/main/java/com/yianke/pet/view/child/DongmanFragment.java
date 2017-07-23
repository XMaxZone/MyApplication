package com.yianke.pet.view.child;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import okhttp3.Call;

/**
 * 作者：赵若位
 * 时间：2017/6/19 19:33
 * 功能：资讯页面-动漫
 */

public class DongmanFragment extends BaseFragment
{
    @BindView(R.id.dongman_lists)
    ListView mDongmanLists;

    private List<MsgChildModel> mList;
    private MsgChildAdapter mAdapter;
    private ArticleResponseEvent all_daohang_bean;
    private List<ArticleResponseEvent.DataBean> dataBeanList;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mList = new ArrayList<>();
                    mList.add(new MsgChildModel(dataBeanList.get(0).getDescription(),dataBeanList.get(0).getAuthor(),4256,dataBeanList.get(0).getArticleImage()));
                    mList.add(new MsgChildModel(dataBeanList.get(1).getDescription(),dataBeanList.get(1).getAuthor(),9999,dataBeanList.get(1).getArticleImage()));
//                    mList.add(new MsgChildModel(dataBeanList.get(2).getDescription(),dataBeanList.get(2).getAuthor(),13000,R.drawable.dongman3));
//                    mList.add(new MsgChildModel("瑞兽--猫落平阳被犬欺（下）",true,false,"宋霸霸 小铁&果脯儿 军统小队长",17000,R.drawable.dongman4));
//                    mList.add(new MsgChildModel("瑞兽--高清福利图",true,false,"果脯儿&军统小队长",29000,R.drawable.dongman5));
//                    mList.add(new MsgChildModel("樱花苹果派","大贝贝",619,R.drawable.dongman6));
//                    mList.add(new MsgChildModel("家有萌喵--奥利奥的故事（一）","兔子猫",1657,R.drawable.dongman7));
//                    mList.add(new MsgChildModel("徐芝麻--番外2","原作冬瓜茶仙人&画手嘤嘤嘤因",1518,R.drawable.dongman8));
//                    mList.add(new MsgChildModel("影子猫--技巧，规则与天赋","牧羊阿卡",1679,R.drawable.dongman9));
//                    mList.add(new MsgChildModel("抖抖村--另一个世界","DDM大王",2103,R.drawable.dongman10));

                    mDongmanLists.setAdapter(mAdapter = new MsgChildAdapter(mList, getActivity()));
                    break;
            }
            return false;
        }
    });

    @Override
    public int getResource()
    {
        return R.layout.fragment_dongman;
    }

    @Override
    public void init(View view)
    {
        ButterKnife.bind(this, view);
        getdata();

    }

    private void getdata() {
        String url = Constances.dongman;
        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG","数据错误"+e);
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

    }

}
