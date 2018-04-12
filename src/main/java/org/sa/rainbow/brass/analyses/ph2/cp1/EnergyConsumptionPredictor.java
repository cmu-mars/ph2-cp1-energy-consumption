package org.sa.rainbow.brass.analyses.ph2.cp1;

import org.sa.rainbow.brass.confsynthesis.Configuration;

public class EnergyConsumptionPredictor {

    public double energy(Configuration config, double time, String configID) {
throw new UnsupportedOperationException("Implement");
    }

    public boolean canCompleteTask(double curEnergy, double energyConsumed) {
        return curEnergy >= energyConsumed;
    }

}
