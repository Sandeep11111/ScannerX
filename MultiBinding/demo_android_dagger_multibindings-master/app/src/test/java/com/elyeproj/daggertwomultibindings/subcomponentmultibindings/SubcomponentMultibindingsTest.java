package com.elyeproj.daggertwomultibindings.subcomponentmultibindings;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SubcomponentMultibindingsTest {

    @Test
    public void testMultibindings() {
        Set expectedParentSet = new HashSet<String>(Arrays.asList("parent string 1", "parent string 2"));
        Set expectedParentMap = new HashSet<String>(Arrays.asList("a", "b"));

        ParentComponent parentComponent = DaggerParentComponent.create();
        assertEquals(2, parentComponent.strings().size());
        assertTrue(parentComponent.strings().containsAll(expectedParentSet));
        assertEquals(2, parentComponent.stringMap().size());
        assertTrue(parentComponent.stringMap().keySet().containsAll(expectedParentMap));


        Set expectedChildSet = new HashSet<String>(Arrays.asList(
                "parent string 1", "parent string 2", "child string 3", "child string 4"));
        Set expectedChildMap = new HashSet<String>(Arrays.asList("a", "b", "c", "d"));

        ChildComponent childComponent = parentComponent.childComponent();

        assertEquals(4, childComponent.strings().size());
        assertTrue(childComponent.strings().containsAll(expectedChildSet));
        assertEquals(4, childComponent.stringMap().size());
        assertTrue(childComponent.stringMap().keySet().containsAll(expectedChildMap));
    }
}
