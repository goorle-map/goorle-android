package dev.yjyoon.goorle.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.theme.GoorleWhite

@Composable
fun LoginScreen(
    navigateToMain: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = GoorleWhite),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 55.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_map),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.social_text),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
        Column(
            modifier = Modifier.padding(horizontal = 34.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.social_login_text),
                style = MaterialTheme.typography.bodyMedium
            )
            Image(
                painter = painterResource(id = R.drawable.img_login_kakao),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navigateToMain() }
            )
            Image(
                painter = painterResource(id = R.drawable.img_login_naver),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navigateToMain() }
            )
        }
    }
}
