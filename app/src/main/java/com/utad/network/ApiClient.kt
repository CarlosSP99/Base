package com.utad.network

import com.utad.base.model.Ropa
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("products/{id}")
    suspend fun getProductoSingle(
        @Path("id") id: Int
    ): Ropa

    @GET("products/category/electronics")
    suspend fun productoselectronica(
    ): List<Ropa>

    @GET("products/category/jewelery")
    suspend fun productosjoyeria(
    ): List<Ropa>

    @GET("products/category/men's%20clothing")
    suspend fun productoshombre(
    ): List<Ropa>

    @GET("products/category/women's%20clothing")
    suspend fun productosmujer(

    ): List<Ropa>

}