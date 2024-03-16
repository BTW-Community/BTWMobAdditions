package com.itlesports.mobadditions.entity;

import btw.BTWMod;
import com.itlesports.mobadditions.MobAdditions;
import com.itlesports.mobadditions.entity.mob.wolf.RustyWolfEntity;

import net.minecraft.src.EntityList;

public class ModEntities {
    public static void createModEntityMappings() {
        EntityList.addMapping(RustyWolfEntity.class,"rustywolfEntity", 0,0,0);
    }
}
