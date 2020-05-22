package com.example.myfeature

import com.example.myfeature.models.DummyResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MyFeatureService {
    @get:GET("v1/employees")
    val dummyRestResponse: Observable<List<DummyResponse>>
}