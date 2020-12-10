package rol.myappcompany.android_project.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import rol.myappcompany.android_project.model.Restaurants

class RestaurantsViewModel: ViewModel() {
    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
    get() = _response

    init{
        getRealEstateProperties()
    }

    private fun getRealEstateProperties() {
        RestaurantsApi.retrofitService.getProperties().enqueue(object: retrofit2.Callback<List<Restaurants>>{

            override fun onFailure(call: Call<List<Restaurants>>, t: Throwable) {
                _response.value = "Failure: " +  t.message
            }

            override fun onResponse(
                call: Call<List<Restaurants>>,
                response: Response<List<Restaurants>>
            ) {
                _response.value = "Success:  + ${response.body()?.size} properties pretriever"
            }

        })


        _response.value = "Set the  API Response here."

    }


}

