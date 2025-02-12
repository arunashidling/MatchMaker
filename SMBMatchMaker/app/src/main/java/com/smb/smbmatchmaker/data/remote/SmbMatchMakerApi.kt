package com.smb.smbmatchmaker.data.remote


import com.smb.smbmatchmaker.data.remote.dto.SmbDetailsDto
import com.smb.smbmatchmaker.data.remote.dto.SmbListDto
import retrofit2.http.GET
import retrofit2.http.Path


interface SmbMatchMakerApi {

    @GET("v1/coins")
    suspend fun getSmbList(): List<SmbListDto>


    @GET("v1/coins/{smbId}")
    suspend fun getSmbByid(@Path("smbId") smbId: String) : SmbDetailsDto
}