package com.itlesports.mobadditions.entity.mob.wolf;

import btw.entity.mob.WolfEntity;
import com.itlesports.mobadditions.entity.mob.fox.ArcticFoxEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityList;
import net.minecraft.src.World;

public class BlackWolfEntity extends WolfEntity {

    public BlackWolfEntity(World world) {
        super(world);
        this.texture = "/mobadditions/entity/mob/wolf/blackwolf.png";
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture() {
        if (isTamed()) {
            if (isStarving()) {
                return "/mobadditions/entity/mob/wolf/blackwolf_starving.png";
            }

            return "/mobadditions/entity/wolf/blackwolf_tame.png";
        } else if (isAngry()) {
            return "/mobadditions/entity/mob/wolf/blackwolf_angry.png";
        } else if (isStarving() || hasAttackTarget()) {
            return "/mobadditions/entity/mob/wolf/blackwolf_starving.png";
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
        else if (!(par1EntityAnimal instanceof BlackWolfEntity))
        {
            return false;
        }
        else
        {
            BlackWolfEntity var2 = (BlackWolfEntity)par1EntityAnimal;
            return !var2.isTamed() ? false : (var2.isSitting() ? false : this.isInLove() && var2.isInLove());
        }
    }
    @Override
    public BlackWolfEntity spawnBabyAnimal(EntityAgeable parent)
    {
        BlackWolfEntity var2 = (BlackWolfEntity) EntityList.createEntityOfType(BlackWolfEntity.class, this.worldObj);
        return var2;
    }
    @Override
    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
}

