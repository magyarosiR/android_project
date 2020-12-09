package rol.myappcompany.android_project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment


class ProfileFragment : Fragment() {

    //lateinit var dataPic: Uri


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        val updateButton = view.findViewById<Button>(R.id.btn_update)

        val profileResuls = view.findViewById<TextView>(R.id.text_results_profile)
        val imgButton: Button = view.findViewById<Button>(R.id.btn_update_profilepic)

        updateButton?.setOnClickListener { view ->
            val fragment = ProfileUpdateFragment()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout, fragment)
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }

        var db = context?.let { DataBaseHandler(context = it) }

        //read the data to the profile screen
        var data = db?.readData()
        profileResuls.text = ""
        val profilePicture = view!!.findViewById<ImageView>(R.id.profile_picture)

        if (data != null) {
            for (i in 0..(data.size - 1)) {
                profileResuls.append("\nName: " + data.get(i).name + "\n\nAdress: "
                        + data.get(i).adress + "\n\nPhone Number:  " + data.get(i).phone_number + "\n\nEmail:  " + data.get(i).email + '\n')
                var imgUri = Uri.parse(data.get(i).img)
                profilePicture!!.setImageURI(imgUri)

            }
        }

        if (profileResuls.text == "") {
            profileResuls.append("You don't have any data yet. \n\n Please update your profile!")
        }

        imgButton.setOnClickListener({
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        })
        return view

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val profilePicture = requireView().findViewById<ImageView>(R.id.profile_picture)

        if (requestCode == 456) {
            profilePicture!!.setImageURI(data?.data)
            val dataPic = data?.data.toString()

            var db = context?.let { DataBaseHandler(context = it) }

            var data = db?.readData()
            if(id>1){
                db!!.deleteData()
            }
            if (data != null) {
                for (i in 0..(data.size-1)) {
                    var name = data.get(i).name
                    var adress = data.get(i).adress
                    var phone_number = data.get(i).phone_number
                    var email = data.get(i).email
                    var profile = Profile(name, adress, phone_number, email, dataPic)

                    db?.insertData(profile)
                }
            }
        }
    }
}