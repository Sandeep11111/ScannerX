package com.elyeproj.daggertwomultibindings.unknownmapkeymultibindings;

import java.util.Map;

import dagger.Component;

@Component(modules = MyMapModule.class)
interface MyComponent {
    Map<String, String> runtimeKeyMapMultiBinding();

}
