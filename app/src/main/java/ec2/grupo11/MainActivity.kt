package ec2.grupo11

import android.app.Application
import android.content.Context
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
    }

    //Funciones de Click de botones
    override fun onClick(v: View) {
        when(v.id){
            R.id.btnregistro -> irRegistro()
            //R.id.btnformulario -> irFormulario()
            //R.id.btnlistado -> irListado()
        }
    }

    //Función para pantalla registro
    private fun irRegistro() {
        val registro = Intent(
            this, Registro::class.java
        )
        startActivity(registro)
    }
}



