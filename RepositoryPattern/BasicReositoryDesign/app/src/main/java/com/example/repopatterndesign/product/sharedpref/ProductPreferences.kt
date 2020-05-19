package com.example.repopatterndesign.sharedpref

import com.example.repopatterndesign.dto.networkdto.NetworkProduct
import com.example.repopatterndesign.product.result.Result
import io.reactivex.Single

/**
 * A DataSource for the SharedPreferences
 */
interface ProductPreferences {
    fun isFavourite(id: String?): Boolean
    fun getFavourites(): List<String>
}