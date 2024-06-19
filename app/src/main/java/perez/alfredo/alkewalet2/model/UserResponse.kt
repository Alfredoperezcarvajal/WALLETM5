package perez.alfredo.alkewalet2.model

//aqui traemos la informacion del usuario
data class UserResponse (
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Long = 1,
    val points: Long = 0
)