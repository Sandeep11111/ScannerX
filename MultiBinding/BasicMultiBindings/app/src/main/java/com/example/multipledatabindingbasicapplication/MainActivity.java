package com.example.multipledatabindingbasicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyComponent myComponent = DaggerMyComponent.create();
        Set set = myComponent.stringSetValues();
        System.out.println("set------"+set);

        String first = myComponent.stringMapValues().get("myFirst");
        String second = myComponent.stringMapValues().get("mySecond");
        System.out.println("first+second------"+first+second);
    }
}
