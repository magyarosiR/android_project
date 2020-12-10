package rol.myappcompany.android_project.profile


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import rol.myappcompany.android_project.profile. DataBaseHandler
import rol.myappcompany.android_project.R


class ProfileUpdateFragment : Fragment() {
    var isMyBoolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_profile_update, container, false)

        val instertButton: Button = view.findViewById<Button>(R.id.btn_insert)

        val nameText: EditText = view.findViewById<EditText>(R.id.name_id)
        val adressText: EditText = view.findViewById<EditText>(R.id.adress_id)
        val emailText: EditText = view.findViewById<EditText>(R.id.email_id)
        val phoneNumberText: EditText = view.findViewById<EditText>(R.id.phone_number_id)

        var db = context?.let { DataBaseHandler(context = it) }

        fun insert() {
            var data = db?.readData()
            var imgUri = ""
            if (data != null) {
                for (i in 0..(data.size - 1)) {
                    imgUri = data.get(i).img
                }
            }

            if (nameText.text.toString().length > 0 &&
                    adressText.text.toString().length > 0 &&
                    phoneNumberText.text.toString().length > 0 &&
                    emailText.text.toString().length > 0) {
                var profile = Profile(nameText.text.toString(), adressText.text.toString(), phoneNumberText.text.toString().toInt(), emailText.text.toString(),imgUri)
                db!!.deleteData()
                db?.insertData(profile)
            }
        }

        instertButton.setOnClickListener({
            if(id>1){
                //db!!.deleteData()
            }
            insert()
        })
        return view
    }

}