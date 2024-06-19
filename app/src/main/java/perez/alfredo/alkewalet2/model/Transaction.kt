package perez.alfredo.alkewalet2.model

data class Transaction (
    val name: String,
    val lastName: String,
    val date: String,
    val amount: String,
    val imgUrl: String? = null

)
