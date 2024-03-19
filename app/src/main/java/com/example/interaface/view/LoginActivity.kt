package com.example.interaface.view



import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.interaface.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.txtEmail.text.toString()
            val password = binding.txtPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                fazerLogin(username, password)

            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun fazerLogin(username: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {

                val loginData = ApiClient.apiService.loginUser(username, password)
                exibirMensagem("Login successfully!")
                val intent = Intent(this@LoginActivity, DynamicButtonsActivity::class.java)
                startActivity(intent)

            } catch (e: Exception) {

                exibirMensagem("Failed to log in: ${e.message}")
            }
        }
    }

    private fun exibirMensagem(message: String) {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}


