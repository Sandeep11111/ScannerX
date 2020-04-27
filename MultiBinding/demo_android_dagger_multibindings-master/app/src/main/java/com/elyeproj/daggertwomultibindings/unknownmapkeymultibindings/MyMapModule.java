package com.elyeproj.daggertwomultibindings.unknownmapkeymultibindings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import dagger.Module;
import dagger.Provides;

@Module(includes = MyModule.class)
class MyMapModule {
    @Provides
    static Map<String, String> randomKeyValueMap(Set<Map.Entry<String, String>> entries) {
        Map<String, String> randomKeyValueMap = new LinkedHashMap<>(entries.size());
        for (Map.Entry<String, String> entry : entries) {
            randomKeyValueMap.put(entry.getKey(), entry.getValue());
        }
        return randomKeyValueMap;
    }
}
