package com.itlesports.mobadditions;

import btw.AddonHandler;
import btw.BTWAddon;

import java.util.Map;

public class MobAdditions extends BTWAddon {
    private static MobAdditions instance = new MobAdditions();
    private Map<String, String> propertyValues;
    private MobAdditions() {
        super("Mob Additions", "0.1.0", "MobAdditions");
    }
    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        //ModItems.registerModItems();


    }
    @Override
    public void handleConfigProperties(Map<String, String> propertyValues) {
        this.propertyValues = propertyValues;
        registerConfigIDs();
    }
    private void registerConfigIDs() {
        this.registerProperty("ashenwolfEntityID", "701", "***Entity IDs***\n\n");
        this.registerProperty("blackwolfEntityID", "702", "***Entity IDs***\n\n");
        this.registerProperty("chestnutwolfEntityID", "703", "***Entity IDs***\n\n");
        this.registerProperty("rustywolfEntityID", "700", "***Entity IDs***\n\n");
        this.registerProperty("snowywolfEntityID", "704", "***Entity IDs***\n\n");
        this.registerProperty("spottedwolfEntityID", "705", "***Entity IDs***\n\n");
        this.registerProperty("stripedwolfEntityID", "706", "***Entity IDs***\n\n");
        this.registerProperty("woodswolfEntityID", "707", "***Entity IDs***\n\n");


    }


    public static MobAdditions getInstance() {
        if (instance == null)
            instance = new MobAdditions();
        return instance;
    }
}
