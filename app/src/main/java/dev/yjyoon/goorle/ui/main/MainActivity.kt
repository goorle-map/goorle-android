package dev.yjyoon.goorle.ui.main

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.post.DetailActivity
import dev.yjyoon.goorle.ui.post.GridActivity
import dev.yjyoon.goorle.ui.post.GridViewType
import dev.yjyoon.goorle.ui.theme.GoorleTheme
import dev.yjyoon.goorle.ui.trip.TripActivity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoorleTheme {
                MainScreen(
                    viewModel = viewModel,
                    navigateToGrid = ::startGridActivity,
                    navigateToTrip = ::startTripActivity,
                    navigateToDetail = ::startDetailActivity
                )
            }
        }
    }

    private fun startGridActivity(type: GridViewType) = GridActivity.startActivity(this, type)
    private fun startTripActivity() = TripActivity.startActivity(this)
    private fun startDetailActivity(post: Post) =
        DetailActivity.startActivity(this, post)

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java).addFlags(FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
        }
    }
}
