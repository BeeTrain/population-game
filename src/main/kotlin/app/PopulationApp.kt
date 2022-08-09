package app

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.extension.visibility
import app.model.individual.Population

private const val DEFAULT_MUTATION_CHANCE = 20

private var firstPopulation = Population.create()
private var populationLife = PopulationLife(firstPopulation, DEFAULT_MUTATION_CHANCE)
private var startMessage = "\ncurrent population: $firstPopulation"

@Composable
@Preview
fun PopulationApp() {
    var populationString by remember { mutableStateOf(startMessage) }
    var isInfoWindowVisible by remember { mutableStateOf(false) }

    MaterialTheme {
        Box(Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.TopStart).padding(16.dp)
            ) {
                Text(
                    populationString,
                    color = LocalContentColor.current.copy(alpha = 0.60f),
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                        .visibility(isInfoWindowVisible),

                )
            }
            Row(
                modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)
            ) {
                Button(
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                        populationString = populationLife.runCycle()
                    },
                    content = { Text("Run cycle") }
                )
                Button(
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                        restart()
                        populationString = startMessage
                    },
                    content = { Text("Restart") }
                )
                Button(
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                        isInfoWindowVisible = isInfoWindowVisible.not()
                    },
                    content = { Text(if (isInfoWindowVisible) "Hide" else "Show") }
                )
            }
        }
    }
}

private fun restart() {
    firstPopulation = Population.create()
    populationLife = PopulationLife(firstPopulation, DEFAULT_MUTATION_CHANCE)
    startMessage = "\ncurrent population: $firstPopulation"
}