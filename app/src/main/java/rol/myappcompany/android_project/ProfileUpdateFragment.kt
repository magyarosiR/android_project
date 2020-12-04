package rol.myappcompany.android_project

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

        val nameText: EditText = view.findViewById<EditText>(R.id.name_id)
        val adressText: EditText = view.findViewById<EditText>(R.id.adress_id)
        val emailText: EditText = view.findViewById<EditText>(R.id.email_id)
        val phoneNumberText: EditText = view.findViewById<EditText>(R.id.phone_number_id)
        val imgButton: ImageButton = view.findViewById<ImageButton>(R.id.imgbtn_instert)

        var db = context?.let { DataBaseHandler(context = it) }

        fun instert() {
            if (nameText.text.toString().length > 0 &&
                    adressText.text.toString().length > 0 &&
                    phoneNumberText.text.toString().length > 0 &&
                    emailText.text.toString().length > 0) {
                var profile = Profile(nameText.text.toString(), adressText.text.toString(), phoneNumberText.text.toString().toInt(), emailText.text.toString())

                db?.insertData(profile)
            }
        }

        imgButton.setOnClickListener({



        })

        instertButton.setOnClickListener({
            if(id>1){
                db!!.deleteData()
                instert()
            }else{
                instert()
            }
        })
        return view
    }

}




