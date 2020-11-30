package rol.myappcompany.android_project

import android.content.Context
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
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text
import rol.myappcompany.android_project.R
import java.lang.reflect.Array.newInstance


class ProfileUpdateFragment : Fragment() {
    var isMyBoolean = false



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_profile_update, container, false)

        //val valami: TextView = view?.findViewById<TextView>(R.id.valami)
        val instertButton: Button = view.findViewById<Button>(R.id.btn_insert)

        instertButton.setOnClickListener {
        


        }
        return view
    }

}




