package com.itlesports.mobadditions;

import btw.AddonHandler;
import btw.BTWAddon;
import btw.BTWMod;
import btw.entity.BTWEntityMapper;
import com.itlesports.mobadditions.entity.ModEntities;
import com.itlesports.mobadditions.item.ModItems;

import java.util.Map;

public class MobAdditions extends BTWAddon {
    private static MobAdditions instance = new MobAdditions();
    private Map<String, String> propertyValues;
    private MobAdditions() {
        super("Mob Additions", "0.1.0", "Ex");
    }
    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        //ModItems.registerModItems();
        ModEntities.createModEntityMappings();

    }
    @Override
    public void handleConfigProperties(Map<String, String> propertyValues) {
        this.propertyValues = propertyValues;
        registerConfigIDs();
    }
    public int parseID(String name) {
        try {
            return Integer.parseInt(this.propertyValues.get(name));
        }
        catch (NumberFormatException e) {
            if (this.propertyValues.get(name) == null) {
                throw new IllegalArgumentException("Unable to find property " + name + " in addon " + this.addonName);
            }
            else {
                throw new IllegalArgumentException("Invalid id value for property " + name + " in addon " + this.addonName + ". Check for stray whitespace");
            }
        }
    }

    private void registerConfigIDs() {
        this.propertyValues = propertyValues;
        this.registerProperty("rustywolfEntityID", "700", "***Entity IDs***\n\n");
    }

    public static MobAdditions getInstance() {
        if (instance == null)
            instance = new MobAdditions();
        return instance;
    }
}
