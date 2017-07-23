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

public class XuetangFragment extends BaseFragment
{
    @BindView(R.id.xuetang_lists)
    ListView mXuetangLists;
    Unbinder unbinder;


    private MsgChildAdapter mAdapter;
    private List<MsgChildModel> mList;
    private ArticleResponseEvent all_daohang_bean;
    private List<ArticleResponseEvent.DataBean> dataBeanList;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mList = new ArrayList<>();
                    mList.add(new MsgChildModel(dataBeanList.get(0).getDescription(),false,false,dataBeanList.get(0).getAuthor(),52000,dataBeanList.get(0).getArticleImage()));
                    mList.add(new MsgChildModel(dataBeanList.get(1).getDescription(),false,false,dataBeanList.get(1).getAuthor(),1000,dataBeanList.get(1).getArticleImage()));
//                    mList.add(new MsgChildModel("子宫蓄脓+膀胱结石=小宝的痛苦",false,false,"派美特长青宠物医院",1000,R.drawable.xuetang3));
//                    mList.add(new MsgChildModel("炎炎夏日，狂洗澡&剃光狗狗的毛就对了？",false,false,"哦四姑",10000,R.drawable.xuetang4));
//                    mList.add(new MsgChildModel("市面疫苗种类那么多，我们该怎么选择？",false,false,"来份豆沙包",2658,R.drawable.xuetang5));
//                    mList.add(new MsgChildModel("喜欢偷吃的喵星人",false,false,"来份豆沙包",2019,R.drawable.xuetang6));
//                    mList.add(new MsgChildModel("与犬疫苗接种相关的常见问题",false,false,"娜酷子",2398,R.drawable.xuetang7));
//                    mList.add(new MsgChildModel("母犬的假孕",false,false,"来份豆沙包",2419,R.drawable.xuetang8));
//                    mList.add(new MsgChildModel("你的兔子有脚炎吗？",false,false,"刀斥",1339,R.drawable.xuetang9));
//                    mList.add(new MsgChildModel("因肾衰竭而呕吐，抽搐的TA，在这里恢复了健康",false,false,"芭比唐堂",2179,R.drawable.xuetang10));
//                    mList.add(new MsgChildModel("犬猫胰腺炎",false,false,"来份豆沙包",959,R.drawable.xuetang11));
//                    mList.add(new MsgChildModel("夏天要格外小心体表寄生虫病！",false,false,"来份豆沙包",1719,R.drawable.xuetang12));

                    mXuetangLists.setAdapter(mAdapter = new MsgChildAdapter(mList,getActivity()));
                    break;
            }
            return false;
        }
    });

    @Override
    public int getResource()
    {
        return R.layout.fragment_xuetang;
    }

    @Override
    public void init(View view)
    {
        unbinder = ButterKnife.bind(this, view);
        getData();

    }

    private void getData() {
            String url = Constances.xuet;
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
        all_daohang_bean = JSONpaorse(response);
        dataBeanList = all_daohang_bean.getData();
        if (response!=null){
            handler.sendEmptyMessage(1);
        }

    }

    private ArticleResponseEvent JSONpaorse(String response) {
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
