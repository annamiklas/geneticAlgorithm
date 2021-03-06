package operators;

import java.util.*;

public class TournamentSelection implements SelectionOperator {

    private final Random rand;
    private final int tournamentFactor;
    private final int populationSize;

    public TournamentSelection(int tournamentFactor, int populationSize, Random rand) {
        this.tournamentFactor = tournamentFactor;
        this.populationSize = populationSize;
        this.rand = rand;
    }

    @Override
    public Integer select(List<Integer> currentFitnessFactor) {
        Set<Integer> randomIndividuals = new HashSet<>();
        while (randomIndividuals.size() < tournamentFactor) {
            randomIndividuals.add(rand.nextInt(populationSize));
        }

        Integer bestFitnessId = -1;
        Integer bestFitness = Integer.MAX_VALUE;

        for (Integer id: randomIndividuals) {
            if (currentFitnessFactor.get(id) < bestFitness) {
                bestFitness = currentFitnessFactor.get(id);
                bestFitnessId = currentFitnessFactor.indexOf(currentFitnessFactor.get(id));
            }
        }

        return bestFitnessId;
    }
}
