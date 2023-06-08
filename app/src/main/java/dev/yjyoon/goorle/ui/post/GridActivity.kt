package dev.yjyoon.goorle.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.yjyoon.goorle.ui.map.MapActivity
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.theme.GoorleTheme

@AndroidEntryPoint
class GridActivity : ComponentActivity() {

    private val viewModel: GridViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type: GridViewType =
            requireNotNull(intent.getSerializableExtra(EXTRA_KEY_TYPE)) as GridViewType

        setContent {
            GoorleTheme {
                GridScreen(
                    viewModel = viewModel,
                    type = type,
                    onBack = ::finish,
                    navigateToDetail = ::startDetailActivity,
                    navigateToMap = ::startMapActivity
                )
            }
        }
    }

    private fun startDetailActivity(post: Post) = DetailActivity.startActivity(this, post)
    private fun startMapActivity() = MapActivity.startActivity(this)

    companion object {
        val EXTRA_KEY_TYPE = "type"

        fun startActivity(context: Context, type: GridViewType) {
            val intent = Intent(context, GridActivity::class.java).putExtra(EXTRA_KEY_TYPE, type)
            context.startActivity(intent)
        }
    }
}
