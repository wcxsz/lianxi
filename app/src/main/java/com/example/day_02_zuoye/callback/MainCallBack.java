package com.example.day_02_zuoye.callback;

import com.example.day_02_zuoye.bean.DaBean;

public interface MainCallBack {
    void onSuccess(DaBean daBean);
    void onFail(String string);
}
