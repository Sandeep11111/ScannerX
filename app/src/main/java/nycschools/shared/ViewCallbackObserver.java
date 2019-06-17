package nycschools.shared;

import android.app.Instrumentation;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.IdRes;
import android.support.v4.content.PermissionChecker;

public interface ViewCallbackObserver extends LifecycleObserver{
    default void onHidden() {}
    default void onUnhidden() {}
    default void onOptionsItemSelected(@IdRes int itemId) {}
    default void onPermissionsResult(PermissionChecker.PermissionResult result) {}
    default void onActivityResult(Instrumentation.ActivityResult results) {}
    default boolean onBackPressed() {return ViewCallbackEmitter.LEAVE_ACTIVITY;}
    default void setUserVisibleHint(boolean isVisibleToUser) {}
    default void onSaveInstanceState() {}
    default void onPostResume() {}
}
