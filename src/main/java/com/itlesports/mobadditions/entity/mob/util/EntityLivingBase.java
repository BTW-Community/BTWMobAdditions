package com.itlesports.mobadditions.entity.mob.util;

import com.itlesports.mobadditions.entity.mob.util.attributes.BaseAttributeMap;
import net.minecraft.src.Entity;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityLivingBase extends Entity {
    public float renderYawOffset;
    public float moveForward;
    public float moveStrafing;
    private BaseAttributeMap attributeMap;

    public EntityLivingBase(World par1World) {
        super(par1World);

    }

    @Override
    protected void entityInit() {
    }




    protected boolean isAIEnabled()
    {
        return false;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound var1) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound var1) {

    }
}
