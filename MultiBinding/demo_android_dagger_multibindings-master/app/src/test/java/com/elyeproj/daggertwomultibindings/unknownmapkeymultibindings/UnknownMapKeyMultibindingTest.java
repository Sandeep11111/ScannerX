package com.elyeproj.daggertwomultibindings.unknownmapkeymultibindings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnknownMapKeyMultibindingTest {

    @Test
    public void testMyComponent() {
        MyComponent myComponent = DaggerMyComponent.create();
        assertEquals(2, myComponent.runtimeKeyMapMultiBinding().size());
        System.out.println(myComponent.runtimeKeyMapMultiBinding());
    }
}
