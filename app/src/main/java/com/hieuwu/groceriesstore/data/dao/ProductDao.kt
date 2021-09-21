package com.hieuwu.groceriesstore.data.dao

import androidx.room.*
import com.hieuwu.groceriesstore.domain.entities.Product
import com.hieuwu.groceriesstore.utilities.PRODUCT_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Update
    fun update(product: Product)

    @Query("SELECT * FROM $PRODUCT_TABLE WHERE productId = :id")
    fun getById(id: String): Flow<Product>

    @Query("DELETE FROM $PRODUCT_TABLE")
    fun clear()

    @Query("SELECT * FROM $PRODUCT_TABLE LIMIT 10")
    fun getAll(): Flow<List<Product>>

    @Query("SELECT * FROM $PRODUCT_TABLE Where category =:categoryId LIMIT 20")
    fun getAllByCategory(categoryId: String): Flow<List<Product>>

    @Query("SELECT * FROM $PRODUCT_TABLE LIMIT 1")
    fun hasProduct(): Product?
}