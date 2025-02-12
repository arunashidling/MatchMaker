package com.smb.smbmatchmaker.presentation.smb_details

import com.smb.smbmatchmaker.domain.model.SmbDetails

data class SmbDetailState(
    val isLoading: Boolean = false,
    val smbDetails: SmbDetails? = null,
    val error: String = ""
)