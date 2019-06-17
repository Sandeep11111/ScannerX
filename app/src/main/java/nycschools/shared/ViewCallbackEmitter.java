package nycschools.shared;

import android.app.Instrumentation;
import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.PermissionChecker;

import java.util.ArrayList;
import java.util.List;

public class ViewCallbackEmitter {
    public enum ViewCallback {
        ON_HIDDEN,   //Fragment ON_HIDDEN_CHANGED, hidden = true
        ON_UNHIDDEN,  //Fragment ON_HIDDEN_CHANGED, hidden = false
        ON_OPTIONS_ITEM_SELECTED,
        ON_REQUEST_PERMISSIONS_RESULT,
        ON_ACTIVITY_RESULT,
        ON_ACTIVITY_POST_RESUME,
        ON_BACK_PRESSED,
        ON_FRAGMENT_VISIBILITY_CHANGE,
        ON_SAVE_INSTANCE_STATE,
        ON_BACK_PRESSED_STAY_ON_SCREEN
    }

    public static final boolean LEAVE_ACTIVITY = true;
    public static final boolean CLOSE_MODAL = false;

    private Lifecycle baseLifecycle;

    private List<ViewCallbackObserver> viewCallbackObservers = new ArrayList<>();

    public ViewCallbackEmitter init(Lifecycle lifecycle) {
        baseLifecycle = lifecycle;
        return this;
    }

    public void fireEvent(@NonNull ViewCallback callback, @Nullable Object data) {
        for (ViewCallbackObserver observer : viewCallbackObservers) {
            switch (callback) {
                case ON_HIDDEN:
                    observer.onHidden();
                    break;
                case ON_UNHIDDEN:
                    observer.onUnhidden();
                    break;
                case ON_OPTIONS_ITEM_SELECTED:
                    observer.onOptionsItemSelected((int) data);
                    break;
                case ON_REQUEST_PERMISSIONS_RESULT:
                    if (data != null) {
                        observer.onPermissionsResult((PermissionChecker.PermissionResult) data);
                    }
                    break;
                case ON_ACTIVITY_RESULT:
                    if (data != null) {
                        observer.onActivityResult((Instrumentation.ActivityResult) data);
                    }
                    break;
                case ON_FRAGMENT_VISIBILITY_CHANGE:
                    observer.setUserVisibleHint((boolean) data);
                    break;
                case ON_SAVE_INSTANCE_STATE:
                    observer.onSaveInstanceState();
                    break;
                case ON_ACTIVITY_POST_RESUME:
                    observer.onPostResume();
                    break;
            }
        }
    }

    public boolean fireOnBackPressed() {
        for (ViewCallbackObserver observer : viewCallbackObservers) {
            if (!observer.onBackPressed()) {
                return CLOSE_MODAL;
            }
        }
        return LEAVE_ACTIVITY;
    }

    public void addObserver(ViewCallbackObserver viewCallbackObserver) {
        baseLifecycle.addObserver(viewCallbackObserver);
        this.viewCallbackObservers.add(viewCallbackObserver);
    }

    public Lifecycle getBaseLifecycle() {
        return baseLifecycle;
    }
}
