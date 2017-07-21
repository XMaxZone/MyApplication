package com.yianke.pet.utils;

import android.util.Log;

import com.yianke.pet.Common.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Title:网络请求 工具类
 * Created by huc on 2017/7/21.
 */

public class HttpClient {


    private OkHttpClient okHttpClient;

    private Request.Builder builder;

    private static final String TAG = "OkHttpRequest";

    public HttpClient(){
        okHttpClient = new OkHttpClient();
        builder = new Request.Builder();
    }

    /**
     * 执行Get网络请求
     * @param url 资源定位地址
     * @param parame 请求参数
     * @return
     */
    public String HttpGetRequest(String url ,String parame){
        String result = "";
        Request request = builder.get().url(url).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            result = execute.body().string();
        } catch (IOException e) {
            Log.e(TAG ,e.getMessage());
        }
        return result;
    }


    /**
     * 执行Post 网络请求
     * @param url 资源定位地址
     * @param parame 请求参数
     * @return
     */
    public String HttpPostRequest(String url ,String parame){
        String result = "";
        RequestBody body = RequestBody.create(Constants.REQUEST_PARAMERS_TYPE_JSON, parame);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()){
                result = response.body().string();
            }else {
                new RuntimeException("HttpPostRequest request Exception!");
            }
        } catch (IOException e) {
            Log.e(TAG , e.getMessage());
        }
        return result;
    }


}
