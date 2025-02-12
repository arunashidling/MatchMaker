package com.smb.smbmatchmaker.data.remote.dto

import com.smb.smbmatchmaker.domain.model.SmbListItem


data class SmbListDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun SmbListDto.toSmbList(): SmbListItem {
    return SmbListItem(
        id = id,
        isActive = is_active,
        name = name,
        rank = rank,
        symbol = symbol

    )
}