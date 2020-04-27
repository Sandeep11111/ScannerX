package com.elyeproj.daggertwomultibindings.setmultibindings;

import java.util.Set;

import dagger.Component;

@Component(modules = {MyModuleA.class, MyModuleB.class, MyModuleC.class, MyModuleD.class})
interface MyComponent {
    @QualifySetOne Set<String> setOnestrings();
    @QualifySetTwo Set<String> setTwostrings();
}
