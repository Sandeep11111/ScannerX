package com.elyeproj.daggertwomultibindings.mapmultibindings;

import java.math.BigDecimal;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
class MyModule {
    @Provides
    @IntoMap
    @StringKey("foo")
    static Long provideFooValue() {
        return 100L;
    }

    @Provides
    @IntoMap
    @StringKey("boo")
    static Long provideBooValue() {
        return 200L;
    }

    @Provides
    @IntoMap
    @ClassKey(Thing.class)
    static String provideThingValue() {
        return "value for Thing";
    }

    @Provides
    @IntoMap
    @MyEnumKey(MyEnum.ABC)
    static String provideABCValue() {
        return "value for ABC";
    }

    @Provides
    @IntoMap
    @MyNumberClassKey(BigDecimal.class)
    static String provideBigDecimalValue() {
        return "value for BigDecimal";
    }

    @Provides
    @IntoMap
    @MyKey(name = "abc", implementingClass = Abc.class, thresholds = {1, 5, 10})
    static String provideAbc1510Value() {
        return "foo";
    }
}
