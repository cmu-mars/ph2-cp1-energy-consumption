package org.sa.rainbow.brass.confsynthesis.ph2.cp1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.sa.rainbow.brass.confsynthesis.Configuration;
import org.sa.rainbow.brass.confsynthesis.ConfigurationProvider;
import org.sa.rainbow.brass.confsynthesis.SimpleConfiguration;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleConfigurationStore implements ConfigurationProvider {

    private Map<String, Configuration> idsToConfigurations = new HashMap<>();
    private String source = PropertiesSimpleConfigurationStore.DEFAULT.getProperty(PropertiesSimpleConfigurationStore.CONFIGURATIONS_SOURCE_PROPKEY);
    private String confPrefix = "sol_";

    @Override
    public void populate() {
        System.out.println("Reading from " + this.source);
        this.loadFromFile(this.source);
    }

    private synchronized void loadFromFile(String confFile) {
        JSONParser parser = new JSONParser();
        Object obj = null;

        try {
            obj = parser.parse(new FileReader(confFile));
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Could not load Configuration File: " + confFile);
        }

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray nodes = (JSONArray) jsonObject.get("configurations");

        for(Object node : nodes) {
            JSONObject jsonNode = (JSONObject) node;
            String c_id = (String) jsonNode.get("config_id");
            Double c_cdr = 0.0, c_speed = 0.0;
            try {
                c_cdr = Double.parseDouble(String.valueOf(jsonNode.get("power_load")));
                c_speed = Double.parseDouble(String.valueOf(jsonNode.get("speed")));
            } catch(Exception e) {
                System.out.println("Error parsing data from configuration " + c_id);
            }

            this.idsToConfigurations.put(this.confPrefix + c_id, new SimpleConfiguration(c_id, c_cdr, c_speed));
            System.out.println("Added configuration " + this.idsToConfigurations.get(this.confPrefix + c_id).getId()
                    + " - Discharge rate: "
                    + String.valueOf(this.idsToConfigurations.get(this.confPrefix + c_id).getEnergyDischargeRate())
                    + " Speed: " + String.valueOf(this.idsToConfigurations.get(this.confPrefix + c_id).getSpeed()));
        }
    }

    @Override
    public HashMap<String, Configuration> getConfigurations() {
        HashMap<String, Configuration> copy = new HashMap<>(this.idsToConfigurations);
        return copy;
    }

    @Override
    public Double getReconfigurationTime(String sourceConfig, String targetConfig) {
        return 1.0;
    }

    @Override
    public List<String> getReconfigurationPath(String sourceConfig, String targetConfig) {
        List<String> res = new ArrayList<>();
        res.add(targetConfig);
        return res;
    }

    @Override
    public Boolean containsConfiguration(String id) {
        return this.idsToConfigurations.containsKey(id);
    }

    @Override
    public String translateId(String id) {
        return id; // Just to comply with the standard ConfigurationProvider interface
    }
}
