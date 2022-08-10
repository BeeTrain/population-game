package app.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update

class GameState {

    var lifecycle = PopulationLifecycle()
        private set

    var populationStatusState = mutableStateOf(lifecycle.populationStatus())
    var cycleStatusState = mutableStateOf(lifecycle.cycleStatus())
    var populationSizeState = mutableStateOf(lifecycle.populationSize())

    fun restartGame() {
        lifecycle = PopulationLifecycle()
        updateStates()
    }

    fun runCycle() {
        lifecycle.runCycle()
        updateStates()
    }

    private fun updateStates() {
        populationStatusState.update(lifecycle.populationStatus())
        cycleStatusState.update(lifecycle.cycleStatus())
        populationSizeState.update(lifecycle.populationSize())
    }
}