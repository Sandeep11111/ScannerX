package com.example.repopatterndesign.service

import com.example.repopatterndesign.dto.networkdto.NetworkProduct
import io.reactivex.Single

interface ProductApiService {
    fun getProducts(): Single<com.example.repopatterndesign.product.result.Result<List<NetworkProduct>>>
    fun getWishlist(productIds: List<String>): Single<com.example.repopatterndesign.product.result.Result<List<NetworkProduct>>>
}