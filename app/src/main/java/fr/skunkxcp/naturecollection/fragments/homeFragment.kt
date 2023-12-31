package fr.skunkxcp.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.skunkxcp.naturecollection.MainActivity
import fr.skunkxcp.naturecollection.PlantModel
import fr.skunkxcp.naturecollection.PlantRepository.Singleton.plantList
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