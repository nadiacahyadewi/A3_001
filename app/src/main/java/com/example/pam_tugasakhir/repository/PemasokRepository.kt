package com.example.pam_tugasakhir.repository

import com.example.pam_tugasakhir.model.Pemasok
import com.example.pam_tugasakhir.service.PemasokService
import okio.IOException

interface PemasokRepository {
    suspend fun insertPemasok(pemasok: Pemasok)

    suspend fun getPemasok(): List<Pemasok>

    suspend fun updatePemasok(idPemasok: String, pemasok: Pemasok)

    suspend fun deletePemasok(idPemasok: String)

    suspend fun getPemasokById(idPemasok: String): Pemasok
}

class NetworkPemasokRepository(
    private val pemasokApiService: PemasokService
) : PemasokRepository {
    override suspend fun insertPemasok(pemasok: Pemasok) {
        pemasokApiService.insertPemasok(pemasok)
    }

    override suspend fun updatePemasok(idPemasok: String, pemasok: Pemasok) {
        pemasokApiService.updatePemasok(idPemasok, pemasok)
    }

    override suspend fun deletePemasok(idPemasok: String) {
        try {
            val response = pemasokApiService.deletePemasok(idPemasok)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete pemasok. HTTP Status Code: " +
                        "${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getPemasok(): List<Pemasok> =
        pemasokApiService.getAllPemasok()

    override suspend fun getPemasokById(idPemasok: String): Pemasok {
        return pemasokApiService.getPemasokById(idPemasok)
    }
}
