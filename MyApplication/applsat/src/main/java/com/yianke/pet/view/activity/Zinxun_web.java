package com.yianke.pet.view.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.yianke.pet.Common.Constants;
import com.yianke.pet.R;
import com.yianke.pet.Thread.HttpThreadFactory;

public class Zinxun_web extends AppCompatActivity {

    private WebView agree_web;

    private String Tag = "Zinxun_web";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree_detial);
        initview();
        initdata();
    }

    private void initdata() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int id = extras.getInt("id");
        String url = Constants.ARTICLE_DETAIL_WEBVIEW_URL + id;
        agree_web = new WebView(this);
        agree_web.getSettings().setJavaScriptEnabled(true);
        agree_web.loadUrl("http://baidu.com");
        //Log.i(Tag,""+url);
        setContentView(agree_web);

    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && agree_web.canGoBack()) {
            agree_web.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        return false;
    }


    private void initview() {
        agree_web = (WebView)findViewById(R.id.agree_web);
    }
}
