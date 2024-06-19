package perez.alfredo.alkewalet2.view

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import perez.alfredo.alkewalet2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //definimos Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Declaramos e instanciamos las variables
        binding.goToLogin.setOnClickListener { irAlLogin() }
        binding.buttonAddAccount.setOnClickListener { irAlRegistro() }
    }

    private fun irAlRegistro() {
        val i = Intent (this, RegisterActivity::class.java)
        startActivity(i)
    }


    // creamos la funcion ir al login
    private fun irAlLogin() {
        val i = Intent (this, LoginActivity::class.java)
        startActivity(i)
    }

}

