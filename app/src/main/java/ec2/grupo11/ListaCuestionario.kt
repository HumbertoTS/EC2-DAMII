package ec2.grupo11

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import ec2.grupo11.databinding.ActivityListaCuestionarioBinding
import ec2.grupo11.databinding.ActivityListadoUsuariosBinding

class ListaCuestionario : AppCompatActivity() {
    private lateinit var binding: ActivityListaCuestionarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityListaCuestionarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listapersonas = intent.getSerializableExtra("listaformulario")
                as ArrayList<String>
        val adapter = ArrayAdapter(this,
            R.layout.simple_list_item_1,
            listapersonas)
        binding.lstcuestionario.adapter = adapter
    }
}