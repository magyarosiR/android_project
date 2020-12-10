package rol.myappcompany.android_project.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import rol.myappcompany.android_project.model.Reqres
import rol.myappcompany.android_project.model.Restaurants

class RestaurantsViewModel: ViewModel() {
    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
    get() = _response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )


    init{
        getRealEstateProperties()
    }

    private fun getRealEstateProperties() {

        coroutineScope.launch {
            var getPropertiesDeferred = RestaurantsApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeferred.await()
                _response.value = "Success: ${listResult.restaurants.size} Mars properties retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }


    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

