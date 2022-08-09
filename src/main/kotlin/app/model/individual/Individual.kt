package app.model.individual

data class Individual(val genes: Genes) {

    companion object {

        fun create(genes: Genes = Genes.create()): Individual {
            return Individual(genes)
        }

        fun createPopulation(size: Int): List<Individual> {
            return List(size) { create() }
        }
    }

    val fitness = genes.fitness

    override fun toString(): String {
        return "Individual(fitness=${genes.fitness})"
    }
}