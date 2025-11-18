package es.etg.dam.pmdm.recyclerview.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.etg.dam.pmdm.recyclerview.R
import es.etg.dam.pmdm.recyclerview.data.DataAdapter
import es.etg.dam.pmdm.recyclerview.view.viewModel.item.ItemViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtengo la view del RecyclerView
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        // Creamos el dataset
        val data = ArrayList<ItemViewModel>()
        for (i in 1..20) {
            val image = android.R.drawable.arrow_up_float
            val descripcion = "Descripción elemento $i"
            data.add(ItemViewModel(image, descripcion))
        }

        // Creamos el adaptador
        val adapter = DataAdapter(data)

        // Configuramos el click listener
        adapter.setOnClickListener(object : DataAdapter.OnClickListener {
            override fun onClick(position: Int, model: ItemViewModel) {
                val msg: String = "Ha seleccionado el elemento ${model.descripcion}"
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
        })

        // Definimos la gestión del layout
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Establecemos el adaptador al recyclerView
        recyclerview.adapter = adapter
    }
}