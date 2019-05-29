package com.example.day_02_zuoye;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.day_02_zuoye.adapter.RlvAdapter;
import com.example.day_02_zuoye.bean.DaBean;
import com.example.day_02_zuoye.model.ModelImpl;
import com.example.day_02_zuoye.presenter.Presenter;
import com.example.day_02_zuoye.presenter.PresenterImpl;
import com.example.day_02_zuoye.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView rlv;
    private ArrayList<DaBean.NewslistBean> list;
    private RlvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        rlv = (RecyclerView) findViewById(R.id.rlv);
        initData();
        rlv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RlvAdapter(list, this);
        rlv.setAdapter(adapter);
    }

    private void initData() {
        Presenter presenter = new PresenterImpl(new ModelImpl(),this);
        presenter.getData();
    }

    @Override
    public void onSuccess(DaBean daBean) {
        List<DaBean.NewslistBean> newslist = daBean.getNewslist();
        list.addAll(newslist);
        adapter.setList(list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFail(String string) {

    }
}
