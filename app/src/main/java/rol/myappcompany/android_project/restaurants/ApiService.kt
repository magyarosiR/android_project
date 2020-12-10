package rol.myappcompany.android_project.restaurants

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import rol.myappcompany.android_project.model.Restaurants

private const val BASE_URL = "https://opentable.herokuapp.com/"
//private const val BASE_URL = "http://opentable.herokuapp.com/api/restaurants?city=toronto"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()




private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService{
    @GET("api/restaurants?name=Chicago")
    fun getProperties():
            Call<List<Restaurants>>
}

object RestaurantsApi{
    val retrofitService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}