package dev.yjyoon.goorle.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.yjyoon.goorle.ui.post.GridActivity
import dev.yjyoon.goorle.ui.post.GridViewType
import dev.yjyoon.goorle.ui.theme.GoorleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoorleTheme {
                MainScreen(
                    viewModel = viewModel,
                    navigateToGrid = ::startGridActivity
                )
            }
        }
    }

    private fun startGridActivity(type: GridViewType) = GridActivity.startActivity(this, type)

}
