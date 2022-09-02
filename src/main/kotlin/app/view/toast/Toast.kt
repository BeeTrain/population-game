package app.view.toast

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.extension.slideInVerticallyReversed
import app.state.AppState

@Composable
fun BoxScope.Toast() {
    val isVisible by remember { AppState.toast.isVisible }
    val toastText by remember { AppState.toast.text }

    Column(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 20.dp)
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVerticallyReversed(),
            exit = fadeOut()
        ) {
            Card(
                backgroundColor = Color.LightGray
            ) {
                Text(
                    text = toastText,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
        }
    }
}