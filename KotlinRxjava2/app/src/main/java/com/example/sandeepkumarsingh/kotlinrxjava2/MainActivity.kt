package com.example.sandeepkumarsingh.kotlinrxjava2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sandeepkumarsingh.kotlinrxjava2.R.id.text
import java.util.*
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //https://www.youtube.com/watch?v=v7drKJyxo10&list=PL8g0JDLEKun5cDCSkiLkZ1t4r0kE4j0sV
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTextFromNetwork()
        /* Observable.fromArray("sandy", "shalini", "kiran")
                 .subscribeOn(Schedulers.newThread())
                 .filter { item -> item == "sandy" }
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe { onNext -> println("name: $onNext") }*/
    }

    fun getTextFromNetwork() {
        val tasks = Observable.create<String> { subscriber ->
            val net = "aaaa"
            try {
                subscriber.onNext(net)
            } catch (e: Exception) {
                subscriber.onError(e)
            }
            subscriber.onComplete()
        }
        tasks.subscribeOn(Schedulers.newThread())
        tasks.observeOn(AndroidSchedulers.mainThread())
                .subscribe { onNext -> println("name: $onNext") }
    }
}
