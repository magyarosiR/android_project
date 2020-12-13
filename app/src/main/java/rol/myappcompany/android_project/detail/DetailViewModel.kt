package rol.myappcompany.android_project.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import rol.myappcompany.android_project.model.Restaurants


class DetailViewModel(rest: Restaurants, app: Application): AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<Restaurants>()

    val selectedProperty: LiveData<Restaurants>
        get() = _selectedProperty

    init {
        _selectedProperty.value = rest
    }
}