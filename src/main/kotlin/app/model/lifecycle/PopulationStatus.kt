package app.model.lifecycle

import app.extension.zeroOrLess
import app.model.individual.Population

sealed class PopulationStatus(open val people: Int) {

    object Extinction : PopulationStatus(0) {

        override fun toString(): String {
            return "Population became extinct"
        }
    }

    data class Survival(override val people: Int) : PopulationStatus(people)
}

fun getPopulationStatus(population: Population): PopulationStatus {
    return when {
        population.size.zeroOrLess() -> PopulationStatus.Extinction
        else -> PopulationStatus.Survival(population.size)
    }
}