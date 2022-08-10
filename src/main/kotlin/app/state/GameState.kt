package app.state

class GameState {

    var lifecycle = PopulationLifecycle()
        private set

    fun restartGame() {
        lifecycle = PopulationLifecycle()
    }

    fun runCycle() {
        lifecycle.runCycle()
    }
}