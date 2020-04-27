package com.elyeproj.daggertwomultibindings.emptymultibindings;

import java.util.Map;
import java.util.Set;

import dagger.Component;

@Component(modules = ParentModule.class)
interface ParentComponent {
    Set<String> strings();
    Map<String, String> stringMap();
    ChildComponent childComponent();
}
