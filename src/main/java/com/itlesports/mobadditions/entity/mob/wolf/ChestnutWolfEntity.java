package com.itlesports.mobadditions.entity.mob.wolf;

import btw.entity.mob.WolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityAnimal;
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
    public boolean canMateWith(EntityAnimal par1EntityAnimal)
    {
        if (par1EntityAnimal == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(par1EntityAnimal instanceof ChestnutWolfEntity))
        {
            return false;
        }
        else
        {
            ChestnutWolfEntity var2 = (ChestnutWolfEntity) par1EntityAnimal;
            return !var2.isTamed() ? false : (var2.isSitting() ? false : this.isInLove() && var2.isInLove());
        }
    }
    @Override
    public ChestnutWolfEntity spawnBabyAnimal(EntityAgeable parent)
    {
        ChestnutWolfEntity var2 = (ChestnutWolfEntity) EntityList.createEntityOfType(ChestnutWolfEntity.class, this.worldObj);
        return var2;
    }
    @Override
    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
}

