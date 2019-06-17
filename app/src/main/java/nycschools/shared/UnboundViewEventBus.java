package nycschools.shared;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

@Singleton
public class UnboundViewEventBus {

    @Inject
    UnboundViewEventBus() {
    }

    private final PublishSubject<FinishActivityEvent> finishActivitySubject = PublishSubject.create();
    private final PublishSubject<StartActivityEvent> startActivitySubject = PublishSubject.create();

    public void send(FinishActivityEvent event) {
        finishActivitySubject.onNext(event);
    }

    public void send(StartActivityEvent event) {
        startActivitySubject.onNext(event);
    }

    public Observable<StartActivityEvent> startActivity(Object viewModel) {
        return startActivity(viewModel.getClass());
    }

    public Observable<StartActivityEvent> startActivity(Class viewModelClass) {
        return startActivitySubject.filter(event -> fromEmitter(event, viewModelClass));
    }

    public Observable<FinishActivityEvent> finishActivity(Class viewModelClass) {
        return finishActivitySubject.filter(event -> fromEmitter(event, viewModelClass));
    }

    public Observable<FinishActivityEvent> finishActivity(Object viewModel) {
        return finishActivity(viewModel.getClass());
    }

    private boolean fromEmitter(BaseUnboundViewEvent event, Class viewModelClass) {
        return viewModelClass.getName().equals((event).getEmitter().getClass().getName());
    }
}
