package com.yianke.pet.view.child;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yianke.pet.R;
import com.yianke.pet.adapter.home.DTAdapter;
import com.yianke.pet.model.home.DTModel;
import com.yianke.pet.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：${赵若位} on 2017/6/6 10:20
 * 邮箱：1070138445@qq.com
 * 功能：
 */

public class DTFragment extends BaseFragment
{
    @BindView(R.id.dt_main)
    ListView mDtMain;
    private Unbinder mUnbinder;

    private DTAdapter mAdapter;


    private List<DTModel> mList;
   /* private int[] images =
            {
                    R.drawable.dt_1,
                    R.drawable.dt_2,
                    R.drawable.dt_3,
                    R.drawable.dt_4,
                    R.drawable.dt_5,
                    R.drawable.dt_6,
                    R.drawable.dt_7,
                    R.drawable.dt_8,
                    R.drawable.dt_9,
            };*/

    private String [] image = {
            "http://f12.baidu.com/it/u=3214361989,951380039&fm=72",
            "http://img0.imgtn.bdimg.com/it/u=2937302468,1946011406&fm=26&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3071355984,2082308849&fm=26&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=1861676655,272061429&fm=26&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=3983108724,547207744&fm=26&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=3183482346,3416498291&fm=26&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3481175569,2553102834&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=1393543062,1951875490&fm=26&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=360056944,1446441526&fm=26&gp=0.jpg"
    };

    @Override
    public int getResource()
    {
        return R.layout.fragment_dt;
    }

    @Override
    public void init(View view)
    {
        Log.e("TAG",image.length+"--------");
        ButterKnife.bind(this, view);
        mList = new ArrayList<>();
        mList.add(new DTModel(R.drawable.jx_header,"王豆豆","兰州要大变了!明天起,兰州将富得流油.....",image));
        mList.add(new DTModel(R.drawable.jx_header,"人民网","2天后,兰州要大变了!兰州人将要身价暴涨!!!",image));
        mList.add(new DTModel(R.drawable.jx_header,"兰州小圈子","兰州2天连发3起溺水事件,兰州公安紧急提醒!",image));
        mList.add(new DTModel(R.drawable.jx_header,"你好兰州","很遗憾,兰州并没有兰州拉面!",image));
        mList.add(new DTModel(R.drawable.jx_header,"广州印象","兰州城中竟然“藏”了一个三百多年历史的名小吃.",image));
        mList.add(new DTModel(R.drawable.jx_header,"兰州内参","兰州火车站坐车的注意,千万别.做这件事,快告诉家人!",image));
        mDtMain.setAdapter(mAdapter = new DTAdapter(getActivity(), mList));
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
    }


}
