package rol.myappcompany.android_project.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import rol.myappcompany.android_project.model.Restaurants

class RestaurantsViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
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
                var listResult = getPropertiesDeferred.await()
                if (listResult.restaurants.size > 0) {
                    _properties.value = listResult.restaurants
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }


    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

