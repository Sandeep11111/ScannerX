package nycschools.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableField;

import javax.inject.Inject;

import nycschools.shared.BaseLifecycleViewModel;
import nycschools.shared.FinishActivityEvent;
import nycschools.shared.UnboundViewEventBus;

public class MainViewModel extends BaseLifecycleViewModel {
    public final ObservableField<String> testText = new ObservableField<>();

    private final UnboundViewEventBus eventBus;

    @Inject
    public MainViewModel(UnboundViewEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
       testText.set("successfull");
    }

    public void navigateUp() {
        eventBus.send(FinishActivityEvent.build(this).finishActivityEvent());
    }
}
