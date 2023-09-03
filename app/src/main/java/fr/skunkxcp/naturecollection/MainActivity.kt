package fr.skunkxcp.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.skunkxcp.naturecollection.fragments.homeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // charger notre PlantRepository
        val repo = PlantRepository()

        // mettre a jour la liste de plantes
        repo.updateData {

            // injecter le fragment dans notre boite (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, homeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}