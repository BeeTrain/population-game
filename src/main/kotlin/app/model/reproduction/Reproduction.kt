package app.model.reproduction

import app.model.individual.Population

interface Reproduction {

    fun execute(population: Population): Population
}