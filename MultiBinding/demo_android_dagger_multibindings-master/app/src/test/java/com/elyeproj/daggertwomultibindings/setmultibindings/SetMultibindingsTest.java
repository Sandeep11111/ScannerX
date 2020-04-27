package com.elyeproj.daggertwomultibindings.setmultibindings;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SetMultibindingsTest {

    @Test
    public void testMyComponent1() {
        Set expectedContains = new HashSet<String>(Arrays.asList("ABC", "DEF", "GHI"));

        MyComponent myComponent = DaggerMyComponent.create();
        assertEquals(3, myComponent.setOnestrings().size());
        assertTrue(myComponent.setOnestrings().containsAll(expectedContains));
    }

    @Test
    public void testMyComponent2() {
        Set expectedContains = new HashSet<String>(Arrays.asList("123", "456", "789"));

        MyComponent myComponent = DaggerMyComponent.create();
        assertEquals(3, myComponent.setTwostrings().size());
        assertTrue(myComponent.setTwostrings().containsAll(expectedContains));
    }
}
