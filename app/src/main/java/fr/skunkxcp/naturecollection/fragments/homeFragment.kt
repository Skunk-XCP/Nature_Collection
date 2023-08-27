package fr.skunkxcp.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.skunkxcp.naturecollection.MainActivity
import fr.skunkxcp.naturecollection.PlantModel
import fr.skunkxcp.naturecollection.R
import fr.skunkxcp.naturecollection.adapter.PlantAdapter
import fr.skunkxcp.naturecollection.adapter.PlantItemDecoration

class homeFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // val view =  inflater?.inflate(R.layout.fragment_home, container, false)
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Creer une liste qui va stocker ces plantes
        val plantList = arrayListOf<PlantModel>()

        // enregistrer une premiere plante dans notre liste (pissenlit)
        plantList.add(PlantModel(
            "Pissenlit",
            "jaune soleil",
            "https://media.istockphoto.com/id/951969530/fr/photo/pissenlit.jpg?s=2048x2048&w=is&k=20&c=QGJbh7GNQm0qyQx8_oqCvEt7jvHxJNFDbY-cyChkvqE=",
            false
        ))

        // enregistrer une premiere plante dans notre liste (rose)
        plantList.add(PlantModel(
            "Rose",
            "L'amour",
            "https://cdn.pixabay.com/photo/2014/07/26/23/38/rose-402671_960_720.jpg",
            false
        ))

        // enregistrer une premiere plante dans notre liste (cactus)
        plantList.add(PlantModel(
            "Cactus",
            "Attention ça pique",
            "https://cdn.pixabay.com/photo/2014/05/14/08/14/cactus-343955_960_720.jpg",
            true
        ))

        // enregistrer une premiere plante dans notre liste (tulipe)
        plantList.add(PlantModel(
            "Tulipe",
            "La beauté",
            "https://cdn.pixabay.com/photo/2017/02/15/13/40/tulips-2068692_960_720.jpg",
            false
        ))

        // Recuperer le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList,R.layout.item_horizontal_plant)

        // Recuperer le second recyclerview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}