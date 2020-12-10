package rol.myappcompany.android_project.restaurants

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rol.myappcompany.android_project.model.Reqres
import rol.myappcompany.android_project.model.Restaurants

private const val BASE_URL = "https://ratpark-api.imok.space/"
//private const val BASE_URL = "http://opentable.herokuapp.com/api/restaurants?city=toronto"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ApiService{
    @GET("restaurants")
    fun getProperties():
            Deferred<Reqres> //Deferred is a coroutine job than can directly return a result / Call helyett

                            //Coroutine: Sok ideig tarto feladatoknal hasznaljuk, hogy a fő szálat ne terhelje

    //fun getProperties(@Query("country")state: String, @Query("per_page")per_page: Int, @Query("page")current_page: Int): Call<Restaurants>
}

object RestaurantsApi{
    val retrofitService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}