package dev.yjyoon.goorle.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dev.yjyoon.goorle.ui.theme.GoorleTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoorleTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
