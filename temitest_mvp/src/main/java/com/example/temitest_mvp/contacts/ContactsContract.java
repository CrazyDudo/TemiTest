package com.example.temitest_mvp.contacts;

import com.example.temitest_mvp.bean.ContactsBean;

import java.util.List;

public interface ContactsContract {

    interface IPresenter{
        void requestData();
        void sortData();
    }

    interface IView{
        void onLoading();
        void onRequestSuccess(List<ContactsBean> contactsBeans);
        void onError();
    }
}
