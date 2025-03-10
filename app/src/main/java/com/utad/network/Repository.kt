package com.utad.network

import com.utad.base.model.Ropa
import javax.inject.Inject

class Repository    @Inject constructor(
    private val apiClient: ApiClient
) {

    suspend fun getProductosHombre(): List<Ropa>{
        return apiClient.productoshombre();
    }
    suspend fun getProductosMujer(): List<Ropa>{
        return apiClient.productosmujer()
    }
    suspend fun getProductosJoyeria(): List<Ropa>{
        return apiClient.productosjoyeria();
    }
    suspend fun getProductosElectronica(): List<Ropa>{
        return apiClient.productoselectronica();
    }

    suspend fun getProductoById(id: Int): Ropa {
        return apiClient.getProductoSingle(id)
    }


}