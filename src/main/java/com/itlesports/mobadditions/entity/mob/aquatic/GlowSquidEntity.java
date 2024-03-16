package com.itlesports.mobadditions.entity.mob.aquatic;

import btw.BTWMod;
import btw.entity.mob.SquidEntity;
import btw.item.BTWItems;
import com.itlesports.mobadditions.item.ModItems;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.NBTTagCompound;

public class GlowSquidEntity extends SquidEntity {


    public GlowSquidEntity(World world) {
        super(world);
        this.texture = "/mobadditions/entity/mob/aquatic/glowsquid.png";
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        int worldTime = (int) (this.worldObj.worldInfo.getWorldTime() % 24000L);

        if (worldTime > 17500 && worldTime < 18500) //
        {
            this.setSquidType(1);
        }
    }
        public void initCreature() {
            int worldTime = (int)(this.worldObj.worldInfo.getWorldTime() % 24000L);

            if (worldTime > 17500  && worldTime < 18500) //this.getRNG().nextInt(20) == 0  !this.worldObj.isDaytime() this.worldObj.getMoonPhase()
            {
                this.setSquidType(1);
            }
            else this.setSquidType(0);
        }
        public String getTexture()
        {
            if (this.getSquidType() == 1) {
                return "/mobadditons/entity/aquatic/glowsquid.png";
            }
            else return super.getTexture();
        }
    @Override
    protected void dropFewItems(boolean var1, int var2)
    {
        //Ink Sacks
        /**
         int var3 = this.rand.nextInt(3 + var2) + 1;

         for (int var4 = 0; var4 < var3; ++var4)
         {
         this.entityDropItem(new ItemStack(Item.dyePowder, 1, 0), 0.0F);
         }
         */

        //Shards
        /**
         var3 = this.rand.nextInt(3 + var2) + 1;

         for (int var4 = 0; var4 < var3; ++var4)
         {
         this.entityDropItem(new ItemStack(DecoDefs.PrismarineShard, 1, 0), 0.0F);
         }
         */

        //Glands
        if (this.rand.nextInt(8) - var2 <= 0)
        {
            this.dropItem(BTWItems.mysteriousGland.itemID, 1);
        }

        if (this.getSquidType() == 1 && this.worldObj.provider.dimensionId != -1) //not nether and normal squid
        {
            ///Glow Ink Sacks
            int var3 = this.rand.nextInt(3 + var2) + 1;

            for (int var6 = 0; var6 < var3; ++var6)
            {
                this.entityDropItem(new ItemStack(ModItems.glowInkSac, 1, 0), 0.0F);
            }
        }

    }
        protected void entityInit()
        {
            super.entityInit();
            this.dataWatcher.addObject(16, new Byte((byte)0));
        }
        public int getSquidType() {
            return this.dataWatcher.getWatchableObjectByte(16);
        }
        public void setSquidType(int par1) {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)par1));

        }
        public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.readEntityFromNBT(par1NBTTagCompound);

            if (par1NBTTagCompound.hasKey("SquidType"))
            {
                byte var2 = par1NBTTagCompound.getByte("SquidType");
                this.setSquidType(var2);
            }
        }
        public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.writeEntityToNBT(par1NBTTagCompound);
            par1NBTTagCompound.setByte("SquidType", (byte)this.getSquidType());
        }

        public boolean DoesGlow()
        {
            if (this.getSquidType() == 1 ) {
                return true;
            }
            return false;
        }
    }

