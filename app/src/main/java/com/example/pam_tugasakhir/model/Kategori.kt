package com.example.pam_tugasakhir.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kategori(
    @SerialName("id_kategori")
    val idKategori: Int = 0,

    @SerialName("nama_kategori")
    val namaKategori: String,

    @SerialName("deskripsi_kategori")
    val deskripsiKategori: String
)

