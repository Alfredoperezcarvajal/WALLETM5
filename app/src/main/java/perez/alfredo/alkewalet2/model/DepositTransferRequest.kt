package perez.alfredo.alkewalet2.model

data class DepositTransferRequest (
    val type : String,
    val concept : String,
    val amonut : Double
)
