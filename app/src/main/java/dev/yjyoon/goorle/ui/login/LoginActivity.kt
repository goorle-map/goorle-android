package dev.yjyoon.goorle.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.yjyoon.goorle.ui.main.MainActivity
import dev.yjyoon.goorle.ui.theme.GoorleTheme

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GoorleTheme {
                LoginScreen(navigateToMain = ::startMainActivity)
            }
        }
    }

    private fun startMainActivity() = MainActivity.startActivity(this)

    companion object {
        fun startActivity(context: Context) {
            val intent =
                Intent(context, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
        }
    }
}
