package com.example.temitest_mvp.profile;

import com.example.temitest_mvp.bean.ContactsBean;

public interface DetailsContract {

    interface IPresenter{
        void sendPushNotification(ContactsBean contactsBean);

    }

    interface IView{
        void onSendSuccess();
        void onSendFaild();
    }
}
