package com.example.day_02_zuoye.api;

import com.example.day_02_zuoye.bean.DaBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {

    public String Url1 = "http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=30&page=1")
    Observable<DaBean> getData();
}
