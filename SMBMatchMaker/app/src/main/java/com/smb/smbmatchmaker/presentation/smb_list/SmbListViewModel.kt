package com.smb.smbmatchmaker.presentation.smb_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smb.smbmatchmaker.common.Resource
import com.smb.smbmatchmaker.domain.use_case.get_smbs.getSmbListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SmbListViewModel @Inject constructor(

    private val getSmbListUseCase: getSmbListUseCase
) : ViewModel(){

    private val _state = mutableStateOf(SmbListState())
    val state: State<SmbListState> = _state


    init {
        getSmbList()
    }

    private fun getSmbList(){
        getSmbListUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = SmbListState(smbList = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = SmbListState(error = result.message ?:
                    "An expected error occured")


                }
                is Resource.Loading -> {
                    _state.value = SmbListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
