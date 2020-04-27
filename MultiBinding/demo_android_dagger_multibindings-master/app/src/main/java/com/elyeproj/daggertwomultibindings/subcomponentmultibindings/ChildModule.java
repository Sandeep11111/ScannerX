package com.elyeproj.daggertwomultibindings.subcomponentmultibindings;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

@Module
class ChildModule {
    @Provides
    @IntoSet
    static String string3() {
        return "child string 3";
    }

    @Provides
    @IntoSet
    static String string4() {
        return "child string 4";
    }

    @Provides
    @IntoMap
    @StringKey("c")
    static String stringC() {
        return "child string C";
    }

    @Provides
    @IntoMap
    @StringKey("d")
    static String stringD() {
        return "child string D";
    }
}
