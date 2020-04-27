package com.example.multipledatabindingbasicapplication;

import java.util.Map;
import java.util.Set;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    Set<String> stringSetValues();
    Map<String, String> stringMapValues();
}
