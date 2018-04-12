package org.sa.rainbow.brass.analyses.ph2.cp1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
}