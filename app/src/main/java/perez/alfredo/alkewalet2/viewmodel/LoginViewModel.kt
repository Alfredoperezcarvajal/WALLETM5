package perez.alfredo.alkewalet2.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import perez.alfredo.alkewalet2.GlobalClassApp
import perez.alfredo.alkewalet2.model.LoginRequest
import perez.alfredo.alkewalet2.model.UserResponse
import perez.alfredo.alkewalet2.model.network.ApiClient


class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val loginResultLiveData =
        MutableLiveData<Boolean>() //variable que almacena el resultado del login
    val loadingLiveData = MutableLiveData<Boolean>() // Estado de carga
    val userDataLiveData = MutableLiveData<UserResponse?>() // LiveData para los datos del usuario

    lateinit var accessTokenVm: String

    //aqui creamos el sharedPref para guardalr el token
    private val sharedPreferences = application.getSharedPreferences("AlkeWallet", Context.MODE_PRIVATE)

    //funcion del login
    fun login(email: String, password: String) {
        loadingLiveData.postValue(true) //indicar inicio de carga

        CoroutineScope(Dispatchers.IO).launch {
            try {
                // aqui guardamos la data del response del logiin
                val response = ApiClient.apiService.login(LoginRequest(email, password))

                if (response.accessToken != null) {

                    //almacenar el accessToken
                    accessTokenVm = response.accessToken

                    //guardamos el accesToken en SharedPreferent
                    val editor = sharedPreferences.edit()
                    editor.putString("accessToken", response.accessToken)
                    editor.apply()

                    loginResultLiveData.postValue(true)

                } else {
                    loginResultLiveData.postValue(false)
                }
            } catch (e: Exception) {
                loginResultLiveData.postValue(false)
                Log.e("Errores", "Error: ${e.message}")
            }

        }

    }

    //funcion para obtener los datos del uisuario
    fun getUserData() {
        loadingLiveData.postValue(true) // Indicar inicio de carga

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val respuesta = ApiClient.apiService.getUserData("Bearer $accessTokenVm")
                if (respuesta.isSuccessful) {

                    val dataUsuario = respuesta.body()
                    userDataLiveData.postValue(dataUsuario)

                    //guardamos los datos del usuario en la variable global GlobalClassAPP
                    GlobalClassApp.userLogged = dataUsuario

                } else {
                    userDataLiveData.postValue(null)
                }
            } catch (e: Exception) {
                Log.e("Errores", "Error ${e.message}")
                userDataLiveData.postValue(null)
            }

        }


    }
}

