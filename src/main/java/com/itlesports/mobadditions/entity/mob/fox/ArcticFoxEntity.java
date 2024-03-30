package com.itlesports.mobadditions.entity.mob.fox;

import btw.entity.mob.*;
import btw.entity.mob.behavior.*;
import btw.entity.mob.villager.VillagerEntity;
import btw.item.BTWItems;
import com.itlesports.mobadditions.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;

public class ArcticFoxEntity extends WolfEntity {
    private static final float MOVE_SPEED_AGGRESSIVE = 0.45F;
    private static final float MOVE_SPEED_PASSIVE = 0.3F;
    public ArcticFoxEntity(World world) {
        super(world);
        moveSpeed = MOVE_SPEED_AGGRESSIVE;

        this.texture = "/mobadditions/entity/mob/fox/arcticfox.png";
        tasks.removeAllTasks();
        tasks.addTask( 1, new EntityAISwimming( this ) );
        tasks.addTask( 2, new PanicOnHeadCrabBehavior(this, MOVE_SPEED_AGGRESSIVE));
        tasks.addTask( 3, aiSit );
        tasks.addTask( 4, new EntityAILeapAtTarget( this, 0.4F ) );
        tasks.addTask( 5, new EntityAIAttackOnCollide(this, MOVE_SPEED_PASSIVE, true ));
        tasks.addTask( 6, new EntityAIMate(this, MOVE_SPEED_PASSIVE));
        tasks.addTask( 6, new MultiTemptBehavior(this, MOVE_SPEED_PASSIVE));
        tasks.addTask( 7, new MoveToLooseFoodBehavior(this, MOVE_SPEED_PASSIVE));
        tasks.addTask( 8, new SimpleWanderBehavior(this, MOVE_SPEED_PASSIVE));
        tasks.addTask( 9, new EntityAIBeg( this, 8F ) );
        tasks.addTask( 10, new EntityAIWatchClosest( this, EntityPlayer.class, 8F ) );
        tasks.addTask( 11, new EntityAILookIdle( this ) );

        targetTasks.removeAllTasks();

        targetTasks.addTask( 1, new EntityAIHurtByTarget( this, true ) );

        targetTasks.addTask( 2, new WildWolfTargetIfStarvingOrHostileBehavior( this,
                VillagerEntity.class, 16F, 0, false ) );

        targetTasks.addTask( 2, new WildWolfTargetIfStarvingOrHostileBehavior( this,
                EntityPlayer.class, 16F, 0, false ) );

        targetTasks.addTask( 2, new WildWolfTargetIfHungryBehavior( this,
                ChickenEntity.class, 16F, 0, false ) );

        targetTasks.addTask( 2, new WildWolfTargetIfHungryBehavior( this,
                SheepEntity.class, 16F, 0, false ) );

        targetTasks.addTask( 2, new WildWolfTargetIfHungryBehavior( this,
                PigEntity.class, 16F, 0, false ) );

        targetTasks.addTask( 2, new WildWolfTargetIfStarvingBehavior( this,
                CowEntity.class, 16F, 0, false ) );
    }
    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture() {
        if (isTamed()) {
            if (isStarving()) {
                return "/mobadditions/entity/mob/fox/arcticfox_starving.png";
            }

            return "/mobadditions/entity/mob/fox/arcticfox_tame.png";
        } else if (isAngry()) {
            return "/mobadditions/entity/mob/fox/arcticfox_angry.png";
        } else if (isStarving() || hasAttackTarget()) {
            return "/mobadditions/entity/mob/fox/arcticfox_starving.png";
        }

        return texture; // intentionally bypass super method
    }
    protected String getLivingSound()
    {
        if ( isWildAndHostile() )
        {
            return "entity.mob.fox.growl";
        }
        else if ( this.rand.nextInt(3) == 0 )
        {
            if ( isTamed() && ( dataWatcher.getWatchableObjectInt(18) < 10 || !isFullyFed() ) )
            {
                if ( isStarving() )
                {
                    return "entity.mob.fox.growl";
                }
                else
                {
                    return "entity.mob.fox.whine";
                }
            }
            else
            {
                return "entity.mob.fox.panting";
            }
        }
        else
        {
            return "entity.mob.fox.bark";
        }
    }
    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

    }
    @Override
    protected int getDropItemId()
    {
        if ( !worldObj.isRemote )
        {
            // yummy yummy foxchops

            if ( isBurning() )
            {
                if (worldObj.getDifficulty().shouldBurningMobsDropCookedMeat()) {
                    dropItem(ModItems.cookedFoxChop.itemID, 1);
                }
                else {
                    dropItem(BTWItems.burnedMeat.itemID, 1);
                }
            }
            else
            {
                return ModItems.rawFoxChop.itemID;
            }
        }

        return -1;
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
        else if (!(par1EntityAnimal instanceof ArcticFoxEntity))
        {
            return false;
        }
        else
        {
            ArcticFoxEntity var2 = (ArcticFoxEntity)par1EntityAnimal;
            return !var2.isTamed() ? false : (var2.isSitting() ? false : this.isInLove() && var2.isInLove());
        }
    }
    @Override
    public ArcticFoxEntity spawnBabyAnimal(EntityAgeable parent)
    {
        ArcticFoxEntity var2 = (ArcticFoxEntity) EntityList.createEntityOfType(ArcticFoxEntity.class, this.worldObj);
        return var2;
    }
    @Override
    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
}

