package org.sa.rainbow.brass.confsynthesis.ph2.cp1;

import java.util.Properties;

public class PropertiesSimpleConfigurationStore {

    public static final String CONFIGURATIONS_SOURCE_PROPKEY = "configsource";
    public static final String CONFIGURATIONS_SOURCE_FILENAME = "config_list.json";
    public static final String CONFIGURATIONS_SOURCE_PATH = System.getProperty("user.dir");

    public static final Properties DEFAULT = new Properties();

    static {
        DEFAULT.setProperty(PropertiesSimpleConfigurationStore.CONFIGURATIONS_SOURCE_PROPKEY, CONFIGURATIONS_SOURCE_PATH + CONFIGURATIONS_SOURCE_FILENAME);
    }
}
