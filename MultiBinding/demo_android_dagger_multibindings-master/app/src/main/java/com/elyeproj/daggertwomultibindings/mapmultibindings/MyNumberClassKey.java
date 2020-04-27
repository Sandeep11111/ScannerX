package com.elyeproj.daggertwomultibindings.mapmultibindings;

import dagger.MapKey;

@MapKey
@interface MyNumberClassKey {
    Class<? extends Number> value();
}
