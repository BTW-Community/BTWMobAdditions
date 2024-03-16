package com.itlesports.mobadditions.entity;

import com.itlesports.mobadditions.entity.mob.wolf.*;

import net.minecraft.src.EntityList;

public class ModEntities {
    public static void createModEntityMappings() {
        EntityList.addMapping(AshenWolfEntity.class,"ashenwolfEntity", 0,0,0);
        EntityList.addMapping(BlackWolfEntity.class,"blackwolfEntity", 0,0,0);
        EntityList.addMapping(ChestnutWolfEntity.class,"chestnutwolfEntity", 0,0,0);
        EntityList.addMapping(RustyWolfEntity.class,"rustywolfEntity", 0,0,0);
        EntityList.addMapping(SnowyWolfEntity.class,"snowywolfEntity", 0,0,0);
        EntityList.addMapping(SpottedWolfEntity.class,"spottedwolfEntity", 0,0,0);
        EntityList.addMapping(StripedWolfEntity.class,"stripedwolfEntity", 0,0,0);
        EntityList.addMapping(WoodsWolfEntity.class,"woodswolfEntity", 0,0,0);
    }
}
