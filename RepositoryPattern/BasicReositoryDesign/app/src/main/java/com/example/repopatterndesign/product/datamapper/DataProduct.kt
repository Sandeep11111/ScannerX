package com.example.repopatterndesign.datamapper

import com.example.repopatterndesign.dto.networkdto.NetworkProduct

/**
 * A cluster of DTOs to be mapped into a Product
 */
data class DataProduct(
    val networkProduct: NetworkProduct,
    val isFavourite: Boolean
)