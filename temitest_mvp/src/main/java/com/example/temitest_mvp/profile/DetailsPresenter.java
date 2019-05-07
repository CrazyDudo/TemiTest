package com.example.temitest_mvp.profile;

import android.util.Log;

import com.example.temitest_mvp.api.ApiManage;
import com.example.temitest_mvp.bean.ContactsBean;
import com.example.temitest_mvp.bean.JpushBean;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailsPresenter implements DetailsContract.IPresenter {
    private static final String TAG = "DetailsPresenter";
    private DetailsContract.IView view;

    public DetailsPresenter(DetailsContract.IView view) {
        this.view = view;
    }

    @Override
    public void sendPushNotification(ContactsBean contactsBean) {
        sendMessage(contactsBean);
    }

    private void sendMessage(ContactsBean contactsBean) {
        HashMap<String, Object> body = new HashMap<>();
        HashMap<String, String> notification = new HashMap();
        notification.put("alert", "Hi,this is a Temi test message from " + contactsBean.getFirst_name());
        body.put("platform", "all");
        body.put("audience", "all");
        body.put("notification", notification);

        ApiManage.getInstance()
                .getJpushService()
                .pushMessage(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JpushBean>() {

                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onSendFaild();
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(JpushBean jpushBean) {
                        view.onSendSuccess();
                        Log.d(TAG, "onNext: " + jpushBean.getMsg_id());
                    }
                });


    }


}
