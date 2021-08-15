package com.xyzmst.studyview.view.life;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

//控制器
public class Controller {
    private Context context;
    private AskAndAnswerView view;
    AskAndAnswerView.EditTypeFactory factory;
    private static final String TAG = "Controller";

    public Controller(Context context, AskAndAnswerView lifeView, AskAndAnswerView.EditTypeFactory factory) {
        this.context = context;
        this.view = lifeView;
        this.factory = factory;
    }

    public void loadData() {
        EditBean bean = new EditBean();
        if (factory == null) {
            Log.e(TAG, "loadData:: factory = null");
        }
        bean.content = factory.getOldContent(context);
        view.showProgress();
        Log.d(TAG, "Controller::loadData:: 加载数据");
        view.bindData(bean);
        view.hideProgress();
    }

    public void submit() {
        Log.d(TAG, "Controller::submit ");

        if (factory == null) {
            Log.e(TAG,"controller==null");
        }
        if(factory.getSubmitObservable(context,view.getEditContent()) == null)return;
        submitSub = factory.getSubmitObservable(context,view.getEditContent())
                .compose(new ObservableTransformer() {
                    @NonNull
                    @Override
                    public ObservableSource apply(@NonNull Observable upstream) {
                        return upstream.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSch);
                    }
                })

    }

}