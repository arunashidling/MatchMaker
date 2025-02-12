package com.smb.smbmatchmaker.domain.use_case.login

import com.smb.smbmatchmaker.common.Resource
import com.smb.smbmatchmaker.domain.model.SmbLogin
import com.smb.smbmatchmaker.domain.repository.SmbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: SmbRepository
) {
    operator fun invoke(userName: String, password: String ) : Flow<Resource<Boolean>> = flow{
        try {
            emit(Resource.Loading())
            val smbLogin = repository.login(userName, password)
            emit(Resource.Success(smbLogin))
        }catch (e: HttpException){
            emit(
                Resource.Error(e.localizedMessage ?: "An unexpected error occured")
            )
        }catch (e: IOException){
            emit(Resource.Error("Couldnot reach server"))
        }

    }
}