package com.elyeproj.daggertwomultibindings.setmultibindings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;

@Module
class MyModuleD {
    @Provides
    @ElementsIntoSet
    @QualifySetTwo
    static Set<String> provideSomeStrings(DepA depA, DepB depB) {
        return new HashSet<String>(Arrays.asList("456", "789"));
    }
}
