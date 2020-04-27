package com.elyeproj.daggertwomultibindings.subcomponentmultibindings;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

@Module
class ParentModule {
    @Provides
    @IntoSet
    static String string1() {
        return "parent string 1";
    }

    @Provides
    @IntoSet
    static String string2() {
        return "parent string 2";
    }

    @Provides
    @IntoMap
    @StringKey("a")
    static String stringA() {
        return "parent string A";
    }

    @Provides
    @IntoMap
    @StringKey("b")
    static String stringB() {
        return "parent string B";
    }
}
