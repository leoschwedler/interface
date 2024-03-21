package com.example.interaface.model

import com.google.gson.annotations.SerializedName

data class LoginData(
    @SerializedName("Token") val token: String,
    @SerializedName("TrackingToken") val trackingToken: String,
    @SerializedName("type") val type: String,
    @SerializedName("block") val block: Boolean,
    @SerializedName("msg") val msg: String,
    @SerializedName("startTimePause") val startTimePause: String,
    @SerializedName("endTimePause") val endTimePause: String,
    @SerializedName("userid") val userId: String
)
