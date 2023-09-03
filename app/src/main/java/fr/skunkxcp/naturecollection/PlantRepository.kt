package fr.skunkxcp.naturecollection

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.skunkxcp.naturecollection.PlantRepository.Singleton.databaseRef
import fr.skunkxcp.naturecollection.PlantRepository.Singleton.plantList

class PlantRepository {

    object Singleton {

        // se connecter a la reference "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        // creer une liste qui va contenir nos plantes
        val plantList = arrayListOf<PlantModel>()
    }

    fun updateData(callback: () -> Unit) {
        // absorber les donnes depuis la databaseRef -> liste de plantes
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                // retirer les anciennes plantes
                plantList.clear()

                // recolter la liste
                // nom générique -> ds -> dataSnapshot (on aurait pu donner n'importe quel nom)
                for (ds in snapshot.children) {
                    // construire un objet plante
                    val plant = ds.getValue(PlantModel::class.java)

                    // verifier que la plante n'est pas null
                    if(plant != null) {
                        plantList.add(plant)
                    }
                }

                // actionner le callback
                callback()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    // mettre a jour un objet plante en bdd
    fun updatePlant(plant: PlantModel) = databaseRef.child(plant.id).setValue(plant)



}