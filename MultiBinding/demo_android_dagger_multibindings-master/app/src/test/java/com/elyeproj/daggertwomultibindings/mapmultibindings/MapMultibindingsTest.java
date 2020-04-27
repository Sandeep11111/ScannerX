package com.elyeproj.daggertwomultibindings.mapmultibindings;

import org.junit.Test;

import java.math.BigDecimal;

import static com.elyeproj.daggertwomultibindings.mapmultibindings.AutoValueUtil.createMyKey;
import static org.junit.Assert.assertEquals;

public class MapMultibindingsTest {

    @Test
    public void testMyComponenSimpleMap() {
        MyComponent myComponent = DaggerMyComponent.create();

        assertEquals(2, myComponent.longsByString().size());
        assertEquals(100L, myComponent.longsByString().get("foo").longValue());
        assertEquals(200L, myComponent.longsByString().get("boo").longValue());

        assertEquals(1, myComponent.stringsByClass().size());
        assertEquals("value for Thing", myComponent.stringsByClass().get(Thing.class));
    }

    @Test
    public void testMyComponentSimpleProviderMap() {
        MyComponent myComponent = DaggerMyComponent.create();
        assertEquals(2, myComponent.providerLongsByString().size());
        assertEquals(100L, myComponent.providerLongsByString().get("foo").get().longValue());
        assertEquals(200L, myComponent.providerLongsByString().get("boo").get().longValue());
    }

    @Test
    public void testMyComponentEnumMap() {
        MyComponent myComponent = DaggerMyComponent.create();
        assertEquals("value for ABC", myComponent.myEnumStringMap().get(MyEnum.ABC));
        assertEquals("value for BigDecimal", myComponent.stringsByNumberClass().get(BigDecimal.class));
    }

    @Test
    public void testMyComponentComplexMap() {
        MyComponent myComponent = DaggerMyComponent.create();
        assertEquals("foo",
                myComponent.myKeyStringMap().get(createMyKey("abc", Abc.class, new int[] {1, 5, 10})));
    }
}
