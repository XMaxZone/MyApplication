package com.yianke.pet.model.shop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.yianke.pet.R;
import com.yianke.pet.bean.Add_cart_bean;
import com.yianke.pet.bean.Get_cart_bean;
import com.yianke.pet.bean.Pinpai_cahngping;
import com.yianke.pet.bean.Shop_cart_adapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

import static com.yianke.pet.Common.Constants.ADD_PRODUCT_SHOPPING_CAR_URL;

public class Shop_cart extends AppCompatActivity {

    private ListView mylistview_cart;
    private Shop_cart_adapter shop_cart_adapter;
    private ImageView ib_good_info_back;
    private Get_cart_bean get_cart_bean;
    private List<Get_cart_bean.DataBean> dataBeanList;
    private Button btn_good_info_addcart;
    private Add_cart_bean add_cart_bean;


    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what){
                case 1:
                    Intent intent = new Intent(Shop_cart.this,Pinpai_cahngping.class);
                    startActivity(intent);
                    finish();
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        initview();
        initdata();
    }

    private void initdata() {

        btn_good_info_addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //添加商品到购物车
                Intent intent = getIntent();
                String mydata = intent.getStringExtra("mydata");
                Log.e("TAG","我是商品的id"+mydata);
                String url = ADD_PRODUCT_SHOPPING_CAR_URL+"?data={\"productId\":\"2\",\"state\":\"Y\",\"number\":\"121\",\"userId\":\"1\",\"userName\":\"小苏苏\",\"productName\":\"衣服\",\"productDis\":\"1080\",\"geared\":\"21\",\"index\":\"1\",\"stock\":\"1\",\"navigation\":\"3\",\"label\":\"hello\",\"picture\":\"img\",\"price\":\"1000\"}";

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
        });
//
//        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
//        String userid = sharedPreferences.getString("userid","");
//        String url = Util_constance.get_cart+"data={\"userId\":\""+userid+"\"}";

        String url = "http://119.28.20.68:8080/GoodlifeApi/api/v1/product/index?data={%22navigation%22:%221%22,%22id%22:%22CE298886DCF44B81A9D9E94C44638417%22";


//        OkHttpUtils.post()
//                .url(url)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        processdata(response);
//                    }
//                });




    }

    private void processdata(String response) {
        add_cart_bean = JSonparse(response);
        if (response!=null){
                if ("请求成功".equals(add_cart_bean.getSuccess())){

                    handler.sendEmptyMessage(1);
                }
        }
    }

    private Add_cart_bean JSonparse(String response) {
        return JSON.parseObject(response,Add_cart_bean.class);
    }

//    private void processdata(String response) {
//        get_cart_bean = JSONparse(response);
//        dataBeanList = get_cart_bean.getData();
//        if(response!=null){
//
//            shop_cart_adapter = new Shop_cart_adapter(Shop_cart.this,dataBeanList);
//            mylistview_cart.setAdapter(shop_cart_adapter);
//        }
//    }
//
//    private Get_cart_bean JSONparse(String response) {
//        return JSON.parseObject(response,Get_cart_bean.class);
//    }

    private void initview() {
        btn_good_info_addcart = (Button)findViewById(R.id.btn_good_info_addcart);
//        mylistview_cart = (ListView)findViewById(R.id.mylistview_cart);
        ib_good_info_back = (ImageView)findViewById(R.id.ib_good_info_back);

        ib_good_info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
