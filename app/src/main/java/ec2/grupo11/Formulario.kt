package ec2.grupo11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ec2.grupo11.databinding.ActivityFormularioBinding
import ec2.grupo11.databinding.ActivityRegistroBinding

class Formulario : AppCompatActivity() {

    private lateinit var binding : ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}