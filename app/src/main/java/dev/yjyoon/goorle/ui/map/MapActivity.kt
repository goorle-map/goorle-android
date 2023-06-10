package dev.yjyoon.goorle.ui.map

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.post.DetailActivity
import dev.yjyoon.goorle.ui.theme.GoorleTheme

@AndroidEntryPoint
class MapActivity : ComponentActivity() {

    private val viewModel: MapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoorleTheme {
                MapScreen(
                    onClose = ::finish,
                    viewModel = viewModel,
                    navigateToDetail = ::startDetailActivity
                )
            }
        }
    }

    private fun startDetailActivity(post: Post) =
        DetailActivity.startActivity(this, post)

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MapActivity::class.java)
            context.startActivity(intent)
        }
    }
}
