package com.example.day_02_zuoye.view;

import com.example.day_02_zuoye.bean.DaBean;

public interface MainView {
    void onSuccess(DaBean daBean);
    void onFail(String string);
}
