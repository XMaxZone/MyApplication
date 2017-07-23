package com.yianke.pet.bean;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.yianke.pet.R;

import java.util.List;

public class Pinpai_cahngping extends AppCompatActivity {

    private View fenhui_ningpai;
    private TextView texts;
    private RadioGroup bingpai_rg;
    private RadioButton rb_gushi;
    private TextView myshop_cart;
    private Add_cart_ok_bean add_cart_ok_bean;
    private LinearLayout fanghui;

    private RadioButton rg_changpin;
    private Shop_xaingxi_bingpai shop_xaingxi_bingpai;


    private ImageView mycart_image;

    private TextView xiang_yuanjia;

    private RecyclerView recyclerview;
    private Shop_cart_adapter shop_cart_adapter;
    private CheckBox checkbox_all;
    private TextView tv_shopcart_total;
    private CheckBox cb_all;
    private Button btn_check_out;

    private Get_cart_bean get_cart_bean;
    private List<Get_cart_bean.DataBean> dataBeanList;


//    private Handler handler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message message) {
//            switch (message.what){
//                case 1:
//                    Intent intent = new Intent(Pinpai_cahngping.this, Shop_cart.class);
//                    startActivity(intent);
//                    break;
//            }
//            return false;
//        }
//    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        fragment_shopping_cart
        setContentView(R.layout.fragment_shopping_cart);
//        setContentView(R.layout.activity_pinpai_cahngping);
//        fenhui_ningpai = findViewById(R.id.fenhui_ningpai);
//        myshop_cart = (TextView)findViewById(R.id.myshop_cart);
//        xiang_yuanjia = (TextView)findViewById(R.id.xiang_yuanjia);
//        fanghui = (LinearLayout)findViewById(R.id.fanghui);
//        mycart_image = (ImageView)findViewById(R.id.mycart_image);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        checkbox_all = (CheckBox) findViewById(R.id.checkbox_all);
        tv_shopcart_total = (TextView)findViewById(R.id.tv_shopcart_total);
//        cb_all = (CheckBox)findViewById(R.id.cb_all);
        btn_check_out = (Button)findViewById(R.id.btn_check_out);
        onclickall();
//        getdata();
    }

    private void processdata(String response) {
        get_cart_bean = JSONparse(response);
        dataBeanList = get_cart_bean.getData();
        if(response!=null){
            shop_cart_adapter = new Shop_cart_adapter(Pinpai_cahngping.this,dataBeanList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Pinpai_cahngping.this);
            recyclerview.setLayoutManager(linearLayoutManager);
            recyclerview.setAdapter(shop_cart_adapter);
        }
    }

    private Get_cart_bean JSONparse(String response) {
        return JSON.parseObject(response,Get_cart_bean.class);
    }

    private void onclickall() {

//        xiang_yuanjia.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

//        fenhui_ningpai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
        btn_check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Utils.showToast(Pinpai_cahngping.this,"调用微信");
            }
        });


        /************************************************************************************************/

//        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
//        String userid = sharedPreferences.getString("userid","");
//        String url = Util_constance.get_cart+"data={\"userId\":\""+userid+"\"}";

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



        /*************************************************************************************************/

//
//                String url = Util_constance.add_info + "data={\"productId\":\"1\",\"state\":\"Y\",\"number\":\"121\",\"userId\":\"1\",\"userName\":\"小苏苏\",\"productName\":\"衣服\",\"productDis\":\"1080\",\"geared\":\"21\",\"index\":\"1\",\"stock\":\"1\",\"navigation\":\"3\",\"label\":\"hello\",\"picture\":\"img\",\"price\":\"1000\"}";
//                OkHttpUtils
//                        .post()
//                        .url(url)
//                        .build()
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onError(Call call, Exception e, int id) {
//                                Log.e("TAG","错误"+e);
//                            }
//
//                            @Override
//                            public void onResponse(String response, int id) {
//
//                                add_cart_ok_bean = JSONparsse(response);
//
//                                if("请求成功".equals(add_cart_ok_bean.getSuccess())){
////                                    recyclerview
//                                    shop_cart_adapter = new Shop_cart_adapter(Pinpai_cahngping.this,add_cart_ok_bean,checkbox_all,tv_shopcart_total);
//                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Pinpai_cahngping.this);
//                                    recyclerview.setLayoutManager(linearLayoutManager);
//                                    recyclerview.setAdapter(shop_cart_adapter);
//                                }
//                            }
//                        });
    }

    private Add_cart_ok_bean JSONparsse(String response) {
        return JSON.parseObject(response,Add_cart_ok_bean.class);
    }

    private void getdata() {

        fanghui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        checkbox_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = checkbox_all.isChecked();
//                shop_cart_adapter.check_none(checked);
//                shop_cart_adapter.showTotalPrice();
            }
        });
//        Intent intent = getIntent();
//        String datas = intent.getStringExtra("my_id");
//        String url = Contance.PINPAIONE + datas + Contance.PINPAITWO;
//
    }


}
