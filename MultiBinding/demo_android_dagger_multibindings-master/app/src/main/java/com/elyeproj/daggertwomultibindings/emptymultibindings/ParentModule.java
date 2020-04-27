package com.elyeproj.daggertwomultibindings.emptymultibindings;

import java.util.Map;
import java.util.Set;

import dagger.Module;
import dagger.multibindings.Multibinds;

@Module
abstract class ParentModule {

    @Multibinds
    abstract Set<String> aSet();

    @Multibinds
    abstract Map<String, String> aMap();
}
