package com.example.interaface.api

import android.content.Context

class ApiTokenDAO constructor(
    private val context: Context
) {
    private var cache: String? = null // Alterado de Boolean? para String?

    private val sharedPreferences by lazy {
        context.getSharedPreferences("Token", Context.MODE_PRIVATE)
    }

    fun saveToken(value: String) {
        if (value == cache) return // Verifica se o valor é igual ao cache para evitar escritas desnecessárias

        with(sharedPreferences.edit()) {
            putString("Token", value) // Salva o token como uma String
            apply() // Aplica as mudanças de forma assíncrona
        }
        cache = value // Atualiza o cache
    }

    fun getToken(): String? = cache ?: sharedPreferences.getString("Token", "").also { cache = it }
}
