package com.smb.smbmatchmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.smb.smbmatchmaker.presentation.loginscreen.LoginScreen
import com.smb.smbmatchmaker.presentation.ui.theme.CryptocurrencyAppYTTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            CryptocurrencyAppYTTheme  {
                LoginScreen()
            }
        }
    }
}