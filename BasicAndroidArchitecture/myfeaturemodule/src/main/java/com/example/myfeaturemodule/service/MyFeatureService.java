package com.example.myfeaturemodule.service;

import com.example.myfeaturemodule.models.DummyResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyFeatureService {

    @GET("v1/employees")
    Observable<List<DummyResponse>> getDummyRestResponse();
}
