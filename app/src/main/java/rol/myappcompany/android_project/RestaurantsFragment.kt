package rol.myappcompany.android_project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import rol.myappcompany.android_project.R
import java.lang.reflect.Array.newInstance

class RestaurantsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        val view : View = inflater.inflate(R.layout.fragment_restaurants, container, false)





        return view
    }

}


