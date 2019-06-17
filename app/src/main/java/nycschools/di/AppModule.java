package nycschools.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nycschools.data.remote.SchoolRepository;
import nycschools.data.remote.SchoolService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

//@Module(includes = PresenterModule.class)
@Module
public class AppModule {

    @Provides
    @Singleton
    public SchoolService schoolService() {
        return new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/resource/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(SchoolService.class);
    }

    @Provides
    @Singleton
    public SchoolRepository schoolRepository(SchoolService schoolService) {
        return new SchoolRepository(schoolService);
    }
}
