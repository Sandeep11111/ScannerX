package nycschools.shared;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.content.PermissionChecker;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseLifecycleViewModel implements ViewCallbackObserver {
    private ViewCallbackEmitter viewCallbackEmitter;
    private CompositeDisposable lifecycleSubscriptionsV2 = new CompositeDisposable();

    public ViewCallbackEmitter getViewCallbackEmitter() {
        return viewCallbackEmitter;
    }

    public void setViewCallbackEmitter(ViewCallbackEmitter viewCallbackEmitter) {
        this.viewCallbackEmitter = viewCallbackEmitter;
        this.viewCallbackEmitter.addObserver(this);
    }

    protected void subscribeOnLifecycle(Disposable disposable) {
        lifecycleSubscriptionsV2.add(disposable);
    }

    //region Lifecycle Methods

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        lifecycleSubscriptionsV2.clear();
    }
    //endregion
}
