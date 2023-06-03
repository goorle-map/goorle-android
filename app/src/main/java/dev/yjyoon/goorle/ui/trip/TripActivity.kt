package dev.yjyoon.goorle.ui.trip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.yjyoon.goorle.ui.theme.GoorleTheme

@AndroidEntryPoint
class TripActivity : ComponentActivity() {

    private val viewModel: TripViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GoorleTheme {
                TripScreen(
                    viewModel = viewModel,
                    onClose = ::finish
                )
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, TripActivity::class.java)
            context.startActivity(intent)
        }
    }
}
