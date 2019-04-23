package com.example.temitest_mvp.contacts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.temitest_mvp.R;
import com.example.temitest_mvp.adapter.ContactsListAdapter;
import com.example.temitest_mvp.bean.ContactsBean;
import com.example.temitest_mvp.profile.DetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsListActivity extends AppCompatActivity implements ContactsContract.IView {
    private static final String TAG = "ContactsListActivity";
    @BindView(R.id.lv_contact_list)
    ListView lvContactList;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    private ContactsListAdapter adapter;
    private ContactsPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);
        presenter = new ContactsPresenter(this);
        initView();
        initData();


    }

    private void initView() {
    }

    private void initData() {
        presenter.requestData();
    }


    @Override
    public void onLoading() {
        Log.d(TAG, "onLoading: ");
        progressDialog = ProgressDialog.show(this, "Loading...","");

    }

    @Override
    public void onRequestSuccess(List<ContactsBean> contactsBeans) {
        progressDialog.dismiss();
        initListView(contactsBeans);
        Log.d(TAG, "onRequestSuccess: ");
    }

    @Override
    public void onError() {
        progressDialog.dismiss();
        Toast.makeText(this, "network error", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onError: ");
    }


    private void initListView(final List<ContactsBean> mListData) {
        Log.d(TAG, "initListView: " + mListData.get(0).getAddress());
        adapter = new ContactsListAdapter(this, R.layout.contacts_list_item, mListData);
        lvContactList.setDivider(null);
        lvContactList.setAdapter(adapter);
        lvContactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContactsListActivity.this, DetailsActivity.class);
                intent.putExtra("contact_info", mListData.get(position));
                startActivity(intent);

            }
        });
    }
}
