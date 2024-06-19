package perez.alfredo.alkewalet2.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import perez.alfredo.alkewalet2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    //declaramos el binding
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inicializamos el binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //btn_register_r
        binding.btnRegisterR.setOnClickListener { irAlHomePage() }

        //btn_register_to_login
        binding.btnRegisterToLogin.setOnClickListener { irAlLogin() }


    }

    private fun irAlLogin() {
        val irLogin = Intent (this, LoginActivity::class.java)
        startActivity(irLogin)
    }

    private fun irAlHomePage() {
        val i = Intent (this, HomePageActivity::class.java)
        startActivity(i)
    }
}