package ec2.grupo11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ec2.grupo11.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnregistro.setOnClickListener(this)
        binding.btnformulario.setOnClickListener(this)
        binding.btnlistado.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnregistro -> irRegistro()
            R.id.btnformulario -> irFormulario()
            R.id.btnlistado -> irListado()
        }
    }

    private fun irRegistro() {
        val registro = Intent(this, Registro::class.java)
        startActivity(registro)
    }

    private fun irFormulario() {
        val formulario = Intent(this,Formulario::class.java)
        startActivity(formulario)
    }

    private fun irListado() {
        val listado = Intent(this, Listado::class.java)
        startActivity(listado)
    }
}





