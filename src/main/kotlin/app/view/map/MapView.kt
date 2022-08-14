package app.view.map

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun BoxScope.MapView() {
    val data = listOf(
        "\uD83C\uDFDB",
        "\uD83C\uDFEB",
        "\uD83C\uDFE2",
        "\uD83C\uDFEC",
        "\uD83C\uDFE5",
        "\uD83C\uDFE6",
        "\uD83C\uDFE8",
        "\uD83C\uDFEA",
        "\uD83D\uDD4C",
        "\uD83D\uDD4B",
        "\uD83C\uDFE6",
        "\uD83C\uDFE8",
        "\uD83C\uDFEA",
        "\uD83D\uDD4C",
        "\uD83D\uDD4B",
        "\uD83C\uDFE2",
        "\uD83C\uDFEC",
        "\uD83C\uDFE5",
        "\uD83C\uDFE6",
        "\uD83C\uDFE8",
        "\uD83C\uDFEA",
        "\uD83D\uDD4C",
        "\uD83D\uDD4B",
        "\uD83C\uDFE6",
        "\uD83C\uDFE8",
        "\uD83C\uDFEA",
        "\uD83D\uDD4C",
        "\uD83D\uDD4B",
        "\uD83C\uDFEA",
        "\uD83D\uDD4C",
        "\uD83D\uDD4B",
        "\uD83C\uDFE6"
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(4),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.align(Alignment.TopStart)
            .padding(top = 38.dp)
            .widthIn(50.dp, 580.dp)
    ) {
        items(items = data) { item ->
            Card(
                modifier = Modifier.padding(4.dp)
                    .width(50.dp)
                    .height(50.dp),
                backgroundColor = Color(
                    red = Random.nextInt(0, 255),
                    green = Random.nextInt(0, 255),
                    blue = Random.nextInt(0, 255)
                )
            ) {
                Text(
                    text = item,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}