package app.model.selection

import app.model.individual.Individual
import app.model.individual.Population

class FitnessSelection : Selection {

    override fun execute(population: Population): Population {
        return Population(population.individuals.filter { it.fitness >= it.survivalValue })
    }

    private val Individual.survivalValue
        get() = genes.values.size / 2
}