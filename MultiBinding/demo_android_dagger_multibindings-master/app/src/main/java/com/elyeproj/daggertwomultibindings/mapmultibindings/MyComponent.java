package com.elyeproj.daggertwomultibindings.mapmultibindings;

import java.util.Map;

import javax.inject.Provider;

import dagger.Component;

@Component(modules = MyModule.class)
interface MyComponent {
    Map<String, Long> longsByString();
    Map<Class<?>, String> stringsByClass();

    Map<String, Provider<Long>> providerLongsByString();

    Map<MyEnum, String> myEnumStringMap();
    Map<Class<? extends Number>, String> stringsByNumberClass();

    Map<MyKey, String> myKeyStringMap();
}
