package dev.yjyoon.goorle.ui.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.R

@Composable
fun CharacterScreen() {

    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = Color(0xFF004370)
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(innerPadding)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_character_content),
                    contentDescription = null
                )
            }
            Image(
                painter = painterResource(id = R.drawable.img_character_topbar),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 60.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }
}
