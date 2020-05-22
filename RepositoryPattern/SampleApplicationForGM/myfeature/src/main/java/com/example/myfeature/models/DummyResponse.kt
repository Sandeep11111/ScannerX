package com.example.myfeature.models

import com.google.gson.annotations.SerializedName

class DummyResponse {
    @SerializedName("id")
    val id: Long = 0

    @SerializedName("employee_name")
    val name: String? = null

    @SerializedName("employee_salary")
    val salary = 0

}