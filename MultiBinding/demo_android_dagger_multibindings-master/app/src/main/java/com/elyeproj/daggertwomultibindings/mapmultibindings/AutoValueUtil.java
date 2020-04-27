package com.elyeproj.daggertwomultibindings.mapmultibindings;

import com.google.auto.value.AutoAnnotation;

public class AutoValueUtil {

    @AutoAnnotation
    static MyKey createMyKey(String name, Class<?> implementingClass, int[] thresholds) {
        return new AutoAnnotation_AutoValueUtil_createMyKey(name, implementingClass, thresholds);
    }
}
