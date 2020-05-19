package com.example.repopatterndesign.repository

import com.example.repopatterndesign.domainmodels.Product
import io.reactivex.Single

interface ProductRepository {
    fun getProducts(): Single<com.example.repopatterndesign.product.result.Result<List<Product>>>
    fun getWishlist(): Single<com.example.repopatterndesign.product.result.Result<List<Product>>>
}