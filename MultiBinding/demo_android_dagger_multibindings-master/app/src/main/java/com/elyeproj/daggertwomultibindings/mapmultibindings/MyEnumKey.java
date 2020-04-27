package com.elyeproj.daggertwomultibindings.mapmultibindings;

import dagger.MapKey;

@MapKey
@interface MyEnumKey {
    MyEnum value();
}
