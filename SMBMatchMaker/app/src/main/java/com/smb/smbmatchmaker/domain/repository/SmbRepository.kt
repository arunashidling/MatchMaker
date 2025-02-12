package com.smb.smbmatchmaker.domain.repository

import com.smb.smbmatchmaker.data.remote.dto.SmbDetailsDto
import com.smb.smbmatchmaker.data.remote.dto.SmbListDto


interface SmbRepository {

    suspend fun getSmbList(): List<SmbListDto>

    suspend fun getSmbByid(smbId: String): SmbDetailsDto

    suspend fun login(userName: String, passWord: String): Boolean
}