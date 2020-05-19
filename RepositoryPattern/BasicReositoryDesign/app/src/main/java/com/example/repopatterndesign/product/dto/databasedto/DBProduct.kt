package com.example.repopatterndesign.dto.databasedto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class DBProduct(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "nowPrice")
    val nowPrice: Double,
    @ColumnInfo(name = "wasPrice")
    val wasPrice: Double
) {
}