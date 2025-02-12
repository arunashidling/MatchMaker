package com.smb.smbmatchmaker.di


import com.smb.smbmatchmaker.common.Constants
import com.smb.smbmatchmaker.data.remote.SmbMatchMakerApi
import com.smb.smbmatchmaker.data.respository.SmbRespositoryImpl
import com.smb.smbmatchmaker.domain.repository.SmbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule  {


    @Provides
    @Singleton
    fun provideSmbMatchMakerApi() : SmbMatchMakerApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SmbMatchMakerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSmbRepository (api: SmbMatchMakerApi): SmbRepository {
        return SmbRespositoryImpl(api)
    }

}