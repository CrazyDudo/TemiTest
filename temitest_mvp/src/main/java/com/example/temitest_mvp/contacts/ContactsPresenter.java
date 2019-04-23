package com.example.temitest_mvp.contacts;


import android.util.Log;

import com.example.temitest_mvp.api.ApiManage;
import com.example.temitest_mvp.bean.ContactsBean;

import java.util.Collections;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ContactsPresenter implements ContactsContract.IPresenter {
    private ContactsContract.IView view;
    private static final String TAG = "ContactsPresenter";

    public ContactsPresenter(ContactsContract.IView view) {
        this.view = view;
    }

    @Override
    public void requestData() {
        doRequestData();
    }


    @Override
    public void sortData() {

    }


    private void doRequestData() {
        view.onLoading();
        ApiManage.getInstance()
                .getDataService()
                .getContactsData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ContactsBean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError();
                        Log.d(TAG, "onError: " + e.getMessage());

                    }

                    @Override
                    public void onNext(List<ContactsBean> contactsBeans) {

                        view.onRequestSuccess(contactsBeans);
                        Log.d(TAG, "onNext: " + contactsBeans.get(0).getEmail());

                        //sort
                        Collections.sort(contactsBeans);
                        Collections.reverse(contactsBeans);

                    }

                });


    }


}
