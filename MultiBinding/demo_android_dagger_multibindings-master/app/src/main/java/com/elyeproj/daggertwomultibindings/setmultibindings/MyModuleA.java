package com.elyeproj.daggertwomultibindings.setmultibindings;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
class MyModuleA {
    @Provides
    @IntoSet
    @QualifySetOne
    static String provideOneString(DepA depA, DepB depB) {
        return "ABC";
    }
}
