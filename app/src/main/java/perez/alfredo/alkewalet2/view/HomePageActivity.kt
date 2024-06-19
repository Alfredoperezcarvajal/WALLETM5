package perez.alfredo.alkewalet2.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import perez.alfredo.alkewalet2.view.adapter.ListTransactionAdapter
import perez.alfredo.alkewalet2.databinding.ActivityHomePageBinding
import perez.alfredo.alkewalet2.model.Transaction

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Botones para ir a las actividades
        binding.boton2.setOnClickListener { goToSendMoney() }
        binding.boton3.setOnClickListener { goToAddMoney() }
        binding.imageView2.setOnClickListener { goToProfile()}

        //vamos a crear la lista de usuarios y transacciones
        val transacciones = arrayOf(
            Transaction("Pedro", "Picapiedra", "22-05-2024", "$100.00","https://i.ibb.co/XpXGQRv/user-1.png"),
            Transaction("John", "Doe", "2024-05-20", "$100.00","https://i.ibb.co/8Kr66KJ/user-2.png"),
            Transaction("Jane", "Smith", "2024-05-21", "$200.00","https://i.ibb.co/k2ZWbh7/user-3.png"),
            Transaction("Alice", "Johnson", "2024-05-22", "-$150.00","https://i.ibb.co/QbmNchQ/user-4.png"),
            Transaction("Bob", "Brown", "2024-05-23", "$250.00","https://i.ibb.co/1vFsvdF/user-5.png"),
            Transaction("Charlie", "Davis", "2024-05-24", "$300.00","https://randomuser.me/api/portraits/men/43.jpg"),
            Transaction("Pedro", "Picapiedra", "22-05-2024", "$100.00","https://randomuser.me/api/portraits/men/1.jpg"),
            Transaction("John", "Doe", "2024-05-20", "-$100.00","https://randomuser.me/api/portraits/women/3.jpg"),
            Transaction("Jane", "Smith", "2024-05-21", "$200.00","https://randomuser.me/api/portraits/women/13.jpg")

        )

        //aqui vamos a crear el adaptador
        val adapter = ListTransactionAdapter(transacciones.toList())
        binding.recyclertransferencia.adapter = adapter
        binding.recyclertransferencia.layoutManager = LinearLayoutManager(this)

    }

    private fun goToProfile() {
        println("nada")
    }

    private fun goToAddMoney() {
        val i = Intent(this, RequestMoneyActivity::class.java)
        startActivity(i)
    }

    private fun goToSendMoney() {
        println("nada")
    }
}