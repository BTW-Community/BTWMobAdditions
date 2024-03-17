package com.itlesports.mobadditions.mixin;

import btw.entity.mob.SquidEntity;
import btw.world.util.BlockPos;
import com.itlesports.mobadditions.MobAdditions;
import com.itlesports.mobadditions.entity.ModEntities;
import com.itlesports.mobadditions.init.lighting.GlowSquidLighting;
import net.minecraft.src.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SquidEntity.class)
public abstract class GlowSquidLightingMixin {

    private int dynamicLightUpdateTimer;
    public boolean isglowsquid;
    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(CallbackInfo info) {
        dynamicLightUpdateTimer = 0;
        isglowsquid = false;
    }

    @Inject(method = "onLivingUpdate", at = @At("RETURN"))
    private void onUpdate(CallbackInfo info) {
        SquidEntity squidEntity = (SquidEntity) (Object) this;
        if (!squidEntity.worldObj.isRemote)
        {
            dynamicLightUpdateTimer++;
            if (isglowsquid || dynamicLightUpdateTimer > 3)
            {
                int entityID = ModEntities.GlowSquidEntityID;
                dynamicLightUpdateTimer = 0;
                if (isDynamicLightSource(entityID))
                {
                    isglowsquid =true;
//        			System.out.println(this + " is holding " + getHeldItem());
                }
                else
                {
                    isglowsquid =false;
                }

                if (isglowsquid)
                {
                    BlockPos lightpos = new BlockPos(MathHelper.floor_double( squidEntity.posX ),
                            MathHelper.floor_double(squidEntity.boundingBox.maxY), MathHelper.floor_double( squidEntity.posZ));
//					System.out.println(lightpos.x + "," + lightpos.y + "," + lightpos.z +
//							":" + player.worldObj.getBlockId(lightpos.x, lightpos.y, lightpos.z));
                    if (squidEntity.worldObj.getBlockId(lightpos.x, lightpos.y, lightpos.z) == 0)
                    {
                        squidEntity.worldObj.setBlock(lightpos.x, lightpos.y, lightpos.z,
                                MobAdditions.lightsourcewater.blockID, 0 , 2);
                        squidEntity.worldObj.scheduleBlockUpdate(lightpos.x, lightpos.y, lightpos.z,
                                MobAdditions.lightsourcewater.blockID, GlowSquidLighting.lightSourceTickRate);
                    }
                }
            }
        }

    }
    public boolean isDynamicLightSource(int entityID)
    {
//    	Block.blocksList[itemID].lightValue>0 TODO
        return entityID == ModEntities.GlowSquidEntityID;
    }


}

