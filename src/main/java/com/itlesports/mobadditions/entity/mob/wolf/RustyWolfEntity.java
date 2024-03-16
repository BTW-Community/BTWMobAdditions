package com.itlesports.mobadditions.entity.mob.wolf;

import btw.entity.mob.WolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.World;

public class RustyWolfEntity extends WolfEntity {

    public RustyWolfEntity(World world) {
        super(world);
        this.texture = "/mobadditions/entity/mob/wolf/rustywolf.png";
    }
    @Override
    public String getTexture()
    {
        if ( isTamed() )
        {
            if ( isStarving() )
            {
                return "/mobadditions/entity/mob/wolf/rustywolf_starving.png";
            }

            return "/mobadditions/entity/wolf/rustywolf_tame.png";
        }
        else if ( isAngry() )
        {
            return "/mobadditions/entity/mob/wolf/rustywolf_angry.png";
        }
        else if ( isStarving() || hasAttackTarget())
        {
            return "/mobadditions/entity/mob/wolf/rustywolf_starving.png";
        }

        return texture; // intentionally bypass super method
    }
}
