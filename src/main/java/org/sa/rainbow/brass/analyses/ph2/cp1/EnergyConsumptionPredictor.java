package org.sa.rainbow.brass.analyses.ph2.cp1;

import org.sa.rainbow.brass.confsynthesis.Configuration;

public class EnergyConsumptionPredictor {

//    public double energyConsumption(String configID, double powerConsumption, double speed)      "config_id": "432",
//                                       "power_load": 76,
//                                       "speed": 0.7) {
//
//    }

    // TODO check the signature
    public double energyConsumption(Configuration config, double time, String configID) {
        // TODO get energyConsumption of current configuration
        // TODO multiply the energyConsumption by the time to do all tasks
        // TODO return energyConsumption that will be consumed

        throw new UnsupportedOperationException("Implement");
    }

    /**
     * Get the energy consumed in a given time period.
     *
     * @param powerLoad
     * @param time
     * @return
     */
    public double getEnergyConsumption(double powerLoad, double time) {
        if(powerLoad <= 0.0) {
            throw new IllegalArgumentException("The power load has to be greater than 0");
        }

        if(time == 0.0) {
            throw new IllegalArgumentException("There are no more tasks to do");
        }

        if(time < 0.0) {
            throw new IllegalArgumentException("The time to complete tasks cannot be negative");
        }

        double energy = powerLoad * time;
        return energy;
    }

    /**
     * Check if the task can be completed based on the energyConsumption that will be consumed and the current energyConsumption.
     *
     * @param curEnergy
     * @param energyConsumed
     * @return
     */
    public boolean canCompleteTask(double curEnergy, double energyConsumed) {
        if(curEnergy < 0.0) {
            throw new IllegalArgumentException("The current energy cannot be less than 0");
        }

        if(curEnergy == 0.0) {
            throw new IllegalArgumentException("The battery is empty");
        }

        if(energyConsumed <= 0.0) {
            throw new IllegalArgumentException("The energy consumed has to be greater than 0");
        }

        return curEnergy >= energyConsumed;
    }

}
