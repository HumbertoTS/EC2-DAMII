package ec2.grupo11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import ec2.grupo11.databinding.ActivityMainBinding
import ec2.grupo11.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {

    private lateinit var binding : ActivityRegistroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)


 //       toolbarapp = findViewById(R.id.toolbarapp)
   //     setSupportActionBar(toolbarapp)

    }
}