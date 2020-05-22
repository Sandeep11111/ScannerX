package com.example.networkutil

import com.google.gson.GsonBuilder

class GsonUtil {
    fun buildGson(): GsonBuilder {
        return GsonBuilder().setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
    }

    companion object {
        val instance = GsonUtil()
    }
}