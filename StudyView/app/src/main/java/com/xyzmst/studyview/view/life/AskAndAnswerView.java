package com.xyzmst.studyview.view.life;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import io.reactivex.Observable;


/**
 * @Date : 2/17/21
 * @Author : fzh
 * @Description :
 **/
public class AskAndAnswerView extends FrameLayout implements LifecycleObserver {

    private static final String TAG = "LifeView";
    private Controller controller;
    private EditBean data;

    public AskAndAnswerView(@NonNull Context context) {
        super(context);
        init();
    }

    public AskAndAnswerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AskAndAnswerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        controller = new Controller(getContext(), this);
        //添加生命周期监听
        ((LifecycleOwner) getContext()).getLifecycle().addObserver(this);
    }

    //生命周期方法 成功加载数据会加载view的bindData()方法
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        controller.loadData();
    }

    public void bindData(EditBean data) {
        this.data = data;
        Log.d(TAG, "bindData:: view绑定数据" + data.content);
    }

    public void showProgress() {
        Log.d(TAG, "showProgress::");
    }

    public void hideProgress() {
        Log.d(TAG, "hideProgress");
    }

    public void submit() {
        Log.d(TAG, "doSomething");
        controller.submit();
    }

    //编辑过的数据
    public String getEditContent() {
        return "edit " + data.content;
    }


    //业务扩展
    public interface EditTypeFactory {
        Observable getSubmitObservable(Context context, String content);

        void updateAndSync(Context context, Object o);

        String getOldContent(Context context);
    }

    public static class Builder {
        private Context context;
        private boolean oldContentEditable;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setOldContentEditable(boolean isEditable) {
            oldContentEditable = isEditable;
            return this;
        }

        public AskAndAnswerView build() {
            return new AskAndAnswerView(context);
        }
    }
}
