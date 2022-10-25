package ec2.grupo11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import ec2.grupo11.commom.AppMensaje
import ec2.grupo11.commom.TipoMensaje
import ec2.grupo11.databinding.ActivityFormularioBinding
import ec2.grupo11.databinding.ActivityRegistroBinding

class Formulario : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityFormularioBinding
    private val listaformulario = ArrayList<String>()
    private val listasintomas = ArrayList<String>()
    private val listaservicios = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cbdisminuciongustoolfato.setOnClickListener(this)
        binding.cbtos.setOnClickListener(this)
        binding.cbdolorgarganta.setOnClickListener(this)
        binding.cbcongestion.setOnClickListener(this)
        binding.cbfiebre.setOnClickListener(this)
        binding.cbninguno.setOnClickListener(this)
        binding.cbluz.setOnClickListener(this)
        binding.cbagua.setOnClickListener(this)
        binding.cbcable.setOnClickListener(this)
        binding.cbinternet.setOnClickListener(this)
        binding.btnresolver.setOnClickListener{RegistrarFormulario()
        irListaFormulario()}
    }

    override fun onClick(v: View) {
        if(v is CheckBox){
           marcarsintomas(v)

        }else if (v is CheckBox){
            marcarservicios(v)
        }
    }

    private fun irListaFormulario() {
        val intentLista = Intent(
            this, ListaCuestionario::class.java
        ).apply {
            putExtra("listaformulario", listaformulario)
        }
        startActivity(intentLista)
    }

    private fun RegistrarFormulario() {
        if(validarFormulario()){
            var rptacuestionario =  "Síntomas: " + listasintomas.toString() + "\n" +
                                "Fiebre: " + obtenerpregunta2() + "\n" +
                                "¿Vive solo?: " + obtenerpregunta3() + "\n" +
                                "¿Adulto mayor en casa?: " + obtenerpregunta4() + "\n" +
                                "Servicios que tiene: " + listaservicios.toString()
            listaformulario.add(rptacuestionario)
            AppMensaje.enviarMensaje(binding.root,
                "Datos registrados correctamente",
                TipoMensaje.SUCCESSFULL)
            seteardatos()
        }

    }

    private fun marcarservicios(v: CheckBox) {
        if(v.isChecked)
            listaservicios.add(v.text.toString())
        else
            listaservicios.remove(v.text.toString())
    }

    private fun marcarsintomas(check: CheckBox) {
        if(check.isChecked)
            listasintomas.add(check.text.toString())
        else
            listasintomas.remove(check.text.toString())
    }

    private fun seteardatos(){
        binding.cbdisminuciongustoolfato.isChecked = false
        binding.cbtos.isChecked = false
        binding.cbdolorgarganta.isChecked = false
        binding.cbcongestion.isChecked = false
        binding.cbfiebre.isChecked = false
        binding.cbninguno.isChecked = false
        binding.cbluz.isChecked = false
        binding.cbagua.isChecked = false
        binding.cbcable.isChecked = false
        binding.cbinternet.isChecked = false
        binding.radioGroup.clearCheck()
        binding.radioGroup2.clearCheck()
        binding.radioGroup3.clearCheck()
    }

    fun obtenerpregunta2(): String{
        var fiebre = ""
        when(binding.radioGroup.checkedRadioButtonId){
            R.id.rbsi -> fiebre = binding.rbsi.text.toString()
            R.id.rbno -> fiebre = binding.rbno.text.toString()
        }
        return fiebre
    }

    fun obtenerpregunta3(): String{
        var vive = ""
        when(binding.radioGroup2.checkedRadioButtonId){
            R.id.rbsi2 -> vive = binding.rbsi2.text.toString()
            R.id.rbno2 -> vive = binding.rbno2.text.toString()
        }
        return vive
    }

    fun obtenerpregunta4(): String{
        var adulto = ""
        when(binding.radioGroup3.checkedRadioButtonId){
            R.id.rbsi3 -> adulto = binding.rbsi3.text.toString()
            R.id.rbno3 -> adulto = binding.rbno3.text.toString()
        }
        return adulto
    }

    fun validarsintomas(): Boolean{
        var respuesta = false
        if(binding.cbdisminuciongustoolfato.isChecked || binding.cbtos.isChecked ||
            binding.cbdolorgarganta.isChecked || binding.cbcongestion.isChecked || binding.cbfiebre.isChecked || binding.cbninguno.isChecked){
            respuesta = true
        }
        return respuesta
    }

    fun validarservicios(): Boolean{
        var respuesta = false
        if(binding.cbluz.isChecked || binding.cbagua.isChecked ||
            binding.cbcable.isChecked || binding.cbinternet.isChecked){
            respuesta = true
        }
        return respuesta
    }

    fun validarpregunta2(): Boolean{
        var respuesta = true
        if(binding.radioGroup.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    fun validarpregunta3(): Boolean{
        var respuesta = true
        if(binding.radioGroup2.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    fun validarpregunta4(): Boolean{
        var respuesta = true
        if(binding.radioGroup3.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    fun validarFormulario(): Boolean {
        var respuesta = false
        if(!validarsintomas()){
            AppMensaje.enviarMensaje(binding.root,
                "Marque sus síntomas", TipoMensaje.ERROR)
        }else if(!validarpregunta2()){
            AppMensaje.enviarMensaje(binding.root,
                "Seleccione su respuesta de la pregunta 2", TipoMensaje.ERROR)
        }
        else if(!validarpregunta3()){
            AppMensaje.enviarMensaje(binding.root,
                "Seleccione su respuesta de la pregunta 3", TipoMensaje.ERROR)
        }else if(!validarpregunta4()){
            AppMensaje.enviarMensaje(binding.root,
                "Seleccione su respuesta de la pregunta 4", TipoMensaje.ERROR)
        }else if(!validarservicios()){
            AppMensaje.enviarMensaje(binding.root,
                "Marque los servicios que tiene", TipoMensaje.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }
}