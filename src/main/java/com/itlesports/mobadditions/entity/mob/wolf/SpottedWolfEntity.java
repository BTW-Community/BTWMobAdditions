package com.itlesports.mobadditions.entity.mob.wolf;

import btw.entity.mob.WolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityList;
import net.minecraft.src.World;

public class SpottedWolfEntity extends WolfEntity {

    public SpottedWolfEntity(World world) {
        super(world);
        this.texture = "/mobadditions/entity/mob/wolf/spottedwolf.png";
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture() {
        if (isTamed()) {
            if (isStarving()) {
                return "/mobadditions/entity/mob/wolf/spottedwolf_starving.png";
            }

            return "/mobadditions/entity/wolf/spottedwolf_tame.png";
        } else if (isAngry()) {
            return "/mobadditions/entity/mob/wolf/spottedwolf_angry.png";
        } else if (isStarving() || hasAttackTarget()) {
            return "/mobadditions/entity/mob/wolf/spottedwolf_starving.png";
        }

        return texture; // intentionally bypass super method
    }
    @Override
    public WolfEntity spawnBabyAnimal(EntityAgeable parent )
    {
        return (WolfEntity) EntityList.createEntityOfType(SpottedWolfEntity.class, worldObj);
    }
}

