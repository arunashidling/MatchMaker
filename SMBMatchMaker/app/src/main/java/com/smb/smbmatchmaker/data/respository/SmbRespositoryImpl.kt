package com.smb.smbmatchmaker.data.respository

import com.smb.smbmatchmaker.data.remote.SmbMatchMakerApi
import com.smb.smbmatchmaker.data.remote.dto.SmbDetailsDto
import com.smb.smbmatchmaker.data.remote.dto.SmbListDto
import com.smb.smbmatchmaker.domain.repository.SmbRepository
import javax.inject.Inject

class SmbRespositoryImpl @Inject constructor(
    private val api: SmbMatchMakerApi
) : SmbRepository {
    override suspend fun getSmbList(): List<SmbListDto> {
        val smbList: List<SmbListDto> = api.getSmbList()
        return smbList
    }

    override suspend fun getSmbByid(smbId: String): SmbDetailsDto {
        return api.getSmbByid(smbId)
    }

    override suspend fun login(userName: String, passWord: String): Boolean {
        TODO("Not yet implemented")
    }
}