package com.smb.smbmatchmaker

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.matchmaker.presentation.Screen
import com.smb.smbmatchmaker.presentation.loginscreen.LoginScreen
import com.smb.smbmatchmaker.presentation.smb_details.SmbDetailScreen
import com.smb.smbmatchmaker.presentation.smb_list.SmbListScreen
import com.smb.smbmatchmaker.presentation.splashscreen.SplashViewModel
import com.smb.smbmatchmaker.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        //splash screen start

        val splashScreen = installSplashScreen().apply {
            setOnExitAnimationListener { viewProvider ->
                ObjectAnimator.ofFloat(
                    viewProvider.view,
                    "scaleX",
                    0.5f, 0f
                ).apply {
                    interpolator = OvershootInterpolator()
                    duration = 300
                    doOnEnd { viewProvider.remove() }
                    start()
                }
                ObjectAnimator.ofFloat(
                    viewProvider.view,
                    "scaleY",
                    0.5f, 0f
                ).apply {
                    interpolator = OvershootInterpolator()
                    duration = 300
                    doOnEnd { viewProvider.remove() }
                    start()
                }
            }
        }

        //end

        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition{
            splashViewModel.isSplashShow.value
        }

       // super.onCreate(savedInstanceState)

        setContent {
             CryptocurrencyAppYTTheme {
                // Surface(color = MaterialTheme.colors.background) {

                     val navController = rememberNavController()
                     NavHost(navController = navController,
                         startDestination = Screen.SmbListScreen.route
                     ){
                         composable(
                             route = Screen.SmbListScreen.route
                         ){
                             SmbListScreen(navController )
                         }

                         composable(
                             route = Screen.SmbDetailScreen.route + "/{coinId}"
                         ){
                             SmbDetailScreen(navController)
                         }

                         composable(
                             route = Screen.LoginScreen.route
                         ){
                             LoginScreen()
                         }
                     }

                 //}
             }
         }
    }
}