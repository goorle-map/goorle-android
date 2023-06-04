package dev.yjyoon.goorle.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.yjyoon.goorle.ui.login.LoginActivity
import dev.yjyoon.goorle.ui.theme.GoorleTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GoorleTheme {
                SplashScreen()
            }
        }

        lifecycleScope.launch {
            delay(SPLASH_TIME_MILLIS)
            LoginActivity.startActivity(this@SplashActivity)
        }
    }

    companion object {
        private const val SPLASH_TIME_MILLIS = 1_500L
    }
}
