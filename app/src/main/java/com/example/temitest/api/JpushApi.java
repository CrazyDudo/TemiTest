package com.example.temitest.api;


import com.example.temitest.bean.JpushBean;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface JpushApi {

    //https://api.jpush.cn/v3/push
    @Headers({"Content-Type:application/json", "Authorization:Basic M2U5ODY3MmViMmQxYTBhM2RmMTc0N2IwOjgwMGU2OWVhY2I4OWQ1MjM4NzMyMDVlYQ=="})
    @POST("push")
    Observable<JpushBean> pushMessage(@Body() HashMap<String,Object> body);

}
