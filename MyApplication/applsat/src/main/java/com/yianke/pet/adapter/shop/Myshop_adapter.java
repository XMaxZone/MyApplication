package com.yianke.pet.adapter.shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yianke.pet.R;
import com.yianke.pet.bean.Shop_bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22 0022.
 */

public class Myshop_adapter extends BaseAdapter {

    private Context mcontent;
    private List<Shop_bean.DataBean> dataBeanList;

    public Myshop_adapter(Context mcontent, List<Shop_bean.DataBean> dataBeanList) {
        this.mcontent = mcontent;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public int getCount() {
        return dataBeanList==null?0:dataBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view ==null){
            viewHolder = new ViewHolder();
            view = View.inflate(mcontent, R.layout.item_goods_list, null);
            viewHolder.iv_hot = (ImageView)view.findViewById(R.id.iv_hot);
            viewHolder.tv_name = (TextView)view.findViewById(R.id.tv_name);
            viewHolder.tv_price = (TextView)view.findViewById(R.id.tv_price);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(mcontent).load(dataBeanList.get(i).getPicture()).into(viewHolder.iv_hot);
        viewHolder.tv_name.setText(dataBeanList.get(i).getProductName());
        viewHolder.tv_price.setText(dataBeanList.get(i).getPrice());
        return view;
    }

    class ViewHolder{
        ImageView iv_hot;
        TextView tv_name;
        TextView tv_price;

    }
}
