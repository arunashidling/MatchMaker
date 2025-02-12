package com.smb.smbmatchmaker.domain.use_case.get_smbs

import com.smb.smbmatchmaker.common.Resource
import com.smb.smbmatchmaker.data.remote.dto.toSmbList
import com.smb.smbmatchmaker.domain.model.SmbListItem
import com.smb.smbmatchmaker.domain.repository.SmbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getSmbListUseCase @Inject constructor(
    private val repository: SmbRepository
) {
    operator fun invoke() : Flow<Resource<List<SmbListItem>>> = flow{
        try {
            emit(Resource.Loading())
            val smbList = repository.getSmbList().map { it.toSmbList() }
            emit(Resource.Success(smbList))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured")
        )
        }catch (e: IOException){
            emit(Resource.Error("Couldnot reach server"))
        }

    }
}