package app.model.selection

import app.model.individual.Population

interface Selection {

    fun execute(population: Population): Population
}