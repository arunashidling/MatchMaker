package com.smb.smbmatchmaker.presentation.companyscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.smb.smbmatchmaker.presentation.ui.theme.CryptocurrencyAppYTTheme


class CompanyDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            CryptocurrencyAppYTTheme  {
                CompanyScreen()
            }
        }
    }
}