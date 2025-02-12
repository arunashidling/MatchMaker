package com.plcoding.matchmaker.presentation

sealed class Screen(val route: String){
    object SmbListScreen: Screen ("smb_list_screen")
    object SmbDetailScreen: Screen("smb_detail_screen")
    object LoginScreen: Screen("smb_login_screen")
    object CompanyScreen: Screen("company_screen")

}
