package com.example.interaface.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.interaface.R
import com.example.interaface.databinding.ActivityOptionsBinding

class OptionsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityOptionsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnOption1.setOnClickListener { }
            btnOption2.setOnClickListener { }
            btnOption3.setOnClickListener { }
            btnOption4.setOnClickListener { }
        }
    }
}