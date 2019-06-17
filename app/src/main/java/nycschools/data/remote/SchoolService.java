package nycschools.data.remote;

import java.util.List;

import io.reactivex.Single;
import nycschools.data.remote.model.SchoolDetailResponse;
import nycschools.data.remote.model.SchoolListResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolService {
    /**
     * https://data.cityofnewyork.us/resource/97mf-9njv.json
     *
     * @return
     */
    @GET("97mf-9njv.json")
    Single<List<SchoolListResponse>> getSchoolList();

    /**
     * https://data.cityofnewyork.us/resource/734v-jeq5.json
     *
     * @param dbn
     * @return
     */
    @GET("734v-jeq5.json")
    Single<List<SchoolDetailResponse>> getSchoolDetails(@Query("dbn") String dbn);
}
