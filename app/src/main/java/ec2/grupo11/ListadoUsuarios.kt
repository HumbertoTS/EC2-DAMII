package ec2.grupo11

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import ec2.grupo11.databinding.ActivityListadoUsuariosBinding

class ListadoUsuarios : AppCompatActivity() {

    private lateinit var binding: ActivityListadoUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityListadoUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listapersonas = intent.getSerializableExtra("listausuario")
                as ArrayList<String>
        val adapter = ArrayAdapter(this,
            R.layout.simple_list_item_1,
            listapersonas)
        binding.lstpersonas.adapter = adapter
    }
}