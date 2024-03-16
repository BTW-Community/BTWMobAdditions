package com.itlesports.mobadditions.entity.mob.wolf;

import btw.entity.mob.WolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityList;
import net.minecraft.src.World;

public class ChestnutWolfEntity extends WolfEntity {

    public ChestnutWolfEntity(World world) {
        super(world);
        this.texture = "/mobadditions/entity/mob/wolf/chestnutwolf.png";
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture() {
        if (isTamed()) {
            if (isStarving()) {
                return "/mobadditions/entity/mob/wolf/chestnutwolf_starving.png";
            }

            return "/mobadditions/entity/wolf/chestnutwolf_tame.png";
        } else if (isAngry()) {
            return "/mobadditions/entity/mob/wolf/chestnutwolf_angry.png";
        } else if (isStarving() || hasAttackTarget()) {
            return "/mobadditions/entity/mob/wolf/chestnutwolf_starving.png";
        }

        return texture; // intentionally bypass super method
    }
    @Override
    public WolfEntity spawnBabyAnimal(EntityAgeable parent )
    {
        return (WolfEntity) EntityList.createEntityOfType(ChestnutWolfEntity.class, worldObj);
    }
}

