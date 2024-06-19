package perez.alfredo.alkewalet2

import android.app.Application
import perez.alfredo.alkewalet2.model.UserResponse

//Clase global para guardar datos mientras la app esta abierta!
//a diferencia del sharedPref se borran al cerrar la app!
class GlobalClassApp : Application() {


    companion object{
        //vamos a crear un objeto usuario que estara global al proyecto
        var userLogged : UserResponse? = null

        var tokenAccess : String? = null
    }

    override fun onCreate() {
        super.onCreate()
        userLogged = null
        tokenAccess = null
    }

}