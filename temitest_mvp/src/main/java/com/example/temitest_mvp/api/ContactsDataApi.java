package com.example.temitest_mvp.api;


import com.example.temitest_mvp.bean.ContactsBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface ContactsDataApi {

    @GET("contacts_mock_short.json")
    Observable<List<ContactsBean>> getContactsData();
}
