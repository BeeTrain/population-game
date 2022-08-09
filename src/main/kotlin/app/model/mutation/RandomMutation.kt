package app.model.mutation

import app.model.individual.Genes
import app.model.individual.Individual
import app.model.individual.Population
import kotlin.random.Random

private const val MAX_CHANCE = 100

class RandomMutation(private val chance: Int) : Mutation {

    override fun execute(population: Population): Population {
        return population.individuals
            .map { individual -> return@map mutateIfNeed(individual) }
            .run { Population(this) }
    }

    private fun mutateIfNeed(individual: Individual): Individual {
        if (needToMutate()) {
            val oldFitness = individual.fitness

            val genes = individual.genes.values.toMutableList()
            val mutationGeneIndex = Random.nextInt(genes.size - 1)
            val mutationGene = genes[mutationGeneIndex].mutate()
            genes[mutationGeneIndex] = mutationGene

            val newIndividual = Individual(Genes(genes))
            println("$newIndividual mutate(old fitness=$oldFitness)")

            return newIndividual
        }

        return individual
    }

    private fun needToMutate(): Boolean {
        return Random.nextInt(MAX_CHANCE) <= chance
    }
}