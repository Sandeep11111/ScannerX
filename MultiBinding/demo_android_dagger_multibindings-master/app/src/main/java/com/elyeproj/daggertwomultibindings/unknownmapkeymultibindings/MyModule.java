package com.elyeproj.daggertwomultibindings.unknownmapkeymultibindings;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

import static com.elyeproj.daggertwomultibindings.unknownmapkeymultibindings.RandomStringUtil.randomStringGenerator;
import static java.util.AbstractMap.SimpleImmutableEntry;

@Module
class MyModule {
    @Provides @IntoSet
    static Map.Entry<String, String> entryOne() {
        String key = randomStringGenerator();
        String value = "Random Value 1";
        return new SimpleImmutableEntry(key, value);
    }

    @Provides @IntoSet
    static Map.Entry<String, String> entryTwo() {
        String key = randomStringGenerator();
        String value = "Random Value 2";
        return new SimpleImmutableEntry(key, value);
    }
}
