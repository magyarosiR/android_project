package rol.myappcompany.android_project

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://opentable.herokuapp.com/"
//private const val BASE_URL = "http://opentable.herokuapp.com/api/restaurants?city=toronto"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService{
    @GET("api/restaurants?name=Chicago")
    fun getProperties():
            Call<String>
}

object RestaurantsApi{
    val retrofitService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}