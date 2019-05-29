package com.example.day_02_zuoye.presenter;

import com.example.day_02_zuoye.bean.DaBean;
import com.example.day_02_zuoye.callback.MainCallBack;
import com.example.day_02_zuoye.model.Model;
import com.example.day_02_zuoye.model.ModelImpl;
import com.example.day_02_zuoye.view.MainView;

public class PresenterImpl implements Presenter, MainCallBack {
    private ModelImpl model;
    private MainView view;

    public PresenterImpl(ModelImpl model, MainView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData() {
        model.getData(this);
    }

    @Override
    public void onSuccess(DaBean daBean) {
        view.onSuccess(daBean);
    }

    @Override
    public void onFail(String string) {
        view.onFail(string);
    }
}
