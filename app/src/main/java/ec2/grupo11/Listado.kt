package ec2.grupo11

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import ec2.grupo11.databinding.ActivityListadoBinding

class Listado : AppCompatActivity() {
    private lateinit var binding : ActivityListadoBinding
    override fun onCreate(savedIntanceState:Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(ec2.grupo11.R.layout.activity_listado)
        val arrayAdapter: ArrayAdapter<*>

        val titulo= arrayListOf("Titulo:Medicina Legal\nDescripcion: Libro de medicina 1\nFecha: 2014",
            "Titulo:Medicina forense\nDescripcion: Libro de medicina 2\nFecha: 2014",
            "Titulo:Medicina Fisica y Rehabilitación\nDescripcion: Libro de medicina 3\nFecha: 2015",
            "Titulo:Fisiologia y Geofisica\nDescripcion: Libro de medicina 4\nFecha: 2016",
            "Titulo:Biofisica\nDescripcion: Libro de medicina 5\nFecha: 2020",
            "Titulo:Medicina del Deporte\nDescripcion: Libro de medicina 6\nFecha: 2021",
            "Titulo:Urgencias y Emergencias 1\nDescripcion: Libro de medicina 7\nFecha: 2019",
            "Titulo:Urgencias y Emergencias 2\nDescripcion: Libro de medicina 8\nFecha: 2018",
            "Titulo:La fisica en la medicina\nDescripcion: Libro de medicina 9\nFecha: 2017",
            "Titulo:Diccionario Terminos Medicos\nDescripcion: Libro de medicina 10\nFecha: 2016")

        val lvlistado=findViewById<ListView>(ec2.grupo11.R.id.lvlistado)

        arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1,titulo)
        lvlistado.adapter= arrayAdapter


        lvlistado.setOnItemClickListener(){parent,view,position,id->
            Toast.makeText(this,parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG)
        }
    }
}