package perez.alfredo.alkewalet2.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import perez.alfredo.alkewalet2.GlobalClassApp
import perez.alfredo.alkewalet2.databinding.ActivityLoginBinding
import perez.alfredo.alkewalet2.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    //aqui declara el viewmodel
    private lateinit var  viewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        binding.btngotocreateacc.setOnClickListener { goToRegisterActivity() }
        binding.btnLoginL.setOnClickListener { login() }

        //observamos el live data del login
        viewModel.loginResultLiveData.observe(this) {loginOk ->
            if (loginOk) {
                //guardamos datos en la variable global
                GlobalClassApp.tokenAccess = viewModel.accessTokenVm

                //ejecutamos funcion para datos del usuario del ViewModel
                viewModel.getUserData()


            } else {
                Toast.makeText(this, "Error en el login", Toast.LENGTH_SHORT).show()
            }

        }

        viewModel.userDataLiveData.observe(this) { userResponse ->
            if (userResponse != null) {
                goToHomePage()
            }else {
                Toast.makeText(this, "Error al obtener los datos del usuario", Toast.LENGTH_SHORT).show()
            }


        }



    }

    private fun goToHomePage() {
        val intent = Intent(this, HomePageActivity::class.java)
        startActivity(intent)
    }

    private fun login() {
        //los dos datos del usuario los guardamos en variable y los convertimos a String
        val emailIngresado = binding.txtemaili.text.toString()
        val passwordIngresado = binding.passsTxt1.text.toString()

        if (emailIngresado != null && passwordIngresado != null) {

            //llamamos al la funcion del login del ViewModel
            viewModel.login(emailIngresado, passwordIngresado)

        }else {
            Toast.makeText(this, "Ingresa bien los datos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun goToRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}