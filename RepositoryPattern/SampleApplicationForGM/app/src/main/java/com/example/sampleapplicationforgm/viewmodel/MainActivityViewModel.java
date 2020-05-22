package com.example.sampleapplicationforgm.viewmodel;

import com.example.basicapp.event.LaunchActivityEvent;
import com.example.basicapp.ui.DetailActivity;
import com.example.myfeature.MyFeatureService;
import com.example.myfeature.models.DummyResponse;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel implements LifecycleObserver {

    private MyFeatureService myFeatureService;
    public MutableLiveData<Boolean> shouldShowDescription = new MutableLiveData<>();
    public MutableLiveData<LaunchActivityEvent> launchDetailActivity = new MutableLiveData<>();

    @Inject
    public MainActivityViewModel(MyFeatureService myFeatureService) {
        this.myFeatureService = myFeatureService;
    }

    public void doApiCall() {
        shouldShowDescription.setValue(true);
        Disposable disposable = myFeatureService.getDummyRestResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> { System.out.println("***Success Response: ");
                    updateResponse(response);} , throwable -> System.out.println("***Error: " + throwable.getMessage()), () -> System.out.println("On Complete"));
    }

    private void updateResponse(List<DummyResponse> response) {
        for(DummyResponse dummyResponse : response) {
            System.out.println("***Employee ID:  " + dummyResponse.getId());
            System.out.println("***Employee Name:  " + dummyResponse.getName());
            System.out.println("***Employee Salary:  " + dummyResponse.getSalary());
        }
        shouldShowDescription.setValue(false);
    }

    public void launchDetailScreen() {
        launchDetailActivity.setValue(new LaunchActivityEvent(DetailActivity.class));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        System.out.println("MainActivityViewModel onCreate called ");
        shouldShowDescription.setValue(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        System.out.println("MainActivityViewModel onResume called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        System.out.println("MainActivityViewModel onStart called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        System.out.println("MainActivityViewModel onStop called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        System.out.println("MainActivityViewModel onPause called ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        System.out.println("MainActivityViewModel onDestroy called ");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
