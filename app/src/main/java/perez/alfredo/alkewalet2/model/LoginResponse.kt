package perez.alfredo.alkewalet2.model

data class LoginResponse(
    val accessToken: String?,
    val error: String?,
    val status: Int?
)
