package com.smb.smbmatchmaker.presentation.smb_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smb.smbmatchmaker.common.Constants
import com.smb.smbmatchmaker.common.Resource
import com.smb.smbmatchmaker.domain.use_case.get_smb.getSmbDetailUseCase
import com.smb.smbmatchmaker.presentation.smb_details.SmbDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SmbDetailViewModel @Inject constructor(

    private val getSmbDetailUseCase: getSmbDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf(SmbDetailState())
    val state: State<SmbDetailState> = _state


    init {
        savedStateHandle.get<String>(Constants.SMB_ID)?.let {
            smbId -> getSmbDetail(smbId)
        }
    }

    private fun getSmbDetail(smbId: String){
        getSmbDetailUseCase(smbId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = SmbDetailState(smbDetails = result.data)

                }
                is Resource.Error -> {
                    _state.value = SmbDetailState(error = result.message ?:
                    "An expected error occured")


                }
                is Resource.Loading -> {
                    _state.value = SmbDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
