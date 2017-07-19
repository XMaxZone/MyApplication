package com.yianke.pet.Thread;

import android.nfc.Tag;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by huc on 2017/7/18.
 */

public class HttpThreadFactory implements Runnable {

    private String TAG = "HttpThreadFactory";

    private String url;

    private WebView webView;

    private Handler handler;

    public HttpThreadFactory(String url,WebView webView, Handler handler){
        this.url = url;
        this.webView = webView;
        this.handler = handler;
    }


    @Override
    public void run() {
        InputStream in = null;
        InputStreamReader is = null;
        BufferedReader bf = null;
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            final StringBuilder stringBuilder = new StringBuilder();
            in = httpURLConnection.getInputStream();
            is = new InputStreamReader(in);
            bf = new BufferedReader(is);
            String str;
            while ((str = bf.readLine()) != null){
                stringBuilder.append(str);
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadData(stringBuilder.toString(),"text/html;charset=utf-8",null);

                }
            });


        } catch (MalformedURLException e) {
            Log.e(TAG,"网络连接异常！");
        } catch (IOException e) {
            Log.e(TAG,"打开网络连接异常！");
        }finally {
            if (bf != null){
                try {
                    bf.close();
                } catch (IOException e) {
                    Log.e(TAG,"bf 关闭异常！");
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e(TAG ,"is 关闭异常");
                }
            }
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG , "in 关闭异常");
                }
            }
        }
    }
}
