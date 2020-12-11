package rol.myappcompany.android_project.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import rol.myappcompany.android_project.model.Restaurants

enum class ApiStatus{LOADING, ERROR, DONE}

class RestaurantsViewModel: ViewModel() {
    private val _status = MutableLiveData<ApiStatus>()

    val status: LiveData<ApiStatus>
    get() = _status

    private val _properties = MutableLiveData<List<Restaurants>>()

    val properties: LiveData<List<Restaurants>>
    get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )


    init{
        getRealEstateProperties()
    }

    private fun getRealEstateProperties() {

        coroutineScope.launch {
            var getPropertiesDeferred = RestaurantsApi.retrofitService.getProperties()
            try {
                _status.value = ApiStatus.LOADING

                val listResult =  getPropertiesDeferred.await()
                _status.value = ApiStatus.DONE
                _properties.value = listResult.restaurants
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }


    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

