package com.xjx.helper.http;

import com.google.gson.Gson;
import com.xjx.helper.BuildConfig;
import com.xjx.helper.http.convert.GsonConvert;
import com.xjx.helper.http.retrofit.AutoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * 网络管理工具
 */

public class HttpClient {

    private final static int CONNECT_TIMEOUT = 30;
    private final static int READ_TIMEOUT = 30;
    private final static int WRITE_TIMEOUT = 30;

    public static RefreshControllerInterface mRefreshControllerInterface;

    public static Gson gson = new Gson();

    public static Retrofit createAPIRetrofit() {

        OkHttpClient httpclint = new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                .addInterceptor(new AutoInterceptor())
                .retryOnConnectionFailure(true)
                .build();


        Retrofit build = new Retrofit.Builder()
                .client(httpclint)
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConvert.create()) // 自定义，重写转换
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return build;
    }
}

