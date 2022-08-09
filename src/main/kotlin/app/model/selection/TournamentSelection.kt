package app.model.selection

import app.model.individual.Individual
import app.model.individual.Population

private const val DEFAULT_TOURNAMENT_SIZE = 2

class TournamentSelection(
    private val tournamentSize: Int = DEFAULT_TOURNAMENT_SIZE
) : Selection {

    override fun execute(population: Population): Population {
        return population.individuals
            .chunked(tournamentSize)
            .map { participants -> executeLocalTournament(participants) }
            .run { Population(this) }
    }

    private fun executeLocalTournament(participants: List<Individual>): Individual {
        var bestParticipant = participants.first()

        participants.forEach {
            if (it.fitness > bestParticipant.fitness) {
                bestParticipant = it
            }
        }

        return bestParticipant
    }
}