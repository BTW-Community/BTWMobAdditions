package com.itlesports.mobadditions;

import btw.AddonHandler;
import btw.BTWAddon;
import com.itlesports.mobadditions.entity.ModEntities;
import com.itlesports.mobadditions.entity.mob.wolf.RustyWolfEntity;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.EntityEggInfo;
import net.minecraft.src.EntityList;

import java.util.Map;

public class MobAdditions extends BTWAddon {
    private static MobAdditions instance = new MobAdditions();
    private Map<String, String> propertyValues;
    private MobAdditions() {
        super("Mob Additions", "0.0.2", "MobAdditions");
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
        this.registerProperty("rustywolfEntityID", "700", "***Entity IDs***\n\n");

    }


    public static MobAdditions getInstance() {
        if (instance == null)
            instance = new MobAdditions();
        return instance;
    }
}
