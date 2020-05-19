package com.example.repopatterndesign.domainmodels

/**
 * Null Object Pattern
 */
data class Product(
    val id: String,
    val name: String,
    val price: Price
) {

    // value object
    data class Price(
        val nowPrice: Double,
        val wasPrice: Double
    ) {
        companion object {
            val EMPTY = Price(0.0, 0.0)
        }
    }
}