package com.example.repopatterndesign.dto.networkdto

import com.google.gson.annotations.SerializedName

data class NetworkProduct(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nowPrice")
    val nowPrice: Double?,
    @SerializedName("wasPrice")
    val wasPrice: Double?
) {
}