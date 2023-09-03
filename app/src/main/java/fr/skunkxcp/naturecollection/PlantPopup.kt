package fr.skunkxcp.naturecollection

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import fr.skunkxcp.naturecollection.adapter.PlantAdapter

class PlantPopup(
    private val adapter: PlantAdapter
) : Dialog(adapter.context) {

    // injecter le layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_plants_details)
    }
}