package nycschools.shared;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.sandeepkumarsingh.nycschoolsviewmodel.SchoolsApp;

import java.io.IOException;
import java.io.InputStream;

import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import nycschools.di.AppComponent;

import static nycschools.shared.ViewCallbackEmitter.LEAVE_ACTIVITY;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT = "ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT";

    @Nullable
    protected CompositeDisposable registerUnboundViewEvents() {
        return null;
    }

    private final CompositeDisposable lifecycleSubscriptions = new CompositeDisposable();
    private final ViewCallbackEmitter viewCallbackEmitter = new ViewCallbackEmitter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.getBoolean(ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT, false)) {
            Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        // Manual injection of classes from ObjectGraph because we don't want every Activity to need injection
        AppComponent component = SchoolsApp.getComponent();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        this.getApplicationContext();
        subscribeToEventBus();
        super.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getViewCallbackEmitter().fireEvent(ViewCallbackEmitter.ViewCallback.ON_ACTIVITY_POST_RESUME, null);
    }

    @Override
    protected void onPause() {
        lifecycleSubscriptions.clear();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        viewCallbackEmitter.fireEvent(ViewCallbackEmitter.ViewCallback.ON_OPTIONS_ITEM_SELECTED, item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (viewCallbackEmitter.fireOnBackPressed() == LEAVE_ACTIVITY) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getViewCallbackEmitter().fireEvent(ViewCallbackEmitter.ViewCallback.ON_ACTIVITY_RESULT, new ActivityResult(requestCode, resultCode, data));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (!isFinishing()) {
            outState.putBoolean(ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT, true);
        }
        viewCallbackEmitter.fireEvent(ViewCallbackEmitter.ViewCallback.ON_SAVE_INSTANCE_STATE, null);
        super.onSaveInstanceState(outState);
    }

    protected void subscribeOnLifecycle(Disposable disposable) {
        lifecycleSubscriptions.add(disposable);
    }

    protected void startActivity(StartActivityEvent event) {
        int flags = event.getIntentFlags();
        boolean hasExtras = event.hasExtras();

         if (event.isStartActivityForResult()) {
            if (event.getIntent() != null) {
                if (hasExtras) {
                    Intent intent = new Intent(this, event.getStartActivity()).putExtras(event.getIntent());
                    startActivityForResult(intent, event.getRequestCode());
                } else {
                    startActivityForResult(event.getIntent(), event.getRequestCode());
                }
            } else {
                startActivityForResult(new Intent(this, event.getStartActivity()), event.getRequestCode());
            }
        } else {
            Intent startIntent = new Intent(this, event.getStartActivity());

            startActivity(startIntent);
        }
    }

    protected void finishActivity(FinishActivityEvent event) {
        if (event.isFinishAffinity()) {
            this.finishAffinity();
        } else {
            this.finish();
        }

    }
    public ViewCallbackEmitter getViewCallbackEmitter() {
        return viewCallbackEmitter.init(getLifecycle());
    }

    private void subscribeToEventBus() {
        lifecycleSubscriptions.clear();
        CompositeDisposable eventsSubscriptionV2 = registerUnboundViewEvents();
        if (eventsSubscriptionV2 != null) {
            lifecycleSubscriptions.add(eventsSubscriptionV2);
        }
    }
}
