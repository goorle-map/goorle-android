package dev.yjyoon.goorle.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.theme.GoorleTheme

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val post: Post =
            requireNotNull(intent.getSerializableExtra(EXTRA_KEY_POST)) as Post

        setContent {
            GoorleTheme {
                DetailScreen(
                    post = post,
                    onBack = ::finish
                )
            }
        }
    }

    companion object {
        val EXTRA_KEY_POST = "post"

        fun startActivity(context: Context, post: Post) {
            val intent = Intent(context, DetailActivity::class.java).putExtra(EXTRA_KEY_POST, post)
            context.startActivity(intent)
        }
    }
}
