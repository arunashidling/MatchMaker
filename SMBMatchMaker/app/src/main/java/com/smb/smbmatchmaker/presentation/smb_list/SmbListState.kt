package com.smb.smbmatchmaker.presentation.smb_list

import com.smb.smbmatchmaker.domain.model.SmbListItem


data class SmbListState(
    val isLoading: Boolean = false,
    val smbList: List<SmbListItem> = emptyList(),
    val error: String = ""
)
