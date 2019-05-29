package com.example.day_02_zuoye.model;

import com.example.day_02_zuoye.api.MyServer;
import com.example.day_02_zuoye.bean.DaBean;
import com.example.day_02_zuoye.callback.MainCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelImpl implements Model {
    @Override
    public void getData(final MainCallBack mainCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.Url1)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<DaBean> data = myServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DaBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DaBean daBean) {
                        mainCallBack.onSuccess(daBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
