package fr.skunkxcp.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.skunkxcp.naturecollection.PlantModel
import fr.skunkxcp.naturecollection.R
import fr.skunkxcp.naturecollection.MainActivity


class PlantAdapter(
    private val context: MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    // Boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        // image de la plante
        val planteImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.name_item)
        val plantDescription:TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Recuperer les informations de la plante
        val currentPlant = plantList[position]

        // Utiliser glide pour recuperer l'image a partir de son lien -> composant
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.planteImage)

        // Mettre a jour le nom de la plante
        holder.plantName?.text = currentPlant.name

        // Mettre a jour la description de la plante
        holder.plantDescription?.text = currentPlant.description

        // Verifier si la plante a ete like
        if(currentPlant.liked) {
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }
        else {
            holder.starIcon.setImageResource(R.drawable.ic_unstar)
        }
    }

    override fun getItemCount(): Int = plantList.size
}

