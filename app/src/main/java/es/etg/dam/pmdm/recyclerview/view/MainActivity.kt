package es.etg.dam.pmdm.recyclerview.view

import android.os.Bundle
import android.widget.Toast
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

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        val data = ArrayList<ItemViewModel>()

        for (i in 1..20) {
            val image = android.R.drawable.arrow_up_float
            val descripcion = "Descripción elemento $i"
            data.add(ItemViewModel(image, descripcion))
        }

        val adapter = DataAdapter(data)
        adapter.setOnClickListener(object : DataAdapter.OnClickListener {
            override fun onClick(position: Int, model: ItemViewModel) {
                val msg: String = "Ha seleccionado el elemento ${model.descripcion}"
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
        })
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }
}