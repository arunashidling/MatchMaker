package com.smb.smbmatchmaker.domain.use_case.get_smb

import com.smb.smbmatchmaker.common.Resource
import com.smb.smbmatchmaker.data.remote.dto.toSmbDetail
import com.smb.smbmatchmaker.domain.model.SmbDetails
import com.smb.smbmatchmaker.domain.repository.SmbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getSmbDetailUseCase @Inject constructor(
    private val repository: SmbRepository
) {
    operator fun invoke(smbId: String) : Flow<Resource<SmbDetails>> = flow{
        try {
            emit(Resource.Loading())
            val smb = repository.getSmbByid(smbId).toSmbDetail()
            emit(Resource.Success(smb))
        }catch (e: HttpException){
            emit(
                Resource.Error(e.localizedMessage ?: "An unexpected error occured")
            )
        }catch (e: IOException){
            emit(Resource.Error("Couldnot reach server"))
        }

    }
}