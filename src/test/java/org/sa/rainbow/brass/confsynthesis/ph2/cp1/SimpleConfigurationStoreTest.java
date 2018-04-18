package org.sa.rainbow.brass.confsynthesis.ph2.cp1;

import org.junit.Assert;
import org.junit.Test;
import org.sa.rainbow.brass.confsynthesis.ConfigurationProvider;

public class SimpleConfigurationStoreTest {

    @Test
    public void populate() {
        ConfigurationProvider configProvider = new SimpleConfigurationStore();
        configProvider.populate();
        Assert.assertFalse(configProvider.getConfigurations().isEmpty());
    }
}