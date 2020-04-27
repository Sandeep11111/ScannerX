package com.elyeproj.daggertwomultibindings.emptymultibindings;

import java.util.Map;
import java.util.Set;

import dagger.Subcomponent;
//https://medium.com/swlh/dagger-2-multibindings-reference-rewrite-70c23842b782
@Subcomponent(modules = ChildModule.class)
interface ChildComponent {
    Set<String> strings();
    Map<String, String> stringMap();
}
