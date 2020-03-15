package retrofit

import io.reactivex.Observable
import model.Post
import retrofit2.http.GET

interface IMyApi {
    @get:GET("Posts")
    val posts:Observable<List<Post>>
}