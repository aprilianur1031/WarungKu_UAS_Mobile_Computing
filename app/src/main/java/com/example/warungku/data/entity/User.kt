package com.example.warungku.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "product_code") var productCode: String?,
    @ColumnInfo(name = "product_name") var productName: String?,
    @ColumnInfo(name = "price") var price: String?,
    @ColumnInfo(name = "stock") var stock: String?
    )