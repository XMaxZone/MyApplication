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
 * 时间：2017/6/19 14:07
 * 功能：资讯页面-要闻
 */
public class YaowenFragment extends BaseFragment
{
    @BindView(R.id.yaowen_list)
    ListView mYaowenList;
    private MsgChildAdapter mAdapter;


    private List<MsgChildModel> mList;
    private ArticleResponseEvent all_daohang_bean;
    private List<ArticleResponseEvent.DataBean> dataBeanList;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case 1:
                    mList = new ArrayList<>();
                    mList.add(new MsgChildModel(dataBeanList.get(0).getArticleName(),false,false,dataBeanList.get(0).getAuthor(),4191,R.drawable.yaowen1));
                    mList.add(new MsgChildModel(dataBeanList.get(1).getArticleName(),false,false,dataBeanList.get(1).getAuthor(),5178,R.drawable.yaowen2));
//                    mList.add(new MsgChildModel(dataBeanList.get(2).getArticleName(),false,false,"",4679,R.drawable.yaowen3));
//                    mList.add(new MsgChildModel(dataBeanList.get(3).getArticleName(),false,false,"",8209,R.drawable.yaowen4));
//                    mList.add(new MsgChildModel(dataBeanList.get(4).getArticleName(),false,false,"",5038,R.drawable.yaowen5));
//                    mList.add(new MsgChildModel(dataBeanList.get(5).getArticleName(),false,false,"",4238,R.drawable.yaowen6));
//                    mList.add(new MsgChildModel(dataBeanList.get(6).getArticleName(),false,false,"",14000,R.drawable.yaowen7));
//                    mList.add(new MsgChildModel(dataBeanList.get(7).getArticleName(),false,false,"",6939,R.drawable.yaowen8));
//                    mList.add(new MsgChildModel(dataBeanList.get(8).getArticleName(),false,false,"",8579,R.drawable.yaowen9));
//                    mList.add(new MsgChildModel(dataBeanList.get(9).getArticleName(),false,false,"",5039,R.drawable.yaowen10));

                    mYaowenList.setAdapter(mAdapter = new MsgChildAdapter(mList, getActivity()));
                    break;
            }
            return false;
        }
    });


    @Override
    public int getResource()
    {
        return R.layout.fragment_yaowen;
    }

    @Override
    public void init(View view)
    {
        ButterKnife.bind(this, view);
        getdata();

    }

    private void getdata() {
        String url = Constances.yaowen;
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
