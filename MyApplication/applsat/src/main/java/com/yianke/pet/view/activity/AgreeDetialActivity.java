package com.yianke.pet.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.yianke.pet.Common.Constants;
import com.yianke.pet.R;
import com.yianke.pet.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgreeDetialActivity extends AppCompatActivity
{

    @BindView(R.id.top_text)
    TextView mTopText;
    @BindView(R.id.agree_web)
    WebView mAgreeWeb;

    private String TAG = "AgreeDetialActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_agree_detial);
        ButterKnife.bind(this);
        init();
    }

    private void init()
    {
        mTopText.setText("智慧永登");
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int id = extras.getInt("id");
        int navigation = extras.getInt("navigation");
        String url = Constants.ARTICLE_DETAIL_WEBVIEW_URL + id;
        Log.e(TAG ,url);
        mAgreeWeb.getSettings().setJavaScriptEnabled(true);
        mAgreeWeb.loadUrl(url);
    }

    @OnClick(R.id.top_back)
    public void onViewClicked()
    {
        finish();
    }
}
