package com.example.basicandroidarchitecture.ui;

import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.view.View;

import com.example.basicandroidarchitecture.R;
import com.example.myfeaturemodule.models.DummyResponse;
import com.example.myfeaturemodule.service.MyFeatureService;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MyFeatureService myFeatureService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doApiCall(View view){
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
    }
}
