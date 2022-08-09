package app.model.individual

data class Gene(val isAdapted: Boolean) {

    val value = calculateValue()

    fun mutate(): Gene {
        return this.copy(isAdapted = isAdapted.not())
    }

    private fun calculateValue(): Int {
        return if (isAdapted) 1 else 0
    }

    override fun toString(): String {
        return value.toString()
    }
}