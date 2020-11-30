
package rol.myappcompany.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import rol.myappcompany.android_project.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavitagion: BottomNavigationView = findViewById(R.id.btm_nav)

        bottomNavitagion.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.btn_profile -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                            .beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.frame_layout, profileFragment)
                            .commit()
                }
            }
            true

        }

    }
}