package com.itlesports.mobadditions.entity.mob.wolf;

import btw.entity.mob.WolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.World;

public class RustyWolfEntity extends WolfEntity {

    public RustyWolfEntity(World world) {
        super(world);
        this.texture = "mob/wolf/rustywolf.jpg";
    }
    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture()
    {
        if ( isTamed() )
        {
            if ( isStarving() )
            {
                return "/btwmodtex/fcWolf_tame_starving.png";
            }

            return "/mob/wolf/rustywolf_tame.png";
        }
        else if ( isAngry() )
        {
            return "/mob/wolf/rustywolf_angry.png";
        }
        else if ( isStarving() || hasAttackTarget())
        {
            return "/btwmodtex/fcWolf_wild_starving.png";
        }

        return texture; // intentionally bypass super method
    }
}
