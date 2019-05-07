package com.example.temitest.api;


import com.example.temitest.bean.ContactsBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface ContactsDataApi {

    @GET("contacts_mock_short.json")
    Observable<List<ContactsBean>> getContactsData();
}
