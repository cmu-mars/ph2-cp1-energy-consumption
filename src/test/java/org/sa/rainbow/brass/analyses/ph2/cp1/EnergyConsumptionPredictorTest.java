package org.sa.rainbow.brass.analyses.ph2.cp1;

import org.junit.Assert;
import org.junit.Test;
import org.sa.rainbow.brass.confsynthesis.Configuration;
import org.sa.rainbow.brass.confsynthesis.ConfigurationProvider;
import org.sa.rainbow.brass.confsynthesis.ph2.cp1.SimpleConfigurationStore;

import java.util.HashMap;

public class EnergyConsumptionPredictorTest {

    @Test
    public void canCompleteTask1() {
        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        boolean res = predictor.canCompleteTask(5.0, 5.0);
        Assert.assertTrue(res);
    }

    @Test
    public void canCompleteTask2() {
        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        boolean res = predictor.canCompleteTask(5.0, 4.0);
        Assert.assertTrue(res);
    }

    @Test
    public void canCompleteTask3() {
        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        boolean res = predictor.canCompleteTask(5.0, 6.0);
        Assert.assertFalse(res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canCompleteTask4() {
        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        boolean res = predictor.canCompleteTask(-2.0, -6.0);
    }

    @Test
    public void getEnergyConsumption1() {
        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        double consumption = predictor.getEnergyConsumption(76, 1);
        Assert.assertEquals(76, consumption, 0.0);
    }

    @Test
    public void getEnergyConsumption2() {
        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        double consumption = predictor.getEnergyConsumption(60, 10);
        Assert.assertEquals(600, consumption, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getEnergyConsumption3() {
        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        double consumption = predictor.getEnergyConsumption(20, 0.0);
    }

    @Test
    public void getEnergyConsumption4() {
        ConfigurationProvider configProvider = new SimpleConfigurationStore();
        configProvider.populate();

        HashMap<String, Configuration> configs = configProvider.getConfigurations();
        Configuration config = configs.get("sol_32");

        EnergyConsumptionPredictor predictor = new EnergyConsumptionPredictor();
        double consumption = predictor.getEnergyConsumption(config, 12);
        Assert.assertEquals(660, consumption, 0.0);
    }
}