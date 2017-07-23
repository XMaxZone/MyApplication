package com.yianke.pet.bean;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yianke.pet.R;

import java.util.List;

/**
 * Created by Administrator on 2017/7/9.
 */

public class Shop_cart_adapter extends RecyclerView.Adapter<Shop_cart_adapter.ViewHolder> {

    private Context mcontent;
    private List<Get_cart_bean.DataBean> dataBeanList;
//    private List<GoodsBean> datas;

    //回调点击事件的监听
    private OnItemClickListener itemClickListener;

    public Shop_cart_adapter(Context mcontent, List<Get_cart_bean.DataBean> dataBeanList) {
        this.mcontent = mcontent;
        this.dataBeanList = dataBeanList;
    }

    //效验选中的状态
//    public void checkAll() {
//        if (datas != null && 5 > 0) {
//            int number = 0;
//            for (int i = 0; i <5; i++) {
//                GoodsBean goodsBean = datas.get(i);
//                if (!goodsBean.isChecked()) {
//                    checkBox.setChecked(false);
//                    checkboxDeleteAll.setChecked(false);
//                } else {
//                    number++;
//                }
//            }
//            if (5 == number) {
//                checkBox.setChecked(true);
//                checkboxDeleteAll.setChecked(true);
//            }
//        } else {
//            checkBox.setChecked(false);
//            checkboxDeleteAll.setChecked(false);
//        }
//    }

//    public void check_none(boolean checked) {
//        if (datas != null && 5 > 0) {
//            for (int i = 0; i < 5; i++) {
//                datas.get(i).setChecked(checked);
//                checkBox.setChecked(checked);
//                notifyItemChanged(i);
//            }
//        } else {
//            checkBox.setChecked(false);
//        }
//    }

    //删除数据
//    public void deleteData() {
//        if (datas != null && datas.size() > 0) {
//            for (int i = 0; i < datas.size(); i++) {
//                GoodsBean goodsBean = datas.get(i);
//                if (goodsBean.isChecked()) {
//                    //1.内存中删除
//                    datas.remove(goodsBean);
//                    //2.本地也保存
//                    CartStorage.getInstance(mcontent).deleteData(goodsBean);
//                    //刷新数据
//                    notifyItemRemoved(i);
//                    i--;
//                }
//            }
//        }
//    }

    /*
    * 点击item的监听
    * */
    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    //设置item监听
    public void setonItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }



    public void showTotalPrice() {
//        tvShopcartTotal.setText(getTotalPrice() + "");
    }

    //计算总价格
//    private double getTotalPrice() {
//        double total = 0;
//        if (datas != null && datas.size() > 0) {
//            for (int i = 0; i < datas.size(); i++) {
//                GoodsBean goodsBean = datas.get(i);
//                if (goodsBean.isChecked()) {
//                    total += Double.parseDouble(goodsBean.getCover_price()) * Double.parseDouble(goodsBean.getNumber() + "");
//                }
//            }
//        }
//        return total;
//    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = View.inflate(mcontent, R.layout.item_shop_cart,null);
        return new ViewHolder(itemview);
//        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(mcontent).load(dataBeanList.get(position).getPicture()).into(holder.iv_gov);
//        holder.tv_desc_gov.setText(dataBeanList.get(position).get);
        holder.tv_price_gov.setText(dataBeanList.get(position).getPrice());
        //1.更加位置得到的数据
//        final GoodsBean goodsBean = datas.get(position);
        //2.绑定数据
//        holder.cb_gov.setChecked(goodsBean.isChecked());
        //3.图片
//        Glide.with(mcontent).load(Constans.BASE_URL_IMAGE + goodsBean.getFigure()).into(holder.iv_gov);
//        holder.tv_desc_gov.setText(goodsBean.getName());
        //设置价格
//        holder.tv_price_gov.setText("￥" + goodsBean.getCover_price());
//        holder.AddSubViews.setValue(goodsBean.getNumber());
//         holder.AddSubViews.tv_value.setText(tv_value+"");
//        holder.AddSubViews.setOnNumberChangerListener(new AddSubView.OnNumberChangeListener() {
//
//            @Override
//            public void numberChanger(int value) {
//                //对象设置数据
//                goodsBean.setNumber(value);
//                //添加数据
//                CartStorage.getInstance(mcontent).addData(goodsBean);
//
//                //显示价格
//                showTotalPrice();
//            }
//        });
//        holder.AddSubViews.setMinValue(0);
//        holder.AddSubViews.setMaxValue(100);
    }

    @Override
    public int getItemCount() {
        return dataBeanList==null?0:dataBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox cb_gov;
        ImageView iv_gov;
        TextView tv_desc_gov;
        TextView tv_price_gov;
//        AddSubView AddSubViews;

        public ViewHolder(View itemView) {
            super(itemView);
            cb_gov = (CheckBox) itemView.findViewById(R.id.cb_gov);
            iv_gov = (ImageView) itemView.findViewById(R.id.iv_gov);
            tv_desc_gov = (TextView) itemView.findViewById(R.id.tv_desc_gov);
            tv_price_gov = (TextView) itemView.findViewById(R.id.tv_price_gov);
//            AddSubViews = (AddSubView) itemView.findViewById(R.id.AddSubView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (itemClickListener != null) {
//                        itemClickListener.onItemClickListener(view, getLayoutPosition());
//                    }
//                }
//            });
        }
    }

}
