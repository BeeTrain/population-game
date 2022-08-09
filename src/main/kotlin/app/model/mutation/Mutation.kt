package app.model.mutation

import app.model.individual.Population

interface Mutation {

    fun execute(population: Population): Population
}