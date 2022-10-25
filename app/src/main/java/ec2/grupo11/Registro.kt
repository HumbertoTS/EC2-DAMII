package ec2.grupo11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import ec2.grupo11.commom.AppMensaje
import ec2.grupo11.commom.TipoMensaje
import ec2.grupo11.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityRegistroBinding
    private val listausuarios = ArrayList<String>()
    private val listahobbies = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cbdeporte.setOnClickListener(this)
        binding.cbpintura.setOnClickListener(this)
        binding.cbotro.setOnClickListener(this)
        binding.btnacceder.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v is CheckBox){
            agregarQuitarHobbies(v)
        }else{
            when(v.id){
                R.id.btnacceder -> {RegistrarUsuario()
                    irListaPersona()}
            }
        }
    }

    private fun RegistrarUsuario() {
        if(validarFormulario()){
            var infopersona = "DNI: " + binding.etdni.text.toString() + "\n " +
                   "Nombres: "+ binding.etnombre.text.toString()+ "\n " +
                    "Apellidos: "+binding.etapellidos.text.toString()+ " \n" +
                    "Correo: "+binding.etemail.text.toString()+ " \n" +
                    "Contraseña: "+binding.etpassword.text.toString() + " \n" +
                    "Género: "+obtenerGeneroSeleccionado() + "\n " +
                    "Habbie: "+listahobbies.toString() + " \n" +
                    "Otro Hobbie: "+binding.etotrohobby.text.toString()
            listausuarios.add(infopersona)
            AppMensaje.enviarMensaje(binding.root,
                "Dr.(a) registrado(a) correctamente",
                TipoMensaje.SUCCESSFULL)
            setearControles()
        }
    }


    private fun agregarQuitarHobbies(checkBox: CheckBox) {
        if(checkBox.isChecked)
            listahobbies.add(checkBox.text.toString())
        else
            listahobbies.remove(checkBox.text.toString())
    }

    private fun irListaPersona() {
        val intentLista = Intent(
            this, ListadoUsuarios::class.java
        ).apply {
            putExtra("listausuario", listausuarios)
        }
        startActivity(intentLista)
    }

    private fun setearControles() {
        listahobbies.clear()
        binding.etdni.setText("")
        binding.etnombre.setText("")
        binding.etapellidos.setText("")
        binding.etemail.setText("")
        binding.etpassword.setText("")
        binding.radioGroup.clearCheck()
        binding.cbdeporte.isChecked = false
        binding.cbpintura.isChecked = false
        binding.cbotro.isChecked = false
        binding.etdni.isFocusableInTouchMode = true
        binding.etdni.requestFocus()
    }

    fun obtenerGeneroSeleccionado(): String{
        var genero = ""
        when(binding.radioGroup.checkedRadioButtonId){
            R.id.rbhombre -> genero = binding.rbhombre.text.toString()
            R.id.rbmujer -> genero = binding.rbmujer.text.toString()
        }
        return genero
    }

    fun validarGenero(): Boolean{
        var respuesta = true
        if(binding.radioGroup.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    fun validarHobbies(): Boolean{
        var respuesta = false
        if(binding.cbdeporte.isChecked || binding.cbpintura.isChecked ||
            binding.cbotro.isChecked){
            respuesta = true
        }
        return respuesta
    }

    fun validarNombreApellido() : Boolean {
        var respuesta = true
        if(binding.etnombre.text.toString().trim().isEmpty()){
            binding.etnombre.isFocusableInTouchMode = true
            binding.etnombre.requestFocus()
            respuesta = false
        }else if (binding.etapellidos.text.toString().trim().isEmpty()){
            binding.etapellidos.isFocusableInTouchMode = true
            binding.etapellidos.requestFocus()
            respuesta = false
        }
        return respuesta
    }

    fun validarFormulario(): Boolean {
        var respuesta = false
        if(!validarNombreApellido()){
            AppMensaje.enviarMensaje(binding.root,
                "Ingrese nombre y apellido", TipoMensaje.ERROR)
        }else if(!validarGenero()){
            AppMensaje.enviarMensaje(binding.root,
                "Seleccione su género", TipoMensaje.ERROR)
        }else if(!validarHobbies()){
            AppMensaje.enviarMensaje(binding.root,
                "Indique un Hobbie", TipoMensaje.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }
}