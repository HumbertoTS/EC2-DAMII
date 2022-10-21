package ec2.grupo11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ec2.grupo11.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnregistro.setOnClickListener {
            startActivity(Intent(this, Registro::class.java))
        }

        binding.btnformulario.setOnClickListener {
            startActivity(Intent(this, Formulario::class.java))
        }

        //val irRegistro = binding.btnregistro
        /*irRegistro.setOnClickListener(){
            val registro = Intent(this, Registro::class.java)
            startActivity(registro)
        }*/

    }
/*
    override fun onClick(view: View) {
            when(view.id){
                R.id.btnregistro -> irRegistro()
                //R.id.btnregistrar -> registrarPersona()
            }
        }

    private fun irRegistro() {

        val intentLista = Intent(
            this, Registro::class.java
        ).apply {

        }
        startActivity(intentLista)
    }
*/



}





