package com.elyeproj.daggertwomultibindings.subcomponentmultibindings;

import java.util.Map;
import java.util.Set;

import dagger.Subcomponent;

@Subcomponent(modules = ChildModule.class)
interface ChildComponent {
    Set<String> strings();
    Map<String, String> stringMap();
}
