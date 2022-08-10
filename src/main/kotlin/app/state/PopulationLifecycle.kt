package app.state

import app.model.individual.Population
import app.model.mutation.Mutation
import app.model.mutation.RandomMutation
import app.model.reproduction.CrossingReproduction
import app.model.reproduction.Reproduction
import app.model.selection.FitnessSelection
import app.model.selection.Selection

private const val MUTATION_CHANCE = 20

class PopulationLifecycle(
    firstPopulation: Population = Population.create(),
    private val mutationChance: Int = MUTATION_CHANCE,
    private val selectionMethod: Selection = FitnessSelection(),
    private val reproductionMethod: Reproduction = CrossingReproduction(),
    private val mutationMethod: Mutation = RandomMutation(mutationChance)
) {

    private var currentPopulation = firstPopulation

    private var cycles = 0

    fun runCycle(): String {
        if (currentPopulation.isEmpty()) {
            return "all dead"
        }

        startCycle(cycles)
        cycles++

        val aboutPopulation = when {
            currentPopulation.isEmpty() -> "all dead"
            else -> currentPopulation.toString()
        }

        return "cycle #${cycles}\n" +
                "current population: ${aboutPopulation}"
    }

    private fun startCycle(cycleNumber: Int) {
        println("cycle #${cycleNumber + 1} started")
        println("current population: $currentPopulation")
        println("population size:${currentPopulation.size}")

        selection()
        reproduction()
        mutation()

        println("cycle #${cycleNumber + 1} ended")
        println("\n")
    }

    private fun selection() {
        currentPopulation = selectionMethod.execute(currentPopulation)
        println("after selection: $currentPopulation")
        println("population size:${currentPopulation.size}")
    }

    private fun reproduction() {
        currentPopulation = reproductionMethod.execute(currentPopulation)
        println("after reproduction: $currentPopulation")
        println("population size:${currentPopulation.size}")
    }

    private fun mutation() {
        currentPopulation = mutationMethod.execute(currentPopulation)
        println("after mutation: $currentPopulation")
        println("population size:${currentPopulation.size}")
    }

    fun populationStatus(): String {
        return "\ncurrent population: $currentPopulation"
    }

    fun cycleStatus(): String {
        return "cycle: ${cycles}"
    }

    fun populationSize(): String {
        return "population: ${currentPopulation.size}"
    }
}