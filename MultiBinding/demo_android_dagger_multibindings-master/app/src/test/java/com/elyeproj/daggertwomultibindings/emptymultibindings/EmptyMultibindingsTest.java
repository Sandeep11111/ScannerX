package com.elyeproj.daggertwomultibindings.emptymultibindings;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class EmptyMultibindingsTest {
    @Test
    public void testMultibindings() {
        ParentComponent parentComponent = DaggerParentComponent.create();
        assertEquals(0, parentComponent.strings().size());
        assertEquals(0, parentComponent.stringMap().size());

        Set expectedChildSet = new HashSet<String>(Arrays.asList("child string 3", "child string 4"));
        Set expectedChildMap = new HashSet<String>(Arrays.asList("c", "d"));

        ChildComponent childComponent = parentComponent.childComponent();

        assertEquals(2, childComponent.strings().size());
        assertTrue(childComponent.strings().containsAll(expectedChildSet));
        assertEquals(2, childComponent.stringMap().size());
        assertTrue(childComponent.stringMap().keySet().containsAll(expectedChildMap));
    }
}