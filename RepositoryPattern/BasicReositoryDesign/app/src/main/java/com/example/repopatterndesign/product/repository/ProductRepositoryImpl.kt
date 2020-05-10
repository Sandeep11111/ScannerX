package com.example.repopatterndesign.repository

import com.example.repopatterndesign.datamapper.DataProduct
import com.example.repopatterndesign.datamapper.Mapper
import com.example.repopatterndesign.domainmodels.Product
import com.example.repopatterndesign.dto.networkdto.NetworkProduct
import com.example.repopatterndesign.product.result.Result
import com.example.repopatterndesign.product.result.Result.Failure
import com.example.repopatterndesign.service.ProductApiService
import com.example.repopatterndesign.sharedpref.ProductPreferences
import io.reactivex.Single

class ProductRepositoryImpl(
    private val productApiService: ProductApiService,
    private val productPreferences: ProductPreferences,
    private val productDataMapper: Mapper<DataProduct, Product>
) : ProductRepository {

    override fun getProducts(): Single<com.example.repopatterndesign.product.result.Result<List<Product>>> {
        return productApiService.getProducts().map {
            when (it) {
                is Result.Success -> Result.Success(mapProducts(it.value))
                is Failure -> Failure<List<Product>>(it.throwable)
            }
        }
    }

    override fun getWishlist(): Single<com.example.repopatterndesign.product.result.Result<List<Product>>> {
        return productApiService.getWishlist(productPreferences.getFavourites()).map {
            when (it) {
                is Result.Success<List<NetworkProduct>> -> Result.Success(mapWishlist(it.value))
                is Failure -> Failure<List<Product>>(it.throwable)
            }
        }
    }

    private fun mapProducts(networkProductList: List<NetworkProduct>): List<Product> {
        return networkProductList.map {
            productDataMapper.map(DataProduct(it, productPreferences.isFavourite(it.id)))
        }
    }

    private fun mapWishlist(wishlist: List<NetworkProduct>): List<Product> {
        return wishlist.map {
            productDataMapper.map(DataProduct(it, true))
        }
    }
}