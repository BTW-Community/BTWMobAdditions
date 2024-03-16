package com.itlesports.mobadditions.entity.mob.wolf;

import btw.entity.mob.WolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityList;
import net.minecraft.src.World;

public class StripedWolfEntity extends WolfEntity {

    public StripedWolfEntity(World world) {
        super(world);
        this.texture = "/mobadditions/entity/mob/wolf/stripedwolf.png";
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture() {
        if (isTamed()) {
            if (isStarving()) {
                return "/mobadditions/entity/mob/wolf/stripedwolf_starving.png";
            }

            return "/mobadditions/entity/wolf/stripedwolf_tame.png";
        } else if (isAngry()) {
            return "/mobadditions/entity/mob/wolf/stripedwolf_angry.png";
        } else if (isStarving() || hasAttackTarget()) {
            return "/mobadditions/entity/mob/wolf/stripedwolf_starving.png";
        }

        return texture; // intentionally bypass super method
    }
    @Override
    public WolfEntity spawnBabyAnimal(EntityAgeable parent )
    {
        return (WolfEntity) EntityList.createEntityOfType(StripedWolfEntity.class, worldObj);
    }
}

