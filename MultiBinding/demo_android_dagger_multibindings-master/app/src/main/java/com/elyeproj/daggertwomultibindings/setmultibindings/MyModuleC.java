package com.elyeproj.daggertwomultibindings.setmultibindings;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
class MyModuleC {
    @Provides
    @IntoSet
    @QualifySetTwo
    static String provideOneString(DepA depA, DepB depB) {
        return "123";
    }
}
