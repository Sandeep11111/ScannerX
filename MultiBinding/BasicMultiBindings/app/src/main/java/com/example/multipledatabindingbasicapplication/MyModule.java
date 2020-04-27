package com.example.multipledatabindingbasicapplication;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

@Module
public class MyModule {

    // Set
    @Provides
    @IntoSet
    static String mySetFirstString(){
        return "This is my First set string";
    }

    @Provides
    @IntoSet
    static String mySetSecondString(){
        return "This is my Second set string";
    }
    // Set

    // Map
    @Provides
    @IntoMap
    @StringKey("myFirst")
    static String myMapFirstString(){
        return "This is my First map string";
    }

    @Provides
    @IntoMap
    @StringKey("mySecond")
    static String myMapSecondString(){
        return "This is my Second map string";
    }
    // Map
}
