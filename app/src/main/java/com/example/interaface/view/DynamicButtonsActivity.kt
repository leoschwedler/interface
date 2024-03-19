package com.example.interaface.view

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.interaface.R
import android.bluetooth.BluetoothAdapter
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.example.interaface.model.LoginData

class DynamicButtonsActivity : AppCompatActivity() {

    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_buttons)

        val loginData = LoginData(
            token = "your_token_value",
            trackingToken = "your_tracking_token_value",
            type = "your_type_value",
            block = false,
            msg = "your_msg_value",
            startTimePause = "your_start_time_value",
            endTimePause = "your_end_time_value",
            userId = "your_userId_value"
        )

        val linearLayout = findViewById<LinearLayout>(R.id.linear_layout_buttons)

        loginData.operations.forEach { operation ->
            val button = Button(this)
            button.text = operation
            button.setOnClickListener {
                // Verifica qual botão foi clicado e chama a função correspondente
                when (operation) {
                    "On" -> toggleBluetooth(true)
                    "Off" -> toggleBluetooth(false)
                }
            }
            linearLayout.addView(button)
        }
    }

    private fun toggleBluetooth(turnOn: Boolean) {
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show()
            return
        }

        if (turnOn) {
            // Liga o Bluetooth se o parâmetro turnOn for verdadeiro
            if (!bluetoothAdapter.isEnabled) {
                val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                startActivityForResult(enableBluetoothIntent, REQUEST_ENABLE_BLUETOOTH)
            } else {
                Toast.makeText(this, "Bluetooth já está ligado", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Desliga o Bluetooth se o parâmetro turnOn for falso
            if (bluetoothAdapter.isEnabled) {
                bluetoothAdapter.disable()
                Toast.makeText(this, "Bluetooth desligado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bluetooth já está desligado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ENABLE_BLUETOOTH) {
            if (resultCode == RESULT_OK) {
                // Bluetooth foi ativado com sucesso, mostra uma mensagem
                Toast.makeText(this, "Bluetooth ligado", Toast.LENGTH_SHORT).show()
            } else {
                // Caso contrário, exibe uma mensagem informando que a ativação do Bluetooth falhou
                Toast.makeText(this, "Falha ao ligar o Bluetooth", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQUEST_ENABLE_BLUETOOTH = 1
    }
}

