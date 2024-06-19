package perez.alfredo.alkewalet2.model.network

import perez.alfredo.alkewalet2.model.LoginRequest
import perez.alfredo.alkewalet2.model.LoginResponse
import perez.alfredo.alkewalet2.model.RegisterRequest
import perez.alfredo.alkewalet2.model.RegisterResponse
import perez.alfredo.alkewalet2.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    //Ruta del login es auth/login (Post)
    //ruta del register es users (Post)
    // traer la informacion del usuario con token es auth/me (Get)

    //Login
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    //Registro
    @Headers("Content-Type: application/json")
    @POST("users")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

    @GET("auth/me") //lo vemos con UserResponse
    suspend fun getUserData(@Header("Authorization") token: String): Response<UserResponse>


}