package com.itlesports.mobadditions.entity.mob.rideable;
import net.minecraft.src.*;
final class EntityHorseBredSelector implements IEntitySelector
{
    /**
     * Return whether the specified entity is applicable to this filter.
     */
    public boolean isEntityApplicable(Entity par1Entity)
    {
        return par1Entity instanceof HorseEntity && ((HorseEntity)par1Entity).func_110205_ce();
    }
}