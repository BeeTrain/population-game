package app.model.reproduction

import app.model.individual.Genes
import app.model.individual.Individual
import app.model.individual.Population

class CrossingReproduction : Reproduction {

    override fun execute(population: Population): Population {
        return population.individuals
            .shuffled()
            .asSequence()
            .chunked(2)
            .filter { it.size > 1 }
            .map { Pair(it.first(), it.last()) }
            .map { it.crossing() }
            .flatten()
            .toList()
            .run { Population(this) }
    }

    private fun Pair<Individual, Individual>.crossing(): List<Individual> {
        if (first.genes.values.size < 2 || second.genes.values.size < 2) {
            return emptyList()
        }

        val firstParentGenesFirst = first.genes.values.run {
            subList(0, size + 1 / 2)
        }
        val firstParentGenesSecond = first.genes.values.run {
            subList(size + 1 / 2, size)
        }

        val secondParentGenesFirst = first.genes.values.run {
            subList(0, size + 1 / 2)
        }
        val secondParentGenesSecond = first.genes.values.run {
            subList(size + 1 / 2, size)
        }

        val firstChildGenes = Genes(firstParentGenesFirst + secondParentGenesSecond)
        val secondChildGenes = Genes(secondParentGenesFirst + firstParentGenesSecond)

        return listOf(
            Individual.create(firstChildGenes),
            Individual.create(secondChildGenes)
        )
    }
}