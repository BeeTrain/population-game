package app.model.individual

private const val FIRST_POPULATION_SIZE = 10

data class Population(var individuals: List<Individual>) {

    companion object {

        fun create(
            individuals: List<Individual> = Individual.createPopulation(FIRST_POPULATION_SIZE)
        ): Population {
            return Population(individuals)
        }
    }

    val size: Int
        get() = individuals.size

    fun isEmpty(): Boolean {
        return individuals.isEmpty()
    }

    private fun getFormattedIndividuals(): String {
        return individuals.toString()
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")
            .replace(" ", "\n")
    }

    override fun toString(): String {
        return "size: ${individuals.size}\n${getFormattedIndividuals()}"
    }
}