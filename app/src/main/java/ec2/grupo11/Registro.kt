package ec2.grupo11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import ec2.grupo11.databinding.ActivityMainBinding

class Registro : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_registro)

 //       toolbarapp = findViewById(R.id.toolbarapp)
   //     setSupportActionBar(toolbarapp)

    }
}