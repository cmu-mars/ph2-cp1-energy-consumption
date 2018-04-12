package org.sa.rainbow.brass.analyses.ph2.cp1;

import org.sa.rainbow.brass.confsynthesis.Configuration;

public class EnergyConsumptionPredictor {

    // TODO check the signature
    public double energy(Configuration config, double time, String configID) {
        // TODO get energy of current configuration
        // TODO multiply the energy by the time to do all tasks
        // TODO return energy that will be consumed
        throw new UnsupportedOperationException("Implement");
    }

    /**
     * Check if the task can be completed based on the energy that will be consumed and the current energy.
     *
     * @param curEnergy
     * @param energyConsumed
     * @return
     */
    public boolean canCompleteTask(double curEnergy, double energyConsumed) {
        return curEnergy >= energyConsumed;
    }

}
