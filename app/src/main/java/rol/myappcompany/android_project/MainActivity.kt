
package rol.myappcompany.android_project


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import rol.myappcompany.android_project.profile.ProfileFragment
import rol.myappcompany.android_project.restaurants.RestaurantsFragment


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
                R.id.btn_main_screen -> {
                    /*for (fragment in supportFragmentManager.fragments) {
                        supportFragmentManager.beginTransaction().remove(fragment).commit()
                    }*/
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    /*restaurantsFragment = RestaurantsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.frame_layout, restaurantsFragment)
                        .commit()*/
                }
            }
            true

        }
        /*override fun onCreateOptionsMenu(menu: Menu): Boolean{

            menuInflater.inflate(R.menu.search_restaurants, menu)
            val menuItem = menu!!.findItem(R.id.search)

            if(menuItem != null){
                val searchView = menuItem.actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        if(newText!!.isNotEmpty()){
                            displ
                        }



                        return true
                    }


                })
            }

            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean{


            return super.onOptionsItemSelected(item)
        }*/

    }
}