package com.itlesports.mobadditions.entity;

import com.itlesports.mobadditions.entity.mob.FoxEntity;
import com.itlesports.mobadditions.entity.mob.aquatic.GlowSquidEntity;
import com.itlesports.mobadditions.entity.mob.wolf.*;

import net.minecraft.src.EntityList;

public class ModEntities {
    public static int GlowSquidEntityID = 708;
    public static void createModEntityMappings() {
        EntityList.addMapping(AshenWolfEntity.class,"ashenwolfEntity", 701,0,0);
        EntityList.addMapping(BlackWolfEntity.class,"blackwolfEntity", 702,0,0);
        EntityList.addMapping(ChestnutWolfEntity.class,"chestnutwolfEntity", 703,0,0);
        EntityList.addMapping(RustyWolfEntity.class,"rustywolfEntity", 700,0,0);
        EntityList.addMapping(SnowyWolfEntity.class,"snowywolfEntity", 704,0,0);
        EntityList.addMapping(SpottedWolfEntity.class,"spottedwolfEntity", 705,0,0);
        EntityList.addMapping(StripedWolfEntity.class,"stripedwolfEntity", 706,0,0);
        EntityList.addMapping(WoodsWolfEntity.class,"woodswolfEntity", 707,0,0);
        EntityList.addMapping(FoxEntity.class,"foxEntity", 709,0,0);

        EntityList.addMapping(GlowSquidEntity.class,"glowsquidEntity", GlowSquidEntityID,0x164f4e, 0x4ddaba);
    }
}
