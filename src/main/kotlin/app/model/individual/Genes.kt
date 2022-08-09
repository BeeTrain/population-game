package app.model.individual

import kotlin.random.Random

data class Genes(val values: List<Gene>) {

    companion object {

        private const val DEFAULT_SIZE = 10

        fun create(size: Int = DEFAULT_SIZE): Genes {
            return Genes(List(size) { Gene(Random.nextBoolean()) })
        }
    }

    val fitness: Int
        get() = calculateFitness()

    private fun calculateFitness(): Int {
        return values.sumOf { it.value }
    }

    override fun toString(): String {
        return values.toString()
    }
}