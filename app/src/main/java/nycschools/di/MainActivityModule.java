package nycschools.di;

import com.example.sandeepkumarsingh.nycschoolsviewmodel.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    //@ContributesAndroidInjector(modules = FragmentsModule.class)

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
