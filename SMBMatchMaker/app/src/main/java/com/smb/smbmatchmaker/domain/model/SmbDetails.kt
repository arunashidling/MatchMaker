package com.smb.smbmatchmaker.domain.model

import com.smb.smbmatchmaker.data.remote.dto.TeamMembers

data class SmbDetails(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMembers>

)
