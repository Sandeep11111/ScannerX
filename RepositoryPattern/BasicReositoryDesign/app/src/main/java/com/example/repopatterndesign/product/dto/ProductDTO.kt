package com.example.repopatterndesign.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * single model for both the network and the database:
 *
 * You may cache more than needed.
   Adding fields to the response will require Database migrations (unless you add an “@Ignore” annotation).
   All the fields that we cache that we shouldn’t send as Request Body will need a “@Transient” annotation.
   Unless we create new fields these must be of the same data type
    (we can’t, for example, parse a nowPrice string from a network response and cache a nowPrice double).
 */
@Entity(tableName = "Product")
data class ProductDTO(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: String?,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String?,
    @ColumnInfo(name = "nowPrice")
    @SerializedName("nowPrice")
    val nowPrice: Double?,
    @ColumnInfo(name = "wasPrice")
    @SerializedName("wasPrice")
    val wasPrice: Double?
)