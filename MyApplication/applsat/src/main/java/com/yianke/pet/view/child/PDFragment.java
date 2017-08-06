package com.yianke.pet.view.child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yianke.pet.R;
import com.yianke.pet.adapter.home.PDAdapter;
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

public class PDFragment extends BaseFragment
{
    @BindView(R.id.pd_main)
    ListView mPdMain;
    private Unbinder mUnbinder;

    private PDAdapter mAdapter;
    private int[] images =
            {
                    R.drawable.pd_1,
                    R.drawable.pd_2,
                    R.drawable.pd_3,
                    R.drawable.pd_4,
                    R.drawable.pd_5,
                    R.drawable.pd_6,
                    R.drawable.pd_7,
                    R.drawable.pd_8,
                    R.drawable.pd_9,
            };

    private String [] image =
            {
                    "http://f11.baidu.com/it/u=1171407455,2666980788&fm=72",
                    "http://f11.baidu.com/it/u=341827502,2860753376&fm=72",
                    "http://img3.imgtn.bdimg.com/it/u=1505113575,3428379400&fm=26&gp=0.jpg",
                    "http://img2.imgtn.bdimg.com/it/u=1469499598,3691287836&fm=26&gp=0.jpg",
                    "http://img2.imgtn.bdimg.com/it/u=3767223967,2402754401&fm=26&gp=0.jpg",
                    "http://img5.imgtn.bdimg.com/it/u=633745011,892773620&fm=26&gp=0.jpg",
                    "http://img0.imgtn.bdimg.com/it/u=3989998911,4234694023&fm=26&gp=0.jpg",
                    "http://img4.imgtn.bdimg.com/it/u=674153610,3427523686&fm=26&gp=0.jpg",
                    "http://img3.imgtn.bdimg.com/it/u=2218960746,3724830661&fm=26&gp=0.jpg",
            };
    private List<DTModel> mList;


    @Override
    public int getResource()
    {
        return R.layout.fragment_pd;
    }

    @Override
    public void init(View view)
    {
        ButterKnife.bind(this, view);
        mList = new ArrayList<>();
        mList.add(new DTModel(R.drawable.jx_header,"Summer麻麻","牛爆了!正宁路美食上央视了,这些兰州美食你吃过吗?",image));
        mList.add(new DTModel(R.drawable.jx_header,"Focus兰州街拍","兰州美食,你不知道的那些事!!",image));
        mList.add(new DTModel(R.drawable.jx_header,"中国兰州网","兰州人还是有才,竟然把兰州美食写成了诗!",image));
        mList.add(new DTModel(R.drawable.jx_header,"最爱大兰州","兰州正在消失的罕见美食,以后有钱都吃不到了!",image));
        mList.add(new DTModel(R.drawable.jx_header,"你好兰州","牛爆了!正宁路美食上央视了,这些兰州美食你吃过吗?",image));
        mList.add(new DTModel(R.drawable.jx_header,"甘肃圈子","兰州美食哪家强?新年狂high全攻略\n",image));
        mPdMain.setAdapter(mAdapter = new PDAdapter(getActivity(),mList));
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
