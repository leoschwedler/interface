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
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.example.interaface.api.ApiTokenDAO
import com.example.interaface.model.LoginData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DynamicButtonsActivity : AppCompatActivity() {

    private lateinit var dao : ApiTokenDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_buttons)
        dao = ApiTokenDAO(applicationContext)
        val token : String? = dao.getToken()
        val service = secondRequest.apiService
        GlobalScope.launch {
            val response = service.fetchWaterPermissions(token)
            Log.i("GETTOKEN", "o json porra: ${response.body()}")
        }
    }
}

